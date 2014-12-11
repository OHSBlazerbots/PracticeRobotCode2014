/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.RunKickerWithTriggers;

/**
 *
 * @author sgoldman
 */
public class Kicker extends Subsystem {
    
    Jaguar kickMotor;
    private boolean buttonOverride;
    private DigitalInput limitSwitch;

    public void initDefaultCommand() {
        this.setDefaultCommand(new RunKickerWithTriggers());
    }

    public Kicker(int kickMotorPort, int limitSwitchPort) {
        if (kickMotorPort > -1) {
            this.kickMotor = new Jaguar(kickMotorPort);
        }
        limitSwitch = new DigitalInput(limitSwitchPort);
        buttonOverride = false;
    }
    
    public void setOverride(boolean o){
        buttonOverride = o;
    }
    
    public boolean isOverride(){
        return this.buttonOverride;
    }

    /**
     * Run the motor attached to jaguar 1 at the specified speed
     *
     * @param speed the speed to run the motor at. Between -1 and 1.
     */
    public void setJag1Speed(double speed) {
        if (kickMotor != null) {
            if (speed < -1.0) {
                speed = -1;
            }
            if(speed < 0){
                speed = speed;
            }
            if (speed > 0) {
                speed = speed * .25;
            }
            kickMotor.set(speed);
        }
    }

    /**
     * Stops the motor attached to jaguar 1. (Sets its speed to 0)
     */
    public void stopJag1() {
        if (kickMotor != null) {
            setJag1Speed(0.0);
        }
    }

    /**
     * Get the speed of the motor attached to jaguar 1
     *
     * @return
     */
    public double getJag1Speed() {
        if (kickMotor != null) {
            return kickMotor.get();
        } else {
            return 0.0;
        }
    }
    
    public boolean isFrisbeeIn(){
        return this.limitSwitch.get();
    }
}