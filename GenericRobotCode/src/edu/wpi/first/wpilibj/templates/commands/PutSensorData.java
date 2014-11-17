/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author sgoldman
 */
public class PutSensorData extends CommandBase {

    public PutSensorData() {
        requires(sensor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putNumber("Gyro", sensor.getGyroAngle());
        SmartDashboard.putNumber("AccelX", sensor.getAccelerationX());
        SmartDashboard.putNumber("AccelY", sensor.getAccelerationY());
        SmartDashboard.putNumber("Sonar", sensor.getSonarDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}