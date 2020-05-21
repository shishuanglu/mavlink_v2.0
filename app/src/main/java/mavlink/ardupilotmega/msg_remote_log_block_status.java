/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE REMOTE_LOG_BLOCK_STATUS PACKING
package mavlink.ardupilotmega;
import mavlink.MAVLinkPacket;
import mavlink.Messages.MAVLinkMessage;
import mavlink.Messages.MAVLinkPayload;
        
/**
* Send Status of each log block that autopilot board might have sent.
*/
public class msg_remote_log_block_status extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS = 185;
    public static final int MAVLINK_MSG_LENGTH = 7;
    private static final long serialVersionUID = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;


      
    /**
    * Log data block sequence number.
    */
    public long seqno;
      
    /**
    * System ID.
    */
    public short target_system;
      
    /**
    * Component ID.
    */
    public short target_component;
      
    /**
    * Log data block status.
    */
    public short status;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;
              
        packet.payload.putUnsignedInt(seqno);
              
        packet.payload.putUnsignedByte(target_system);
              
        packet.payload.putUnsignedByte(target_component);
              
        packet.payload.putUnsignedByte(status);
        
        return packet;
    }

    /**
    * Decode a remote_log_block_status message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.seqno = payload.getUnsignedInt();
              
        this.target_system = payload.getUnsignedByte();
              
        this.target_component = payload.getUnsignedByte();
              
        this.status = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_remote_log_block_status(){
        msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_remote_log_block_status(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;
        unpack(mavLinkPacket.payload);        
    }

            
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS - sysid:"+sysid+" compid:"+compid+" seqno:"+seqno+" target_system:"+target_system+" target_component:"+target_component+" status:"+status+"";
    }
}
        