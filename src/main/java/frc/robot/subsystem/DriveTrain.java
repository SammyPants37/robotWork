// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot.subsystem;

// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {
  static Spark m_frontLeft = new Spark(0);
  static Spark m_rearLeft = new Spark(1);
  static SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

  static Spark m_frontRight = new Spark(2);
  static Spark m_rearRight = new Spark(3);
  static SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  static DifferentialDrive diffDrive = new DifferentialDrive(m_left, m_right);

  public static void arcadeDrive(double speed, double rotation) {
      diffDrive.arcadeDrive(speed, rotation);
  }

  public static void stop() {
    diffDrive.stopMotor();
  }
}
