package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 *
 */
public class Spinner extends Subsystem {
    
	Talon spin = (Talon) RobotMap.spinMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinLeft(double speed){
    	spin.set(speed);
    }
    
    public void spinRight(double speed){
    	spin.set(-speed);
    }
    
    public void stop(){
    	spin.set(0);
    }
    
}

