package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystem.DriveTrain;

public class autonomous extends CommandBase {

    private final Timer timer = new Timer();
    private static DriveTrain drivetrain = new DriveTrain();

    public void execute() {
        if (timer.get() < 2.0) {// & drove == false) {
            DriveTrain.arcadeDrive(0.7, 0.0); // drive forwards half speed
          } else {
            DriveTrain.stop(); // stop robot
            // drove = true;
            // timer.reset();
          }
    }
}
