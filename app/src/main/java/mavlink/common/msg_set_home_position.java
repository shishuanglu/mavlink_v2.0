/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SET_HOME_POSITION PACKING
package mavlink.common;
import mavlink.MAVLinkPacket;
import mavlink.Messages.MAVLinkMessage;
import mavlink.Messages.MAVLinkPayload;
        
/**
* The position the system will return to and land on. The position is set automatically by the system during the takeoff in case it was not explicitly set by the operator before or after. The global and local positions encode the position in the respective coordinate frames, while the q parameter encodes the orientation of the surface. Under normal conditions it describes the heading and terrain slope, which can be used by the aircraft to adjust the approach. The approach 3D vector describes the point to which the system should fly in normal flight mode and then perform a landing sequence along the vector.
*/
public class msg_set_home_position extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_SET_HOME_POSITION = 243;
    public static final int MAVLINK_MSG_LENGTH = 61;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SET_HOME_POSITION;


      
    /**
    * Latitude (WGS84)
    */
    public int latitude;
      
    /**
    * Longitude (WGS84)
    */
    public int longitude;
      
    /**
    * Altitude (MSL). Positive for up.
    */
    public int altitude;
      
    /**
    * Local X position of this position in the local coordinate frame
    */
    public float x;
      
    /**
    * Local Y position of this position in the local coordinate frame
    */
    public float y;
      
    /**
    * Local Z position of this position in the local coordinate frame
    */
    public float z;
      
    /**
    * World to surface normal and heading transformation of the takeoff position. Used to indicate the heading and slope of the ground
    */
    public float q[] = new float[4];
      
    /**
    * Local X position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone.
    */
    public float approach_x;
      
    /**
    * Local Y position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone.
    */
    public float approach_y;
      
    /**
    * Local Z position of the end of the approach vector. Multicopters should set this position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the takeoff, assuming the takeoff happened from the threshold / touchdown zone.
    */
    public float approach_z;
      
    /**
    * System ID.
    */
    public short target_system;
      
    /**
    * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number.
    */
    public long time_usec;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_SET_HOME_POSITION;
              
        packet.payload.putInt(latitude);
              
        packet.payload.putInt(longitude);
              
        packet.payload.putInt(altitude);
              
        packet.payload.putFloat(x);
              
        packet.payload.putFloat(y);
              
        packet.payload.putFloat(z);
              
        
        for (int i = 0; i < q.length; i++) {
            packet.payload.putFloat(q[i]);
        }
                    
              
        packet.payload.putFloat(approach_x);
              
        packet.payload.putFloat(approach_y);
              
        packet.payload.putFloat(approach_z);
              
        packet.payload.putUnsignedByte(target_system);
              
        packet.payload.putUnsignedLong(time_usec);
        
        return packet;
    }

    /**
    * Decode a set_home_position message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.latitude = payload.getInt();
              
        this.longitude = payload.getInt();
              
        this.altitude = payload.getInt();
              
        this.x = payload.getFloat();
              
        this.y = payload.getFloat();
              
        this.z = payload.getFloat();
              
         
        for (int i = 0; i < this.q.length; i++) {
            this.q[i] = payload.getFloat();
        }
                
              
        this.approach_x = payload.getFloat();
              
        this.approach_y = payload.getFloat();
              
        this.approach_z = payload.getFloat();
              
        this.target_system = payload.getUnsignedByte();
              
        this.time_usec = payload.getUnsignedLong();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_set_home_position(){
        msgid = MAVLINK_MSG_ID_SET_HOME_POSITION;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_set_home_position(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_SET_HOME_POSITION;
        unpack(mavLinkPacket.payload);        
    }

                            
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_SET_HOME_POSITION - sysid:"+sysid+" compid:"+compid+" latitude:"+latitude+" longitude:"+longitude+" altitude:"+altitude+" x:"+x+" y:"+y+" z:"+z+" q:"+q+" approach_x:"+approach_x+" approach_y:"+approach_y+" approach_z:"+approach_z+" target_system:"+target_system+" time_usec:"+time_usec+"";
    }
}
        