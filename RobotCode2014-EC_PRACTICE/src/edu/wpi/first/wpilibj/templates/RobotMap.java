package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //PWM
    public static int FRONT_LEFT_MOTOR = 4;
    public static int FRONT_RIGHT_MOTOR = 3;
    public static int KICKER_MOTOR = 5;
    public static final int CAM_PAN = 9;
    public static final int CAM_TILT = 10;
    
    // Joysticks
    public static final int JOYSTICK_PORT = 2;
    public static final int JOYSTICK2_PORT = 1;
    
    // Analog
    public static int ACCELEROMETER_PORT = -1;
    public static int GYRO_PORT = -1;
    public static int SONAR_PORT = -1; 
    
    //Digital
    public static int SWITCH_PORT = 7;
    
}
