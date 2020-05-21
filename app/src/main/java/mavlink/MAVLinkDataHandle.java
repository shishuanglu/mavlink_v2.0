package mavlink;

import mavlink.Messages.MAVLinkMessage;
import mavlink.common.msg_heartbeat;

public class MAVLinkDataHandle {

    private int sqe=0;
    private int msgid = 0;
    private int compid = 0;
    private int sysid = 0;
    private int compat_flags = 0;
    private int incompat_flags = 0;

    public MAVLinkPacket mavLinkPacket = new MAVLinkPacket(19);


    private volatile static MAVLinkDataHandle mavLinkDataHandle = null;

    // 私有化构造方法
    private MAVLinkDataHandle () {

    }

    //单例模式
    public static MAVLinkDataHandle getInstance() {
        if (mavLinkDataHandle == null) {
            synchronized (MAVLinkDataHandle.class) {
                if (mavLinkDataHandle == null) {
                    mavLinkDataHandle = new MAVLinkDataHandle();
                }
            }

        }
        return mavLinkDataHandle;
    }

    public byte[] mavLinkSendDataPack (MAVLinkMessage mavLinkMessage) {

        mavLinkPacket = mavLinkMessage.pack();
        mavLinkPacket.msgid = msgid;
        mavLinkPacket.compid = compid;
        mavLinkPacket.sysid = sysid;
        mavLinkPacket.compat_flags = compat_flags;
        mavLinkPacket.incompat_flags = incompat_flags;
        mavLinkPacket.seq = sqe++;

        return mavLinkPacket.encodePacket();
    }

    public int getMsgid() {
        return msgid;
    }

    public void setMsgid(int msgid) {
        this.msgid = msgid;
    }

    public int getCompid() {
        return compid;
    }

    public void setCompid(int compid) {
        this.compid = compid;
    }

    public int getSysid() {
        return sysid;
    }

    public void setSysid(int sysid) {
        this.sysid = sysid;
    }

    public int getCompat_flags() {
        return compat_flags;
    }

    public void setCompat_flags(int compat_flags) {
        this.compat_flags = compat_flags;
    }

    public int getIncompat_flags() {
        return incompat_flags;
    }

    public void setIncompat_flags(int incompat_flags) {
        this.incompat_flags = incompat_flags;
    }
}
