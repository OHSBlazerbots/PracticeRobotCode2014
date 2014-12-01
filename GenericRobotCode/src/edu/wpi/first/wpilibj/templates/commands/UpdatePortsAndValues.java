/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.RobotValues;
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
        RobotMap.REAR_RIGHT_MOTOR = valueGetter.getInt("DM-R-2-PORT");
        RobotMap.FRONT_RIGHT_MOTOR = valueGetter.getInt("DM-R-1-PORT");
        RobotMap.REAR_LEFT_MOTOR = valueGetter.getInt("DM-L-2-PORT");
        RobotMap.FRONT_LEFT_MOTOR = valueGetter.getInt("DM-L-1-PORT");
        RobotMap.SUBSYSTEM1_JAG1 = valueGetter.getInt("S1M-1-PORT");
        RobotMap.SUBSYSTEM1_JAG2 = valueGetter.getInt("S1M-2-PORT");
        RobotMap.SUBSYSTEM2_JAG1 = valueGetter.getInt("S2M-1-PORT");
        RobotMap.SUBSYSTEM2_JAG2 = valueGetter.getInt("S2M-2-PORT");
        RobotMap.SUBSYSTEM1_RELAY1 = valueGetter.getInt("S1R-1-PORT");
        RobotMap.SUBSYSTEM1_RELAY2 = valueGetter.getInt("S1R-2-PORT");
        RobotMap.SUBSYSTEM2_RELAY1 = valueGetter.getInt("S2R-1-PORT");
        RobotMap.SUBSYSTEM2_RELAY2 = valueGetter.getInt("S2R-2-PORT");
        RobotMap.SUBSYSTEM1_SERVO1 = valueGetter.getInt("S1SE-1-PORT");
        RobotMap.SUBSYSTEM1_SERVO2 = valueGetter.getInt("S1SE-2-PORT");
        RobotMap.SUBSYSTEM2_SERVO1 = valueGetter.getInt("S2SE-1-PORT");
        RobotMap.SUBSYSTEM2_SERVO2 = valueGetter.getInt("S2SE-2-PORT");
        RobotMap.GYRO_PORT = valueGetter.getInt("Gyro-1-Port");
        RobotMap.SONAR_PORT = valueGetter.getInt("Son-1-Port");
        RobotMap.ACCELEROMETER_PORT = valueGetter.getInt("Acc-1-Port");
        RobotValues.PAN_CONSTANT = valueGetter.getInt("Pan-Con");
        RobotValues.TILT_CONSTANT = valueGetter.getInt("Tilt-Con");
        System.out.println("Test: " + valueGetter.getInt("test"));
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
