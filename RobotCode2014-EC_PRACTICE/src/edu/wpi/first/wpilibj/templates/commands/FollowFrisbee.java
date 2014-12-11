/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.buttons.Trigger.ButtonScheduler;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author sgoldman
 */
public class FollowFrisbee extends CommandBase {

    //Run kick command
    KickFrisbee kf = new KickFrisbee();
    
    public FollowFrisbee() {
        requires(chassis);
        requires(kicker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.setFollowingFrisbee(true);
        Scheduler.getInstance().add(kf);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        kf.cancel();
        double x = network.getNetworkVariable("COG_X");

        double turn_velocity = 0.0;
        if (x < 290) {
            turn_velocity = -.4;
        } else if (x > 350) {
            turn_velocity = .4;
        } else if (x > 290 && x < 310) {
            turn_velocity = -.2;
        } else if (x < 350 && x > 330) {
            turn_velocity = .2;
        } else {
            turn_velocity = 0;
        }

        if (kicker.isFrisbeeIn()) {
            kf.start();
        } else {
            chassis.drive(.4, turn_velocity);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return chassis.isFollowingFrisbee();
    }

    // Called once after isFinished returns true
    protected void end() {
        chassis.setFollowingFrisbee(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}