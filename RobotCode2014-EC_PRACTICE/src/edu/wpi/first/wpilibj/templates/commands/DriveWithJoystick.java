/**
 * Copyright 2012. FRC Team 3807.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 * This class maps controls with the joystick to driving the chassis.
 */
public class DriveWithJoystick extends CommandBase {

    private boolean finished = false;
    
    /**
     * Construct this command.
     */
    public DriveWithJoystick(Chassis chassis) {
        // We need the chassis to drive with the joystick.
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Turn with joystick
        try{
            chassis.driveWithJoyStick(oi.getJoystick());
        } catch(Exception e){
            finished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
