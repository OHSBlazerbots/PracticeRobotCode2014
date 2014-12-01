/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.PutSensorData;

/**
 *
 * @author sgoldman
 */
public class Sensor extends Subsystem {

    private ADXL345_I2C accelerometer;
    private Gyro gyroscope;
    private AnalogChannel sonar;
    private double distance;

    public void initDefaultCommand() {
        new PutSensorData();
    }

    public Sensor(int accelPort, int gyroPort, int sonarPort) {
        if (accelPort > -1) {
            accelerometer = new ADXL345_I2C(accelPort, ADXL345_I2C.DataFormat_Range.k2G);
        }

        if (gyroPort > -1) {
            gyroscope = new Gyro(gyroPort);
        }

        if (sonarPort > -1) {
            sonar = new AnalogChannel(sonarPort);
        }
    }

    public double getGyroAngle() {
        double angle = gyroscope.getAngle() % (360);
        if (angle < 0.0) {
            angle += 360;
        }
        return angle;
    }

    public double[] getAcceleration() {
        double[] a = new double[2];
        a[0] = accelerometer.getAcceleration(ADXL345_I2C.Axes.kX);
        a[1] = accelerometer.getAcceleration(ADXL345_I2C.Axes.kY);
        return a;
    }

    public double getAccelerationX() {
        return getAcceleration()[0];
    }

    public double getAccelerationY() {
        return getAcceleration()[1];
    }
    
    public double getSonarDistance() {
        double r = SmartDashboard.getNumber("Sonar Number", 4.0);
        double d = (sonar.getValue() / r * 2 / 2.54);
        if (d > 150) {
        } else {
            distance = d;
        }
        return distance;
    }
}