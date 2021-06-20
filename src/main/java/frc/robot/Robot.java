/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.DriveTrain;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  //private final DifferentialDrive m_robotDrive
  //    = new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(1));
  //private final Joystick m_stick = new Joystick(0);
  //private final Timer m_timer = new Timer();

  //create a link to the subsystems
  public static DriveTrain m_drive;
  public static Launcher Launcher;
  public static Spinner Spinner;

  /** Controls/inputs **/
  public static OI m_oi;
  
  /** Auto Stuff **/
  Command m_autonomousCommand;
  SendableChooser<Command> m_Command = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.init();

    m_drive = new DriveTrain();
    Launcher = new Launcher();
    Spinner = new Spinner();
    
    // OI must be constructed after subsystems.
    m_oi = new OI();

    /** Auto stuffs **/
    m_Command.setDefaultOption("default", new AutoLine(0.5, 1.8));
		//m_Command.addOption("Right Switch", new RightAuto());
		//m_Command.addOption("Left Switch", new LeftAuto());
		m_Command.addOption("Do Nothing", null);
		SmartDashboard.putData("Auto Mode", m_Command);
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
   /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    //m_timer.reset();
    //m_timer.start();
    SmartDashboard.putString("Progress", "");
		SmartDashboard.putNumber("TellyOP Angle", 0);
		SmartDashboard.putNumber("Rotate Angle", 0);
    
    m_autonomousCommand = m_Command.getSelected();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    
    // Drive for 2 seconds
    /*if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      m_robotDrive.stopMotor(); // stop robot
    }*/
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    //RobotMap.gyro.reset();
  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("TellyOP Angle", RobotMap.gyro.getAngle());		//display Angle
    //m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
  }
}
