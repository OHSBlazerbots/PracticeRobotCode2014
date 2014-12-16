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

    double last_cog_y;
    double last_cog_x;

    //Run kick command
    public FollowFrisbee() {
        requires(chassis);
        requires(kicker);
        requires(network);
        this.last_cog_x = 0;
        this.last_cog_y = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.setFollowingFrisbee(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double x = network.getNetworkVariable("COG_X");
        double y = network.getNetworkVariable("COG_Y");
        System.out.println(x + ":" + y);
        if (this.last_cog_y < 230) {
            this.last_cog_x = x;
            this.last_cog_y = y;

            chassis.drive(-.4, 0);
        } else {
            this.last_cog_x = x;
            this.last_cog_y = y;
            double turn_velocity = 0.0;
            if (x < 290) {
                turn_velocity = .4;
            } else if (x > 350) {
                turn_velocity = -.4;
            } else if (x > 290 && x < 310) {
                turn_velocity = .2;
            } else if (x < 350 && x > 330) {
                turn_velocity = -.2;
            } else {
                turn_velocity = 0;
            }

            chassis.drive(-.4, turn_velocity);
        }

        }
        // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("IF: " + !chassis.isFollowingFrisbee());
        return !chassis.isFollowingFrisbee();
    }

    // Called once after isFinished returns true
    protected void end() {
        //chassis.setFollowingFrisbee(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
