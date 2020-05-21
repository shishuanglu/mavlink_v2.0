/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE WIFI_CONFIG_AP PACKING
package mavlink.common;
import mavlink.MAVLinkPacket;
import mavlink.Messages.MAVLinkMessage;
import mavlink.Messages.MAVLinkPayload;
        
/**
* Configure AP SSID and Password.
*/
public class msg_wifi_config_ap extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_WIFI_CONFIG_AP = 299;
    public static final int MAVLINK_MSG_LENGTH = 96;
    private static final long serialVersionUID = MAVLINK_MSG_ID_WIFI_CONFIG_AP;


      
    /**
    * Name of Wi-Fi network (SSID). Leave it blank to leave it unchanged.
    */
    public byte ssid[] = new byte[32];
      
    /**
    * Password. Leave it blank for an open AP.
    */
    public byte password[] = new byte[64];
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_WIFI_CONFIG_AP;
              
        
        for (int i = 0; i < ssid.length; i++) {
            packet.payload.putByte(ssid[i]);
        }
                    
              
        
        for (int i = 0; i < password.length; i++) {
            packet.payload.putByte(password[i]);
        }
                    
        
        return packet;
    }

    /**
    * Decode a wifi_config_ap message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
         
        for (int i = 0; i < this.ssid.length; i++) {
            this.ssid[i] = payload.getByte();
        }
                
              
         
        for (int i = 0; i < this.password.length; i++) {
            this.password[i] = payload.getByte();
        }
                
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_wifi_config_ap(){
        msgid = MAVLINK_MSG_ID_WIFI_CONFIG_AP;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_wifi_config_ap(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_WIFI_CONFIG_AP;
        unpack(mavLinkPacket.payload);        
    }

     
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setSsid(String str) {
        int len = Math.min(str.length(), 32);
        for (int i=0; i<len; i++) {
            ssid[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<32; i++) {            // padding for the rest of the buffer
            ssid[i] = 0;
        }
    }

    /**
    * Gets the message, formated as a string
    */
    public String getSsid() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            if (ssid[i] != 0)
                buf.append((char) ssid[i]);
            else
                break;
        }
        return buf.toString();

    }
                          
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setPassword(String str) {
        int len = Math.min(str.length(), 64);
        for (int i=0; i<len; i++) {
            password[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<64; i++) {            // padding for the rest of the buffer
            password[i] = 0;
        }
    }

    /**
    * Gets the message, formated as a string
    */
    public String getPassword() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 64; i++) {
            if (password[i] != 0)
                buf.append((char) password[i]);
            else
                break;
        }
        return buf.toString();

    }
                         
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_WIFI_CONFIG_AP - sysid:"+sysid+" compid:"+compid+" ssid:"+ssid+" password:"+password+"";
    }
}
        