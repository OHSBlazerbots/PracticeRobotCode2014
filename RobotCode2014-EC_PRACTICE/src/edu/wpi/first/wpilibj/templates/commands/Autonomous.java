package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotValues;
import edu.wpi.first.wpilibj.templates.commands.GenericChassisControls.DriveRobot;
import edu.wpi.first.wpilibj.templates.commands.GenericChassisControls.HaltRobot;

/**
 * This is the autonomous command.
 * Drive forward and shoot.
 * @author jmuller4
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
        addSequential(new DriveRobot(RobotValues.AUTO_DRIVE_SPEED));
        addSequential(new WaitCommand(RobotValues.AUTO_DRIVE_TIME));
        addSequential(new HaltRobot());
    }
}