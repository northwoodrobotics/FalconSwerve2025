package frc.robot.subsystems;

import static frc.robot.Constants.*;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.GenericHID;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Shooter extends SubsystemBase {

  private final TalonSRX m_shooter = new TalonSRX(ShooterID);

  private final static Shooter INSTANCE = new Shooter();

  public static  Shooter getInstance() {
      return INSTANCE;
  }
  private GenericHID xbox;
  public Shooter() {
      m_shooter.setInverted(true);
      m_shooter.setNeutralMode(NeutralMode.Brake);
      m_shooter.configContinuousCurrentLimit(12);
      m_shooter.configPeakCurrentLimit(12);
      xbox = RobotContainer.codriver.getHID();
  }




   
  /** Creates a new Shooter. */


  public Command getIntakeCommand(){

    return this.startEnd(
      () -> {launch(kShooterIntakeSpeed);
      },
      () -> {
        stop();
      });
  }
  
  public void launch(double pwr) {
    if (xbox.getRawButton(2))
    {
      pwr=pwr*0.5;
    }
    else if (xbox.getRawButton(1))
  
    {
      pwr=pwr*0.1;
    }
    m_shooter.set(TalonSRXControlMode.PercentOutput, pwr);

  }


 
  public void stop() {
    m_shooter.set(TalonSRXControlMode.PercentOutput, 0);
  }

 
}