package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {

  private final Joystick joystick = new Joystick(0); 
  private final MotorController rmotor = new PWMSparkMax(1); 
  private final MotorController lmotor = new PWMSparkMax(0);  
  private final DifferentialDrive driveTrain = new DifferentialDrive(lmotor, rmotor);

  @Override
  public void teleopPeriodic() {
    driveTrain.arcadeDrive(joystick.getY(), joystick.getX());
  }
}