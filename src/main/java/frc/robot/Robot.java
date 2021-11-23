// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Timer;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final DriveTrain drivetrain = new DriveTrain();
  private final ballLoader loader = new ballLoader();
  private final XboxController controller = new XboxController(0);
  private final Timer timer = new Timer();

  private double rot;
  private double speed;

  // private boolean drove = false;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    timer.reset();
    timer.start();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
   // m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    timer.reset();
    // drivetrain.resetEncoders();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    if (timer.get() < 2.0) {// & drove == false) {
      DriveTrain.arcadeDrive(0.7, 0.0); // drive forwards half speed
    } else {
      DriveTrain.stop(); // stop robot
      // drove = true;
      // timer.reset();
    }
    // if (timer.get() < 1.0 & drove == true) {
    //   loader.setSpeed(0.7);
    // } else {
    //   loader.stop();
    // }

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    if (controller.getX(Hand.kRight) >= 0.1 | controller.getX(Hand.kRight) <= -0.1) {
      rot = controller.getX(Hand.kRight);
    } else {
      rot = 0;
    }
    if (controller.getY(Hand.kLeft) >= 0.1 | controller.getY(Hand.kLeft) <= -0.1) {
      speed = controller.getY(Hand.kLeft);
    } else {
      speed = 0;
    }
    if (speed >= 0.7) {
      speed = 0.7;
    } else if (speed <= -0.7) {
      speed = -0.7;
    }
    if (rot >= 0.7) {
      rot = 0.7;
    } else if (rot <= -0.7) {
      rot = -0.7;
    }
    DriveTrain.arcadeDrive(-speed, -rot);
    
    loader.setSpeed(-controller.getTriggerAxis(Hand.kRight));
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
