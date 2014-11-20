/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.NIVisionException;

/**
 *
 * @author blazerbots
 */
public class Camera extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Servo tilt;
    Servo pan;
    
    private static AxisCamera cam;
    
    public Camera(int pan_port, int tilt_port)
    {
        tilt = new Servo(tilt_port);
        pan = new Servo(pan_port);
        cam = AxisCamera.getInstance("10.38.7.11");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void snapShot()
    {
        try {
            cam.getImage().write("/tmp/snapShot.jpg");
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
    }

    public void driveWithJoyStick(Joystick joy) {
        double x = joy.getX();
        double y = joy.getY();
        pan.setAngle(pan.getAngle() + x);
        tilt.setAngle(tilt.getAngle() + y);
    }
}
