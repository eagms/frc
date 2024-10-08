package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;

public class Arm extends TimedRobot {

  private final PIDController pid = new PIDController(0.1, 0.0, 0.0);
  private final PWMSparkMax motorsys = new PWMSparkMax(2);
  private final Encoder encoder = new Encoder(0, 1);

  private static final double angle = 45.0;

  @Override
  public void robotInit() {
    encoder.reset();

    encoder.setDistancePerPulse(360.0 / 4096.0);
  }

  @Override
  public void teleopPeriodic() {
    motorsys.set(pid.calculate(encoder.getDistance(), angle));
  }
}
