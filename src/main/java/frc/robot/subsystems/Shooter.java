package frc.robot.subsystems;

import static frc.robot.Constants.*;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.GenericHID;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;


public class Shooter extends SubsystemBase {

  private final TalonFX m_shooterMotor = new TalonFX(ShooterID);
 /** Creates a new Shooter. */
  public Shooter() {
    

    m_shooterMotor.getConfigurator().apply(new TalonFXConfiguration());

    m_shooterMotor.setInverted(true);
    
  }

  
  public void launch(double pwr) {
   
    m_shooterMotor.set(pwr);

  }
 
  public void stop() {
    m_shooterMotor.stopMotor();;
  }

 
}