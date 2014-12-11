/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1.HaltKicker;
import edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1.RunKicker;

/**
 *
 * @author sgoldman
 */
public class KickFrisbee extends CommandGroup {
    
    public KickFrisbee() {
        addSequential(new WaitCommand(.25));
        addSequential(new RunKicker(.25));
        addSequential(new WaitCommand(.25));
        addSequential(new RunKicker(-1));
        addSequential(new WaitCommand(.25));
        addSequential(new HaltKicker());
        addSequential(new WaitCommand(.1));
    }
}