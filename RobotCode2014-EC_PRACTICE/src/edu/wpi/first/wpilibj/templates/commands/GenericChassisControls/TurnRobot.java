/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.GenericChassisControls;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author blazerbots
 */
public class TurnRobot extends CommandBase {
    
    private double speed;
    
    public TurnRobot(double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.drive(0, speed);
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
