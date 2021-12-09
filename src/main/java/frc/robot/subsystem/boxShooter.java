package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Spark;

public class boxShooter {
  private static final Spark Motor1 = new Spark(6);
  private static final Spark Motor2 = new Spark(7);

  public void setSpeed(double speed) {
    Motor1.setSpeed(speed);
    Motor2.setSpeed(-speed);
  }

  public void stop() {
    Motor1.stopMotor();
    Motor2.stopMotor();
  }
}
