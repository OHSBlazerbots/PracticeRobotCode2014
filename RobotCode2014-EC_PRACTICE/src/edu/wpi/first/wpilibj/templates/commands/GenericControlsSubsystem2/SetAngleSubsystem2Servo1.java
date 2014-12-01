/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem2;

import edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1.*;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author sgoldman
 */
public class SetAngleSubsystem2Servo1 extends CommandBase {

    private double angle;
   
    public SetAngleSubsystem2Servo1(double angle) {
        requires(subsystem1);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        subsystem1.setServo2Angle(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}