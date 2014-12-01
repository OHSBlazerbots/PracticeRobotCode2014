package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //PWM
    public static int FRONT_LEFT_MOTOR = -1;
    public static int REAR_LEFT_MOTOR = -1;
    public static int FRONT_RIGHT_MOTOR = -1;
    public static int REAR_RIGHT_MOTOR = -1;
    public static int SUBSYSTEM1_JAG1 = -1;
    public static int SUBSYSTEM1_JAG2 = -1;
    public static int SUBSYSTEM2_JAG1 = -1;
    public static int SUBSYSTEM2_JAG2 = -1;
    public static int SUBSYSTEM1_SERVO1 = -1;
    public static int SUBSYSTEM1_SERVO2 = -1;
    public static int SUBSYSTEM2_SERVO1 = -1;
    public static int SUBSYSTEM2_SERVO2 = -1;
    public static final int CAM_PAN = 9;
    public static final int CAM_TILT = 10;
    
    // Joysticks
    public static final int JOYSTICK_PORT = 2;
    public static final int JOYSTICK2_PORT = 1;
    
    // Analog
    public static int ACCELEROMETER_PORT = -1;
    public static int GYRO_PORT = -1;
    public static int SONAR_PORT = -1;
    
    //Relays
    public static int SUBSYSTEM1_RELAY1 = -1;
    public static int SUBSYSTEM1_RELAY2 = -1;
    public static int SUBSYSTEM2_RELAY1 = -1;
    public static int SUBSYSTEM2_RELAY2 = -1;
    
    
}
