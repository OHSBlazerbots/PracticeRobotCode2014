package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.GenericControlsSubsystem1.RunKicker;
import edu.wpi.first.wpilibj.templates.commands.OverrideKicker;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //The robot controllers
    Joystick joystick = new Joystick(RobotMap.JOYSTICK_PORT), // Driver
            joystick2 = new Joystick(RobotMap.JOYSTICK2_PORT); //Co-Driver

    private final JoystickButton overrideF, overrideS, overrideB;
    
    /**
     *
     */
    public OI() {
        overrideF = new JoystickButton(joystick2, 4);
        overrideS = new JoystickButton(joystick2, 3);
        overrideB = new JoystickButton(joystick2, 1);
        
        overrideF.whileHeld(new OverrideKicker());
        overrideF.whenPressed(new RunKicker(1.0));
        
        overrideB.whileHeld(new OverrideKicker());
        overrideB.whenPressed(new RunKicker(-1.0));
        
        overrideS.whileHeld(new OverrideKicker());
        overrideS.whenPressed(new RunKicker(0.0));
    }

    //Returns the joystick that controls driving
    public Joystick getJoystick() {
        return joystick; //Driver
    }
    
    public Joystick getCoDriverJoystick(){
        return joystick2;
    }
}
