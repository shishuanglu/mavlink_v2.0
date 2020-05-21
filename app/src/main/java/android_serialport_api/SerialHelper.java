package android_serialport_api;

import android.util.Log;

import com.example.myserial2.been.ComBean;
import com.example.myserial2.data.RingBuff;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;

import android_serialport_api.SerialPort;
import mavlink.MAVLinkDataHandle;
import mavlink.MAVLinkPacket;
import mavlink.Messages.MAVLinkMessage;
import mavlink.Parser;
import mavlink.common.msg_altitude;
import mavlink.common.msg_heartbeat;

/**
 * @author benjaminwan
 *         串口辅助工具类
 */
public abstract class SerialHelper {
    private SerialPort mSerialPort;
    private OutputStream mOutputStream;
    private InputStream mInputStream;
    private ReadThread mReadThread;
    private SendThread mSendThread;
    private String sPort = "/dev/s3c2410_serial0";
    private int iBaudRate = 9600;
    private boolean _isOpen = false;
    private byte[] _bLoopData = new byte[]{0x30};
    private int iDelay = 500;

    MAVLinkPacket recvMavLinkPacket = new MAVLinkPacket(9);
    MAVLinkPacket sendMavLinkPacket = new MAVLinkPacket(9);

    Parser parser = new Parser();

    //----------------------------------------------------
    public SerialHelper(String sPort, int iBaudRate) {
        this.sPort = sPort;
        this.iBaudRate = iBaudRate;
    }

    public SerialHelper() {
        this("/dev/SAC1", 115200);
    }

    public SerialHelper(String sPort) {
        this(sPort, 115200);
    }

    public SerialHelper(String sPort, String sBaudRate) {
        this(sPort, Integer.parseInt(sBaudRate));
    }

