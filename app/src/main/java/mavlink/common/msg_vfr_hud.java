/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE VFR_HUD PACKING
package mavlink.common;
import mavlink.MAVLinkPacket;
import mavlink.Messages.MAVLinkMessage;
import mavlink.Messages.MAVLinkPayload;
        
/**
* Metrics typically displayed on a HUD for fixed wing aircraft.
*/
public class msg_vfr_hud extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_VFR_HUD = 74;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = MAVLINK_MSG_ID_VFR_HUD;


      
    /**
    * Current indicated airspeed (IAS).
    */
    public float airspeed;
      
    /**
    * Current ground speed.
    */
    public float groundspeed;
      
    /**
    * Current altitude (MSL).
    */
    public float alt;
      
    /**
    * Current climb rate.
    */
    public float climb;
      
    /**
    * Current heading in compass units (0-360, 0=north).
    */
    public short heading;
      
    /**
    * Current throttle setting (0 to 100).
    */
    public int throttle;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_VFR_HUD;
              
        packet.payload.putFloat(airspeed);
              
        packet.payload.putFloat(groundspeed);
              
        packet.payload.putFloat(alt);
              
        packet.payload.putFloat(climb);
              
        packet.payload.putShort(heading);
              
        packet.payload.putUnsignedShort(throttle);
        
        return packet;
    }

    /**
    * Decode a vfr_hud message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.airspeed = payload.getFloat();
              
        this.groundspeed = payload.getFloat();
              
        this.alt = payload.getFloat();
              
        this.climb = payload.getFloat();
              
        this.heading = payload.getShort();
              
        this.throttle = payload.getUnsignedShort();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_vfr_hud(){
        msgid = MAVLINK_MSG_ID_VFR_HUD;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_vfr_hud(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_VFR_HUD;
        unpack(mavLinkPacket.payload);        
    }

                
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_VFR_HUD - sysid:"+sysid+" compid:"+compid+" airspeed:"+airspeed+" groundspeed:"+groundspeed+" alt:"+alt+" climb:"+climb+" heading:"+heading+" throttle:"+throttle+"";
    }
}
        