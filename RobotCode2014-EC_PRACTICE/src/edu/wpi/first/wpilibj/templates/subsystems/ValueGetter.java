/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author sgoldman
 */
public class ValueGetter extends Subsystem {

    private NetworkTable table;

    public ValueGetter() {
        table = NetworkTable.getTable("NetworkTables/NetworkTables");
        //System.out.println("Table has been created: " + table);
        table.putBoolean("hi", true);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public int getInt(String var) {
        if (table == null) {
            //System.out.println("Table is null. Oops!");
        }
        if (var == null) {
            return -1;
        }
        try {
            //System.out.println(var + ":" + table.getNumber(var));
            return (int) table.getNumber(var);
        } catch(Exception e){
            table.putNumber(var, -1);
            return -1;
        }
    }
}
