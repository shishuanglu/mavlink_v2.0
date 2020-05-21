/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package mavlink.enums;

/** 
* Flags for high level gimbal manager operation The first 16 bytes are identical to the GIMBAL_DEVICE_FLAGS.
*/
public class GIMBAL_MANAGER_FLAGS {
   public static final int GIMBAL_MANAGER_FLAGS_RETRACT = 1; /* Based on GIMBAL_DEVICE_FLAGS_RETRACT | */
   public static final int GIMBAL_MANAGER_FLAGS_NEUTRAL = 2; /* Based on GIMBAL_DEVICE_FLAGS_NEUTRAL | */
   public static final int GIMBAL_MANAGER_FLAGS_ROLL_LOCK = 4; /* Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK | */
   public static final int GIMBAL_MANAGER_FLAGS_PITCH_LOCK = 8; /* Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK | */
   public static final int GIMBAL_MANAGER_FLAGS_YAW_LOCK = 16; /* Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK | */
   public static final int GIMBAL_MANAGER_FLAGS_ANGULAR_VELOCITY_RELATIVE_TO_FOCAL_LENGTH = 1048576; /* Scale angular velocity relative to focal length. This means the gimbal moves slower if it is zoomed in. | */
   public static final int GIMBAL_MANAGER_FLAGS_NUDGE = 2097152; /* Interpret attitude control on top of pointing to a location or tracking. If this flag is set, the quaternion is relative to the existing tracking angle. | */
   public static final int GIMBAL_MANAGER_FLAGS_OVERRIDE = 4194304; /* Completely override pointing to a location or tracking. If this flag is set, the quaternion is (as usual) according to GIMBAL_MANAGER_FLAGS_YAW_LOCK. | */
   public static final int GIMBAL_MANAGER_FLAGS_NONE = 8388608; /* This flag can be set to give up control previously set using MAV_CMD_DO_GIMBAL_MANAGER_ATTITUDE. This flag must not be combined with other flags. | */
   public static final int GIMBAL_MANAGER_FLAGS_ENUM_END = 8388609; /*  | */
}
            