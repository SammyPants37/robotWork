package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Spark;

public class ballLoader {
  private static final Spark Motor = new Spark(1);

  public void setSpeed(double speed) {
    Motor.setSpeed(speed);
  }

  public void stop() {
    Motor.stopMotor();
  }
}
