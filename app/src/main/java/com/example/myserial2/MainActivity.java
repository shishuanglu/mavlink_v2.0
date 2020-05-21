package com.example.myserial2;

import android_serialport_api.SerialHelper;
import android_serialport_api.SerialPortFinder;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myserial2.been.ComBean;
import com.example.myserial2.data.TeleMeter;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCOM, spinnerBaudRate;
    TextView textViewVolt2;
    ToggleButton toggleButton;
    SerialControl Com;
    SerialPortFinder mSerialPortFinder;
    DispQueueThread DispQueue;//刷新显示线程

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Com = new SerialControl();
        DispQueue = new DispQueueThread();
        DispQueue.start();
        setControls();

//        private UrlString urlString = new UrlString();

//        editText = (EditText) findViewById(R.id.et_ip);
// 加载配置的信息 --- IP地址
//        urlString.setIPAddress(this);
//        editText.setText(urlString.getIP());

// 获取完整地址
// urlString.getIPAddress()
    }

    private void setControls() {

        spinnerCOM = findViewById(R.id.SpinnerCOM);
        spinnerBaudRate = findViewById(R.id.SpinnerBaudRate);
        toggleButton = findViewById(R.id.ToggleButton);


        textViewVolt2 = findViewById(R.id.gpsHeight);


        toggleButton.setOnCheckedChangeListener(new ToggleButtonCheckedChangeEvent());

        mSerialPortFinder = new SerialPortFinder();
        String[] entryValues = mSerialPortFinder.getAllDevicesPath();
        List<String> allDevices = new ArrayList<String>();
        for (int i = 0; i < entryValues.length; i++) {
            allDevices.add(entryValues[i]);
        }
        ArrayAdapter<String> aspnDevices = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, allDevices);
        aspnDevices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCOM.setAdapter(aspnDevices);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.baudrates_value, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBaudRate.setAdapter(adapter);



    }

    private class ToggleButtonCheckedChangeEvent implements ToggleButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView == toggleButton) {
                if (isChecked) {
                    Log.e("onCheckedChanged", "串口打开");
                        Com.setPort(spinnerCOM.getSelectedItem().toString());
                        Com.setBaudRate(spinnerBaudRate.getSelectedItem().toString());
                        OpenComPort(Com);

                } else {
                    Log.e("onCheckedChanged", "串口关闭");
                    CloseComPort(Com);
                }
            }
        }
    }

    //----------------------------------------------------关闭串口
    private void CloseComPort(SerialHelper ComPort) {
        if (ComPort != null) {
            ComPort.stopSend();
            ComPort.close();
        }
    }

    //----------------------------------------------------打开串口
    private void OpenComPort(SerialHelper ComPort) {
        try {
            ComPort.open();
        } catch (SecurityException e) {
            ShowMessage("打开串口失败:没有串口读/写权限!");
        } catch (IOException e) {
            ShowMessage("打开串口失败:未知错误!");
        } catch (InvalidParameterException e) {
            ShowMessage("打开串口失败:参数错误!");
        }
    }

    //------------------------------------------显示消息
    private void ShowMessage(String sMsg) {
        Toast.makeText(this, sMsg, Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------串口控制类
    private class  SerialControl extends SerialHelper {

        @Override
        protected void onDataReceived(final ComBean ComRecData) {

            DispQueue.AddQueue(ComRecData);//线程定时刷新显示(推荐)

        }
    }

//    private class DispQueueThread extends Thread {
//        private Queue<ComBean> QueueList = new LinkedList<ComBean>();
//
//        private long lastTimeMillis, curTimeMillis;
//        private byte[] recvData = new byte[512];
//        private boolean recvFlg = false;
//        private int recvLen = 0;
//        TeleMeter teleMeter = new TeleMeter();
//
//        @Override
//        public void run() {
//            super.run();
//
//            while (!isInterrupted()) {
//
//                final ComBean ComData;
//
//
//
//                if ((ComData = QueueList.poll()) != null) {
//                    Log.i("DispQueueThread", "poll run"+ComData.bRec.length);
//                    System.arraycopy(ComData.bRec, 0 , recvData, recvLen, ComData.bRec.length);
//                    recvLen += ComData.bRec.length;
//                    recvFlg = true;
//                    lastTimeMillis = System.currentTimeMillis();
//                }
//
//                if (((System.currentTimeMillis() - lastTimeMillis) >= 10) && (true == recvFlg)) {
//                    recvFlg = false;
//                    Log.i("DispQueueThread", "receive finish, len = "+recvLen);
//                    Log.i("DispQueueThread", "receive data"+ Arrays.toString(recvData));
//                    teleMeter.flyCtrlDataAnalyze(recvData, recvLen);
//                    recvLen = 0;
//                }
//                /*测试发送*/
////                if(toggleButton.isChecked()) {
////                    Com.sendTxt("hello world");
////                }
//
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        public synchronized void AddQueue(ComBean ComData) {
//            QueueList.add(ComData);
//        }
//    }


}
