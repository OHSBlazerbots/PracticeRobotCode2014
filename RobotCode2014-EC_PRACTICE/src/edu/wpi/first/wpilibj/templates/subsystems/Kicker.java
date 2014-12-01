/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author sgoldman
 */
public class Kicker extends Subsystem {
    
    Jaguar kickMotor;

    public void initDefaultCommand() {
    }

    public Kicker(int kickMotorPort) {
        if (kickMotorPort > -1) {
            this.kickMotor = new Jaguar(kickMotorPort);
        }
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
            if (speed > 1.0) {
                speed = 1;
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
}