    //----------------------------------------------------
    public void open() throws SecurityException, IOException, InvalidParameterException {
        File device = new File(sPort);
        //检查访问权限，如果没有读写权限，进行文件操作，修改文件访问权限
        if (!device.canRead() || !device.canWrite()) {
            try {
                //通过挂在到linux的方式，修改文件的操作权限
                Process su = Runtime.getRuntime().exec("/system/bin/su");
                //一般的都是/system/bin/su路径，有的也是/system/xbin/su
                String cmd = "chmod 777 " + device.getAbsolutePath() + "\n" + "exit\n";
                su.getOutputStream().write(cmd.getBytes());

                if ((su.waitFor() != 0) || !device.canRead() || !device.canWrite()) {
                    throw new SecurityException();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new SecurityException();
            }
        }


        mSerialPort = new SerialPort(new File(sPort), iBaudRate, 0);
        mSerialPort.openSerialPort();
        mOutputStream = mSerialPort.getOutputStream();
        mInputStream = mSerialPort.getInputStream();
        mReadThread = new ReadThread();
        mReadThread.start();
        mSendThread = new SendThread();
        mSendThread.setSuspendFlag();
        mSendThread.start();
        _isOpen = true;
    }

    //----------------------------------------------------
    public void close() {
        if (mReadThread != null)
            mReadThread.interrupt();
        if (mSerialPort != null) {
            mSerialPort.close();
            mSerialPort = null;
        }
        _isOpen = false;
    }

    //----------------------------------------------------
    public void send(byte[] bOutArray) {
        try {
            mOutputStream.write(bOutArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------
/*    public void sendHex(String sHex) {
        byte[] bOutArray = MyFunc.HexToByteArr(sHex);
        send(bOutArray);
    }*/

    //----------------------------------------------------
    public void sendTxt(String sTxt) {
        byte[] bOutArray = sTxt.getBytes();
        send(bOutArray);
    }

    //----------------------------------------------------
    private class ReadThread extends Thread {
        private byte[] buffer = new byte[512];
        private int size;
        private ComBean ComRecData;
        private int total=0;

        private byte[] rxBuffer = new byte[100];
        private int rxLen = 0;

        RingBuff ringBuff = new RingBuff(100000000);

        private MAVLinkMessage testmavLinkMessage;


        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                try {

                    while (0 != ringBuff.ReadBuff(rxBuffer,1,true)) {

//                        ringBuff.ReadBuff(rxBuffer,1,true);
                        Log.i("ReadThread", "rxBuffer = "+ rxBuffer[0]);

                        recvMavLinkPacket = parser.mavlink_parse_char((rxBuffer[0] & 0xFF));
                        if (null != recvMavLinkPacket) {
                            if (null != recvMavLinkPacket.unpack()) {

                                testmavLinkMessage = recvMavLinkPacket.unpack();
                            }
                        }
                    }


                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (mInputStream == null) return;

                    if (mInputStream.available() > 0) {

                        long time = System.currentTimeMillis();

                        Log.i("ReadThread", "times = "+ Long.toString(time));

                        size = mInputStream.read(buffer);
                        total += size;

                        ringBuff.WriteBuff(buffer, size);
//                        rxLen = ringBuff.ReadBuff(rxBuffer,100,true);
                        Log.i("ReadThread", "total = "+ total);




//                        if (size > 0) {
//                            ComRecData = new ComBean(sPort, buffer, size);
//                            onDataReceived(ComRecData);
//                        }
                        Log.i("TAG", "size="+size);
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    //----------------------------------------------------
    private class SendThread extends Thread {
        public boolean suspendFlag = true;// 控制线程的执行

        public msg_heartbeat msg_heartbeat = new msg_heartbeat();
        public msg_altitude msg_altitude = new msg_altitude();
        public MAVLinkPacket mavLinkPacket = msg_altitude.pack();
        public int cnt=0;
        public int sqe;


        public MAVLinkDataHandle mavLinkDataHandle = MAVLinkDataHandle.getInstance();
        public MAVLinkDataHandle mavLinkDataHandle1 = MAVLinkDataHandle.getInstance();

        @Override
        public void run() {
            super.run();
//            while (!isInterrupted()) {
            while (true) {
//                synchronized (this) {
//                    while (suspendFlag) {
//                        try {
//                            wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                send(getbLoopData());

                mavLinkPacket.seq++;
                sqe++;

                if (cnt == 0) {
                    cnt = 1;

                    mavLinkPacket = msg_heartbeat.pack();
                    mavLinkPacket.seq = sqe;


                    send(mavLinkDataHandle.mavLinkSendDataPack(msg_heartbeat));

                } else {
                    cnt = 0;

                    mavLinkPacket = msg_altitude.pack();
                    mavLinkPacket.seq = sqe;


                    send(mavLinkDataHandle1.mavLinkSendDataPack(msg_altitude));
                }



//                send(mavLinkPacket.encodePacket());

//                send(mavLinkDataHandle.mavLinkSendDataPack(msg_heartbeat));

                try {
                    Thread.sleep(iDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //线程暂停
        public void setSuspendFlag() {
            this.suspendFlag = true;
        }

        //唤醒线程
        public synchronized void setResume() {
            this.suspendFlag = false;
            notify();
        }
    }

    //----------------------------------------------------
    public int getBaudRate() {
        return iBaudRate;
    }

    public boolean setBaudRate(int iBaud) {
        if (_isOpen) {
            return false;
        } else {
            iBaudRate = iBaud;
            return true;
        }
    }

    public boolean setBaudRate(String sBaud) {
        int iBaud = Integer.parseInt(sBaud);
        return setBaudRate(iBaud);
    }

    //----------------------------------------------------
    public String getPort() {
        return sPort;
    }

    public boolean setPort(String sPort) {
        if (_isOpen) {
            return false;
        } else {
            this.sPort = sPort;
            return true;
        }
    }

    //----------------------------------------------------
    public boolean isOpen() {
        return _isOpen;
    }

    //----------------------------------------------------
    public byte[] getbLoopData() {
        return _bLoopData;
    }

    //----------------------------------------------------
    public void setbLoopData(byte[] bLoopData) {
        this._bLoopData = bLoopData;
    }

    //----------------------------------------------------
    public void setTxtLoopData(String sTxt) {
        this._bLoopData = sTxt.getBytes();
    }

    //----------------------------------------------------
/*    public void setHexLoopData(String sHex) {
        this._bLoopData = MyFunc.HexToByteArr(sHex);
    }*/

    //----------------------------------------------------
    public int getiDelay() {
        return iDelay;
    }

    //----------------------------------------------------
    public void setiDelay(int iDelay) {
        this.iDelay = iDelay;
    }

    //----------------------------------------------------
    public void startSend() {
        if (mSendThread != null) {
            mSendThread.setResume();
        }
    }

    //----------------------------------------------------
    public void stopSend() {
        if (mSendThread != null) {
            mSendThread.setSuspendFlag();
        }
    }



    //----------------------------------------------------
    protected abstract void onDataReceived(ComBean ComRecData);
}