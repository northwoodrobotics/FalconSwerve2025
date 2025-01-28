package frc.robot.subsystems;

import static frc.robot.Constants.*;


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.GenericHID;


public class Shooter extends SubsystemBase {
  private final TalonFX m_Shooter = new TalonFX(ShooterID);
  private GenericHID xbox; 
  /** Creates a new Shooter. */
  public Shooter() {
    

    m_Shooter.getConfigurator().apply(new TalonFXConfiguration());

    m_Shooter.setInverted(true);
    xbox = RobotContainer.codriver.getHID();
    
  }

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
    m_Shooter.set(pwr);

  }


 
  public void stop() {
    m_Shooter.stopMotor();;
  }

 
}