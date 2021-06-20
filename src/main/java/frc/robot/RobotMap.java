/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.interfaces.Gyro;

//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static DifferentialDrive drive;
  public static SpeedControllerGroup m_left;
  public static SpeedControllerGroup m_right;
  public static Talon intakeMotor;
  public static Talon shootMotor;
  public static Talon spinMotor;
  public static Talon rightFront;
  public static Talon rightBack;
  public static Talon leftBack;
  public static Talon leftFront;

  public static ADXRS450_Gyro gyro;
  //private static final int kport = 0;
  //public static Compressor pnueCompressor;
	//public static DoubleSolenoid gripper;
  //public static DoubleSolenoid cargo;

  public static final double deadzone = 0.1;

  public static void init(){
    rightFront = new Talon(0);
    rightBack = new Talon(1);
    leftBack = new Talon(2);
    leftFront = new Talon(3);
    intakeMotor = new Talon(4);
    shootMotor = new Talon(5);
    spinMotor = new Talon(6);
    
    m_left = new SpeedControllerGroup(leftFront, leftBack);
    m_right = new SpeedControllerGroup(rightFront, rightBack);

    rightFront.setInverted(true);
    rightBack.setInverted(true);

    drive = new DifferentialDrive(m_left, m_right);
    
    //driveTrainRobotDrive.setSafetyEnabled(saftey);
    //driveTrainRobotDrive.setExpiration(0.2);
    drive.setMaxOutput(3.0);
        
    gyro = new ADXRS450_Gyro();

    //pnueCompressor = new Compressor(0);
		
    //gripper = new DoubleSolenoid(0, 0, 1);
    //cargo = new DoubleSolenoid(0, 2, 3);
  }

  public static final boolean saftey = true;
}
