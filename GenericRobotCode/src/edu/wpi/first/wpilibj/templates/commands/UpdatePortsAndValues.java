/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 *
 * @author sgoldman
 */
public class UpdatePortsAndValues extends CommandBase {

    private boolean going = false;

    private Thread thread;

    public UpdatePortsAndValues() {
        requires(valueGetter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("ValueGetter Execute");
        RobotMap.REAR_RIGHT_MOTOR = valueGetter.getInt("DM-R-2-PORT");
        System.out.print(valueGetter.getInt("DM-R-2-PORT") + ":");
        RobotMap.FRONT_RIGHT_MOTOR = valueGetter.getInt("DM-R-1-PORT");
        System.out.print(valueGetter.getInt("DM-R-1-PORT") + ":");
        RobotMap.REAR_LEFT_MOTOR = valueGetter.getInt("DM-L-2-PORT");
        System.out.print(valueGetter.getInt("DM-L-2-PORT") + ":");
        RobotMap.FRONT_LEFT_MOTOR = valueGetter.getInt("DM-L-1-PORT");
        System.out.println(valueGetter.getInt("DM-L-1-PORT"));
        CommandBase.updateSubsystems();
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

    public void go() {
        thread = new Thread() {
            public void run() {
                while (going) {
                    execute();
                }
            }
        };
        going = true;
        thread.start();
    }

    public void stop() {
        going = false;
    }

}
