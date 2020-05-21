/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GPS2_RAW PACKING
package mavlink.common;
import mavlink.MAVLinkPacket;
import mavlink.Messages.MAVLinkMessage;
import mavlink.Messages.MAVLinkPayload;
        
/**
* Second GPS data.
*/
public class msg_gps2_raw extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_GPS2_RAW = 124;
    public static final int MAVLINK_MSG_LENGTH = 35;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GPS2_RAW;


      
    /**
    * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number.
    */
    public long time_usec;
      
    /**
    * Latitude (WGS84)
    */
    public int lat;
      
    /**
    * Longitude (WGS84)
    */
    public int lon;
      
    /**
    * Altitude (MSL). Positive for up.
    */
    public int alt;
      
    /**
    * Age of DGPS info
    */
    public long dgps_age;
      
    /**
    * GPS HDOP horizontal dilution of position. If unknown, set to: UINT16_MAX
    */
    public int eph;
      
    /**
    * GPS VDOP vertical dilution of position. If unknown, set to: UINT16_MAX
    */
    public int epv;
      
    /**
    * GPS ground speed. If unknown, set to: UINT16_MAX
    */
    public int vel;
      
    /**
    * Course over ground (NOT heading, but direction of movement): 0.0..359.99 degrees. If unknown, set to: UINT16_MAX
    */
    public int cog;
      
    /**
    * GPS fix type.
    */
    public short fix_type;
      
    /**
    * Number of satellites visible. If unknown, set to 255
    */
    public short satellites_visible;
      
    /**
    * Number of DGPS satellites
    */
    public short dgps_numch;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_GPS2_RAW;
              
        packet.payload.putUnsignedLong(time_usec);
              
        packet.payload.putInt(lat);
              
        packet.payload.putInt(lon);
              
        packet.payload.putInt(alt);
              
        packet.payload.putUnsignedInt(dgps_age);
              
        packet.payload.putUnsignedShort(eph);
              
        packet.payload.putUnsignedShort(epv);
              
        packet.payload.putUnsignedShort(vel);
              
        packet.payload.putUnsignedShort(cog);
              
        packet.payload.putUnsignedByte(fix_type);
              
        packet.payload.putUnsignedByte(satellites_visible);
              
        packet.payload.putUnsignedByte(dgps_numch);
        
        return packet;
    }

    /**
    * Decode a gps2_raw message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.time_usec = payload.getUnsignedLong();
              
        this.lat = payload.getInt();
              
        this.lon = payload.getInt();
              
        this.alt = payload.getInt();
              
        this.dgps_age = payload.getUnsignedInt();
              
        this.eph = payload.getUnsignedShort();
              
        this.epv = payload.getUnsignedShort();
              
        this.vel = payload.getUnsignedShort();
              
        this.cog = payload.getUnsignedShort();
              
        this.fix_type = payload.getUnsignedByte();
              
        this.satellites_visible = payload.getUnsignedByte();
              
        this.dgps_numch = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_gps2_raw(){
        msgid = MAVLINK_MSG_ID_GPS2_RAW;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_gps2_raw(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_GPS2_RAW;
        unpack(mavLinkPacket.payload);        
    }

                            
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_GPS2_RAW - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" lat:"+lat+" lon:"+lon+" alt:"+alt+" dgps_age:"+dgps_age+" eph:"+eph+" epv:"+epv+" vel:"+vel+" cog:"+cog+" fix_type:"+fix_type+" satellites_visible:"+satellites_visible+" dgps_numch:"+dgps_numch+"";
    }
}
        