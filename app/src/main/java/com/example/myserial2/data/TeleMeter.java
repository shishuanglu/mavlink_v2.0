package com.example.myserial2.data;

import android.app.Activity;
import android.util.Log;

import java.util.Arrays;

public class TeleMeter  {
    /*public int lat;				//纬度
    public int lon;				//经度
    public int gpsHeight;			//GPS 高度*1000
    public int pressureHeight;	    //气压高度*1000
    public int	spdE;				//东向速度*100
    public int	spdN;				//北向速度*100
    public int	spdD;				//天向速度*100
    public int eulerYaw;			//航向角*100
    public int eulerPitch;		        //俯仰角*100
    public int	eulerRoll;			    //横滚角*100
    public int airSpd;				    //空速*100
    public int oriPressureHeight;	    //气压原始高度*1000
    public int gngHeight;				//对地距离测量*100
    public int flyCtrlVolt;			//飞控电压*100
    public int volt1;					//电压 1*100
    public int volt2;					//电压 2*100
    public int volt3;					//电压 3*100
    public int flyCtrlTemper;			//飞控温度*100
    public int rotateSpd1;			//转速测量 1
    public int rotateSpd2;			//转速测量 2
    public int tarHeight;			//目标高度*1000
    public int sideMargin;		    //侧边距*100
    public int flyTime;			//飞行时间
    public int flyDistance;		//飞行距离*0.01
    public int satNum;				//卫星颗数
    public int satLocateState;	//卫星定位状态
    public int locateAcc;			//定位精度*100
    public int photoNum;			//照片张数
    public int flightPhase;	    //飞行阶段
    public int flightMode;		//飞行模式
    public int deviceState1;	//健康状态 1
    public int deviceState2;	//健康状态 2
    public int ploc;			//控制源
    public int lockState;		//锁定状态
    public int aileronRudder;	//副翼舵
    public int elevatRudder;	//升降舵
    public int accelerRudder;	//油门舵
    public int collectPitch;	//总距
    public int directRudder;	//方向舵
    public int outputCh1;		//输出通道1
    public int outputCh2;		//输出通道2
    public int outputCh3;		//输出通道3
    public int outputCh4;		//输出通道4
    public int outputCh5;		//输出通道5
    public int outputCh6;		//输出通道6
    public int outputCh7;		//输出通道7
    public int outputCh8;		//输出通道8
    public int outputCh9;		//输出通道9
    public int outputCh10;	    //输出通道10
    public int inputCh1;		//输入通道1
    public int inputCh2;		//输入通道2
    public int inputCh3;		//输入通道3
    public int inputCh4;		//输入通道4
    public int inputCh5;		//输入通道5
    public int inputCh6;		//输入通道6
    public int inputCh7;		//输入通道7
    public int inputCh8;		//输入通道8*/

    public int lat;				    //纬度1e7
    public int lon;				    //经度1e7
    public int gpsHeight;			//GPS 高度*1000
    public int pressureHeight;	    //气压高度*1000
    public int	spdE;				//东向速度*100
    public int	spdN;				//北向速度*100
    public int	spdD;				//天向速度*100
    public int eulerYaw;			//航向角*100
    public int eulerPitch;		    //俯仰角*100
    public int	eulerRoll;			//横滚角*100
    public int airSpd;				//空速*100
    public int angRateX;			//X 轴角速度*100
    public int angRateY;			//Y 轴角速度*100
    public int angRateZ;			//Z 轴角速度*100
    public int accX;				//X 轴加速度*1000
    public int accY;				//Y 轴加速度*1000
    public int accZ;				//Z 轴加速度*1000
    public int magneticX;			//X 轴磁传感器值*10000
    public int magneticY;			//y 轴磁传感器值*10000
    public int magneticZ;			//z 轴磁传感器值*10000
    public int oriPressureHeight;	//气压原始高度*1000
    public int gngHeight;			//对地距离测量*100
    public int flyCtrlVolt;		//飞控电压*100
    public int volt1;				//电压 1*100
    public int volt2;				//电压 2*100
    public int volt3;				//电压 3*100
    public int flyCtrlTemper;		//飞控温度*100
    public int rotateSpd1;		//转速测量 1
    public int rotateSpd2;		//转速测量 2
    public int satHorAcc;			//卫星水平精度*100
    public int satVerAcc;			//卫星垂直精度*100
    public int satSpdAcc;			//卫星速度精度*100
    public int satEulerYaw;		//卫星定向航向角*100
    public int year;				//年
    public int mon;					//月
    public int day;					//日
    public int hour;				//时
    public int min;					//分
    public int sec;					//秒
    public int tarPoint;			//目标航点
    public int tarHeight;			//目标高度*1000
    public int tarLat;			    //目标纬度
    public int tarLon;			    //目标经度
    public int	tarSpdSky;		//目标天向速度*100
    public int	tarSpdSide;		//目标侧向速度*100
    public int	tarSpdForward;	//目标前向速度*100
    public int tarEulerYaw;		//目标航向*100
    public int tarEulerPitch;	    //目标俯仰角*100
    public int	tarEulerRoll;		//目标横滚角*100
    public int sideMargin;		    //侧边距*100
    public int notFlySoil;		//未飞圈数
    public int flyTime;			//飞行时间
    public int flyDistance;		//飞行距离*0.01
    public int railRange;			//电子围栏范围*0.1
    public int throwSatTime;		//丢星时间
    public int	chainBrokeTime;	//断链时间
    public int satNum;				//卫星颗数
    public int satLocateState;	//卫星定位状态
    public int locateAcc;			//定位精度*100
    public int photoNum;			//照片张数
    public int standSatNum;		//备用卫星数
    public int flightPhase;	    //飞行阶段
    public int flightMode;		    //飞行模式
    public int deviceState1;	    //健康状态 1
    public int deviceState2;	    //健康状态 2
    public int ploc;			    //控制源
    public int lockState;		    //锁定状态
    public int aileronRudder;	    //副翼舵
    public int elevatRudder;	    //升降舵
    public int accelerRudder;	    //油门舵
    public int collectPitch;	    //总距
    public int directRudder;	    //方向舵
    public int outputCh1;		    //输出通道1
    public int outputCh2;		    //输出通道2
    public int outputCh3;		    //输出通道3
    public int outputCh4;		    //输出通道4
    public int outputCh5;		    //输出通道5
    public int outputCh6;		    //输出通道6
    public int outputCh7;		    //输出通道7
    public int outputCh8;		    //输出通道8
    public int outputCh9;		    //输出通道9
    public int outputCh10;	        //输出通道10
    public int inputCh1;		    //输入通道1
    public int inputCh2;		    //输入通道2
    public int inputCh3;		    //输入通道3
    public int inputCh4;		    //输入通道4
    public int inputCh5;		    //输入通道5
    public int inputCh6;		    //输入通道6
    public int inputCh7;		    //输入通道7
    public int inputCh8;		    //输入通道8

