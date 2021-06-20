/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick joystick1;
  public JoystickButton spinLeft;
  public JoystickButton spinRight;
  public JoystickButton shoot;
  public JoystickButton intake;

  public OI(){
    joystick1 = new Joystick(0);
    spinLeft = new JoystickButton(joystick1, 2);
    spinRight = new JoystickButton(joystick1, 1);
    shoot = new JoystickButton(joystick1, 5);
    intake = new JoystickButton(joystick1, 3);

    spinLeft.whenPressed(new spinLeft(0.2));
    spinRight.whenPressed(new spinRight(0.2));
    shoot.whenPressed(new Shoot(1.5));
    intake.whenPressed(new Intake(0.5));
  }

  public Joystick getJoystick1(){
    return joystick1;
  }

  public double getJoystick1X(){
    if(Math.abs(joystick1.getX())>RobotMap.deadzone){
      return -joystick1.getX()*.75;
    } else {
      return 0.0;
    }
  }

  public double getJoystick1Y(){
    if(Math.abs(joystick1.getY())>RobotMap.deadzone){
      return joystick1.getY();
    }else {
      return 0.0;
    }
  }
}