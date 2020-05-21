package com.example.myserial2;
import android.content.Context;
import java.util.Properties;

/**
 * 读写配置属性类
 */

public class UrlString {

    private String contrastIPName = "contrastIP";

    // 上传路径
    private String ip;
    private String ipAddress;

    public void setIPAddress(Context context) {
        Properties proper = ProperTies.getProperties(context);
        this.ip = proper.getProperty(contrastIPName, "");
        this.ipAddress = "http://" + this.ip + "/index.html";
    }

    public String setIPAddress(Context context, String keyValue) {
        String result = ProperTies.setProperties(context, contrastIPName, keyValue);
        this.ip = keyValue;
        this.ipAddress = "http://" + this.ip + "/index.html";
        return result;
    }

    public String getIP() {
        return this.ip;
    }

    public String getIPAddress() {
        return this.ipAddress;
    }
}