    private int[] iRec =null;
    private int frameIndex, frameLen;
    private int crc;

    DataCallBack dataCallBack;


    public void flyCtrlDataAnalyze (byte[] data, int size) {


        this.iRec = new int[size];

        /*byte to int*/
        for (int i=0; i<size; i++) {
            this.iRec[i] = data[i] & 0xFF;
        }

        Log.i("flyCtrlDataAnalyze", "iRec="+ Arrays.toString(this.iRec));

        if ((0xA5 != this.iRec[0]) || (0x5A != this.iRec[1])) {
            /*帧头错误*/
            Log.e("flyCtrlDataAnalyze", "帧头错误");
        } else {
            Log.i("flyCtrlDataAnalyze", "帧头正确");

            this.frameLen = this.iRec[2];
            this.frameIndex = (this.iRec[3]<<8) + this.iRec[4];

            Log.i("flyCtrlDataAnalyze", "帧长度 = "+this.frameLen);
            Log.i("flyCtrlDataAnalyze", "帧ID = "+this.frameIndex);


            switch (this.frameIndex) {
                case 0x1012:
                    if (0x3F == this.frameLen && size >= this.frameLen) {

                        crc = iRec[this.frameLen-3]<<8 + iRec[this.frameLen-2];


                        /*校验未做*/
                        lat = (iRec[9]<<24) + (iRec[8]<<16) + (iRec[7]<<8) + iRec[6];
                        lon = (iRec[13]<<24) + (iRec[12]<<16) + (iRec[11]<<8) + iRec[10];
                        gpsHeight = (iRec[17]<<24) + (iRec[16]<<16) + (iRec[15]<<8) + iRec[14];
                        pressureHeight = (iRec[21]<<24) + (iRec[20]<<16) + (iRec[19]<<8) + iRec[18];
                        spdE = (iRec[23]<<8) + iRec[22];
                        spdN = (iRec[25]<<8) + iRec[24];
                        spdD = (iRec[27]<<8) + iRec[26];
                        eulerYaw = (iRec[29]<<8) + iRec[28];
                        eulerPitch = (iRec[31]<<8) + iRec[30];
                        eulerRoll = (iRec[33]<<8) + iRec[32];
                        airSpd = (iRec[35]<<8) + iRec[34];
                        angRateX = (iRec[37]<<8) + iRec[36];
                        angRateY = (iRec[39]<<8) + iRec[38];
                        angRateZ = (iRec[41]<<8) + iRec[40];
                        accX = (iRec[43]<<8) + iRec[42];
                        accY = (iRec[45]<<8) + iRec[44];
                        accZ = (iRec[47]<<8) + iRec[46];

                        long time = System.currentTimeMillis();

                        Log.i("flyCtrlDataAnalyze", "time = "+ Long.toString(time));
                    }
                    break;


                case 0x1013:
                    Log.i("flyCtrlDataAnalyze", "test=" + ((19 << 8)+73));
                    if (0x3F == this.frameLen && size >= this.frameLen) {
                        magneticX = (iRec[7]<<8) + iRec[6];
                        magneticY = (iRec[9]<<8) + iRec[8];
                        magneticZ = (iRec[11]<<8) + iRec[10];
                        oriPressureHeight = (iRec[15]<<24) + (iRec[14]<<16) + (iRec[13]<<8) + iRec[12];
                        gngHeight = (iRec[17]<<8) + iRec[16];
                        flyCtrlVolt = (iRec[19]<<8) + iRec[18];
                        volt1 = (iRec[21]<<8) + iRec[20];
                        volt2 = (iRec[23]<<8) + iRec[22];
                        volt3 = (iRec[25]<<8) + iRec[24];
                        flyCtrlTemper = (iRec[27]<<8) + iRec[26];
                        rotateSpd1 = (iRec[29]<<8) + iRec[28];
                        rotateSpd2 = (iRec[31]<<8) + iRec[30];
                        satHorAcc = (iRec[33]<<8) + iRec[32];
                        satVerAcc = (iRec[35]<<8) + iRec[34];
                        satSpdAcc = (iRec[37]<<8) + iRec[36];
                        satEulerYaw = (iRec[39]<<8) + iRec[38];
                        year = iRec[40];
                        mon = iRec[41];
                        day = iRec[42];
                        hour = iRec[43];
                        min = iRec[44];
                        sec = iRec[45];
                    }
                    break;


                case 0x1015:
                    if (0x44 == this.frameLen && size >= this.frameLen) {
                        tarPoint = (iRec[7]<<8) + iRec[6];
                        tarHeight = (iRec[11]<<24) + (iRec[10]<<16) + (iRec[9]<<8) + iRec[8];
                        tarLat = (iRec[15]<<24) + (iRec[14]<<16) + (iRec[13]<<8) + iRec[12];
                        tarLon = (iRec[19]<<24) + (iRec[18]<<16) + (iRec[17]<<8) + iRec[16];
                        tarSpdSky = (iRec[21]<<8) + iRec[20];
                        tarSpdSide = (iRec[23]<<8) + iRec[22];
                        tarSpdForward = (iRec[25]<<8) + iRec[24];
                        tarEulerYaw = (iRec[27]<<8) + iRec[26];
                        tarEulerPitch = (iRec[29]<<8) + iRec[28];
                        tarEulerRoll = (iRec[31]<<8) + iRec[30];
                        sideMargin = (iRec[33]<<8) + iRec[32];
                        notFlySoil = iRec[34];
                        flyTime = (iRec[36]<<8) + iRec[35];
                        flyDistance = (iRec[38]<<8) + iRec[37];
                        railRange = (iRec[40]<<8) + iRec[39];
                        throwSatTime = (iRec[42]<<8) + iRec[41];
                        chainBrokeTime = (iRec[44]<<8) + iRec[43];
                        satNum = iRec[45];
                        satLocateState = iRec[46];
                        locateAcc = (iRec[48]<<8) + iRec[47];
                        photoNum = (iRec[50]<<8) + iRec[49];
                        standSatNum = (iRec[60]<<8) + iRec[59];
                    }
                    break;

                case 0x1016:
                    if (0x40 == this.frameLen && size >= this.frameLen) {
                        flightPhase = iRec[6];
                        flightMode = iRec[7];
                        deviceState1 = (iRec[9]<<8) + iRec[8];
                        deviceState2 = (iRec[11]<<8) + iRec[10];
                        ploc = iRec[12];
                        lockState = iRec[13];
                        aileronRudder = iRec[14];
                        elevatRudder = iRec[15];
                        accelerRudder = iRec[16];
                        collectPitch = iRec[17];
                        directRudder = iRec[18];
                        outputCh1 = (iRec[20]<<8) + iRec[19];
                        outputCh2 = (iRec[22]<<8) + iRec[21];
                        outputCh3 = (iRec[24]<<8) + iRec[23];
                        outputCh4 = (iRec[26]<<8) + iRec[25];
                        outputCh5 = (iRec[28]<<8) + iRec[27];
                        outputCh6 = (iRec[30]<<8) + iRec[29];
                        outputCh7 = (iRec[32]<<8) + iRec[31];
                        outputCh8 = (iRec[34]<<8) + iRec[33];
                        outputCh9 = (iRec[36]<<8) + iRec[35];
                        outputCh10 = (iRec[38]<<8) + iRec[37];
                        inputCh1 = iRec[39];
                        inputCh2 = iRec[40];
                        inputCh3 = iRec[41];
                        inputCh4 = iRec[42];
                        inputCh5 = iRec[43];
                        inputCh6 = iRec[44];
                        inputCh7 = iRec[45];
                        inputCh8 = iRec[46];
                    }
                    break;
                default:
                    break;
            }
        }

      if(dataCallBack!=null){
          dataCallBack.updateData(this);
      }



    }


    public interface DataCallBack{
        void updateData(final TeleMeter data);
    }

    public void setCallBack(DataCallBack call){
        dataCallBack = call;
    }
}
