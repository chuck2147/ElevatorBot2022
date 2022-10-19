package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
private TalonFX leftIntakeMotor = new TalonFX(Constants.LEFT_INTAKE_MOTOR);
private TalonFX rightIntakeMotor = new TalonFX(Constants.RIGHT_INTAKE_MOTOR);
private TalonFX rotateIntakeMotor = new TalonFX(Constants.ROTATE_INTAKE_MOTOR);

private DoubleSolenoid leftPiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
Constants.LEFT_PISTON_FORWARD_CHANNEL, Constants.LEFT_PISTON_REVERSE_CHANNEL);

public IntakeSubsystem() {

}

}