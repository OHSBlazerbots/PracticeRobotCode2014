/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Compressor;

/**
 *
 * @author mshellman2
 */
public class Pneumatics extends Subsystem {
    //Relays
    Relay relay1;
    //Solenoids
    DoubleSolenoid solenoid1, solenoid2;
    //Compressor
    Compressor compressor;
    
    public Pneumatics(int relayVal, int fwdSolenoid1, int revSolenoid1, int fwdSolenoid2, int revSolenoid2, int pressureSwitch, int compressRelay)
    {
        relay1 = new Relay(relayVal);
        if(fwdSolenoid1 > -1 && revSolenoid1 > -1)
        {
            solenoid1 = new DoubleSolenoid(fwdSolenoid1, revSolenoid1);
        }
        if(fwdSolenoid2 > -1 && revSolenoid2 > -1)
        {
            solenoid2 = new DoubleSolenoid(fwdSolenoid2, revSolenoid2);
        }
        compressor = new Compressor(pressureSwitch, compressRelay);
        compressor.start(); 
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Turn on relay
    public void turnOn(){
        relay1.set(Relay.Value.kOn);
    }
    
    //Turn off relay
    public void turnOff(){
        relay1.set(Relay.Value.kOff);
    }
    
    //Get relay on and get air direction
    public boolean getRelayOn(){
        return(relay1.get() == Relay.Value.kOn);
    }  
    
    public boolean getIsAirIn(){
        return (solenoid1.get() == DoubleSolenoid.Value.kForward);
    }
    
    public boolean getIsAirOut(){
        return(solenoid1.get() == DoubleSolenoid.Value.kReverse);
    }
    
    //Set positions
    public void airOut(){
        solenoid1.set(DoubleSolenoid.Value.kForward);
        solenoid2.set(DoubleSolenoid.Value.kForward);
    }
    
    public void airIn(){
        solenoid1.set(DoubleSolenoid.Value.kReverse);
        solenoid2.set(DoubleSolenoid.Value.kReverse);
    }
    }
    
    
    
    
    
     