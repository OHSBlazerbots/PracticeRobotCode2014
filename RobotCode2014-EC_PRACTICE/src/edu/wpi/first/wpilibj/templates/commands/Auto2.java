/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotValues;
import edu.wpi.first.wpilibj.templates.commands.GenericChassisControls.DriveRobot;
import edu.wpi.first.wpilibj.templates.commands.GenericChassisControls.HaltRobot;
import edu.wpi.first.wpilibj.templates.commands.GenericChassisControls.TurnRobot;

/**
 *
 * @author blazerbots
 */
public class Auto2 extends CommandGroup {
    
    public Auto2() {
        addSequential(new WaitCommand(5));
        addSequential(new TurnRobot(.25));
        addSequential(new WaitCommand(.25));
        addSequential(new DriveRobot(1, -.6));
        addSequential(new WaitCommand(1.5));
        addSequential(new HaltRobot());
    }
}
