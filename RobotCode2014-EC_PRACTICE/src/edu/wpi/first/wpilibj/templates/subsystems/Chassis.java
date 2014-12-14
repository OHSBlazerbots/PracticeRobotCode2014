package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Deals with drive train and sensor assets.
 *
 * @author sgoldman
 */
public class Chassis extends Subsystem {

    //Our drive code
    public static RobotDrive drive;
    public boolean followingFrisbee;

    /**
     * Create an instance of the chassis class with the appropriate motors.
     * motors
     *
     * @param frontLeftMotor
     * @param rearLeftMotor
     * @param frontRightMotor
     * @param rearRightMotor
     */
    public Chassis(int frontLeftMotor, int frontRightMotor, int rearLeftMotor, int rearRightMotor) {
        //Create new robot drive class with pin values for the two motors
        if (frontLeftMotor != -1 && frontRightMotor != -1 && rearLeftMotor != -1 && rearRightMotor != -1) {
            drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
            //Disables safety so we can drive
            drive.setSafetyEnabled(false);
        } else {
            //System.out.println("FAILURE: Chassis not created due to port value as -1.");
        }
        this.followingFrisbee = false;
    }

    /**
     * Create an instance of the chassis class with the appropriate motors.
     * motors
     *
     * @param frontLeftMotor
     * @param rearLeftMotor
     */
    public Chassis(int leftMotor, int rightMotor) {
        //Create new robot drive class with pin values for the two motors
        if (leftMotor != -1 && rightMotor != -1) {
            drive = new RobotDrive(leftMotor, rightMotor);
            //Disables safety so we can drive
            drive.setSafetyEnabled(false);
        } else {
            //System.out.println("FAILURE: Chassis not created due to port value as -1.");
        }
        this.followingFrisbee = false;
    }

    /**
     * Starts drive with joystick as the default command l
     */
    protected void initDefaultCommand() {
        //Starts driving the robot with this non terminating command
        setDefaultCommand(new DriveWithJoystick(this));
    }

    /**
     * Command the chassis to drive with the joystick.
     *
     * @param joystick
     */
    public void driveWithJoyStick(Joystick joystick) {
        //Turn is the reverse of x
        double turn = joystick.getX();
        //Drive is the y
        double move = joystick.getY();
        if (drive != null && !this.followingFrisbee) {
            drive(move, turn);
        }
    }

    public void drive(double move, double turn) {
        if (drive != null) {
            drive.arcadeDrive(move, turn);
        }
    }

    public boolean isFollowingFrisbee() {
        return followingFrisbee;
    }

    public void setFollowingFrisbee(boolean followingFrisbee) {
        this.followingFrisbee = followingFrisbee;
    }
}
