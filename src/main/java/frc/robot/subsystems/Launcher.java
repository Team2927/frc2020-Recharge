package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 *
 */
public class Launcher extends Subsystem {
    
	Talon intake = (Talon) RobotMap.intakeMotor;
	Talon shoot = (Talon) RobotMap.shootMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Shoot(double speed){
    	shoot.set(speed);
    }
    
    public void Intake(double speed){
    	intake.set(speed);
    }
    
    public void stop(){
    	intake.set(0);
    	shoot.set(0);
    }
    
}

