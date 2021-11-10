// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;

// Motors 
import edu.wpi.first.wpilibj.VictorSP; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

// Encoders
import edu.wpi.first.wpilibj.Encoder;

//Controller
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;










public class Robot extends TimedRobot {

  // Driving Motors
  private final VictorSP leftMotor1 = new VictorSP(Constants.m_leftMotor1);
  private final VictorSP leftMotor2 = new VictorSP(Constants.m_leftMotor2);
  private final VictorSP rightMotor1 = new VictorSP(Constants.m_rightMotor1);
  private final VictorSP rightMotor2 = new VictorSP(Constants.m_rightMotor2);

  // Angle Motors
  private final VictorSP leftAngle1 = new VictorSP(Constants.m_leftAngle1);
  private final VictorSP leftAngle2 = new VictorSP(Constants.m_leftAngle2);
  private final VictorSP rightAngle1 = new VictorSP(Constants.m_rightAngle1);
  private final VictorSP rightAngle2 = new VictorSP(Constants.m_rightAngle2);
 
  // Motor groups
  private final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(leftMotor1,leftMotor2);
  private final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(rightMotor1,rightMotor2);

  private final SpeedControllerGroup m_leftAngles = new SpeedControllerGroup(leftAngle1,leftAngle2);
  private final SpeedControllerGroup m_rightAngles = new SpeedControllerGroup(rightAngle1,rightAngle2);

  private final DifferentialDrive m_driveTrain = new DifferentialDrive(m_leftMotors,m_rightMotors);
  private final DifferentialDrive m_turnAngle = new DifferentialDrive(m_leftAngles,m_rightAngles);

  // Controller(s) 
  private final XboxController driverController = new XboxController(Constants.driverController);


  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    double triggerVal = (driverController.getTriggerAxis(Hand.kRight) - 
    driverController.getTriggerAxis(Hand.kLeft))* Constants.drivingSpeed;
   
    // Forward and back
    m_driveTrain.arcadeDrive(triggerVal, 0);

    /* get the X-Axis and Y-axis of the joystick. use the inverse tangent and have 
    the tan^-1(x-axis/y-axis). Find the angle with respect to the Y-axis. Make this angle
    feed into the Neos
    */

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
