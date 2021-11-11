// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot;

// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {
  // private static final double CountsPerRevolution = 1440.0;
  // private static final double WheelDiameterInch = 2.75591; // 70 mm

  private static final Spark LMotor = new Spark(0);
  private static final Spark Rmotor = new Spark(2);

  // private final Encoder LEncoder = new Encoder(4, 5);
  // private final Encoder REncoder = new Encoder(6, 7);

  private static final DifferentialDrive diffDrive = new DifferentialDrive(LMotor, Rmotor);

  // public void resetEncoders() {
  //     LEncoder.reset();
  //     REncoder.reset();
  // }
  
  // public RDriveTrain() {
  //   // Use inches as unit for encoder distances
  //   LEncoder.setDistancePerPulse((Math.PI * WheelDiameterInch) / CountsPerRevolution);
  //   REncoder.setDistancePerPulse((Math.PI * WheelDiameterInch) / CountsPerRevolution);
  //   resetEncoders();
  // }

  public static void arcadeDrive(double speed, double rotation) {
      diffDrive.arcadeDrive(speed, rotation);
  }

  // public double getLeftDistanceInch() {
  //   return LEncoder.getDistance();
  // }

  // public double getRightDistanceInch() {
  //   return REncoder.getDistance();
  // }
}
