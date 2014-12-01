/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author sgoldman
 */
public class RunSubsystem1Motor1 extends CommandBase {
    
    private double speed;
    
    public RunSubsystem1Motor1(double speed) {
        requires(kicker);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        kicker.setJag1Speed(speed);
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