package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotValues;
import edu.wpi.first.wpilibj.templates.commands.GenericChassisControls.DriveRobot;
import edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1.HaltKicker;
import edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1.RunKicker;

/**
 * This is the autonomous command.
 * Drive forward and shoot.
 * @author jmuller4
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
        addSequential(new DriveRobot(RobotValues.AUTO_DRIVE_SPEED, .05));
        addParallel(new Auto2());
        addSequential(new WaitCommand(4.1));
        addSequential(new RunKicker(1));
        addSequential(new WaitCommand(.2));
        addSequential(new HaltKicker());
        addSequential(new WaitCommand(.4));
        addSequential(new RunKicker(-.75));
        addSequential(new WaitCommand(.3));
        addSequential(new HaltKicker());

    }
}