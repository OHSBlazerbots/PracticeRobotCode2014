/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
    
/**
 *
 * @author sgoldman
 */
public class ValueGetter extends Subsystem {
    private NetworkTable table;
    
    public ValueGetter(){
        table = NetworkTable.getTable("SmartDashboard");
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public int getInt(String var){
        return (int) table.getNumber(var);
    }
}