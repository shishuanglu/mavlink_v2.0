package com.example.myserial2;

import android.util.Log;

import com.example.myserial2.been.ComBean;
import com.example.myserial2.data.TeleMeter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DispQueueThread extends Thread {
    private Queue<ComBean> QueueList = new LinkedList<ComBean>();

    private long lastTimeMillis, curTimeMillis;
    private byte[] recvData = new byte[512];
    private boolean recvFlg = false;
    private int recvLen = 0;
    TeleMeter teleMeter = new TeleMeter();

    @Override
    public void run() {
        super.run();

        while (!isInterrupted()) {

            final ComBean ComData;



            if ((ComData = QueueList.poll()) != null) {
                Log.i("DispQueueThread", "poll run"+ComData.bRec.length);
                System.arraycopy(ComData.bRec, 0 , recvData, recvLen, ComData.bRec.length);
                recvLen += ComData.bRec.length;
                recvFlg = true;
                lastTimeMillis = System.currentTimeMillis();
            }

            /*if (((System.currentTimeMillis() - lastTimeMillis) >= 10) && (true == recvFlg)) {
                recvFlg = false;
                Log.i("DispQueueThread", "receive finish, len = "+recvLen);
                Log.i("DispQueueThread", "receive data"+ Arrays.toString(recvData));
                teleMeter.flyCtrlDataAnalyze(recvData, recvLen);
                recvLen = 0;
            }*/
            /*测试发送*/
//                if(toggleButton.isChecked()) {
//                    Com.sendTxt("hello world");
//                }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void AddQueue(ComBean ComData) {
        QueueList.add(ComData);
    }
}