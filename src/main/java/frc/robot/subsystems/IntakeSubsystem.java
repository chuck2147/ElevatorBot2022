package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    private TalonFX leftIntakeMotor = new TalonFX(Constants.LEFT_INTAKE_MOTOR_ID);
    private TalonFX rightIntakeMotor = new TalonFX(Constants.RIGHT_INTAKE_MOTOR_ID);
    private TalonFX verticalIntakeMotor = new TalonFX(Constants.VERTICAL_INTAKE_MOTOR_ID);
    private PneumaticsModuleType leftIntakeDoubleSolenoidType = PneumaticsModuleType.REVPH;
    private PneumaticsModuleType rightIntakeDoubleSolenoidType = PneumaticsModuleType.REVPH;
    private DoubleSolenoid leftIntakeDoubleSolenoid = new DoubleSolenoid(leftIntakeDoubleSolenoidType, 
    Constants.LEFT_DOUBLESOLENOID_FORWARD_CHANNEL, Constants.LEFT_DOUBLESOLENOID_REVERSE_CHANNEL);
    private DoubleSolenoid rightIntakeDoubleSolenoid = new DoubleSolenoid(rightIntakeDoubleSolenoidType, 
    Constants.RIGHT_DOUBLESOLENOID_FORWARD_CHANNEL, Constants.RIGHT_DOUBLESOLENOID_REVERSE_CHANNEL);

    public IntakeSubsystem() {
        leftIntakeMotor.setNeutralMode(NeutralMode.Coast);
        rightIntakeMotor.setNeutralMode(NeutralMode.Coast);
        verticalIntakeMotor.setNeutralMode(NeutralMode.Brake);

        leftIntakeMotor.setInverted(false);
        rightIntakeMotor.setInverted(false);
    }

    public void stopIntake() {
    }

    public void raiseIntake() {
        verticalIntakeMotor.set(ControlMode.PercentOutput, 0.5);
    }

    public void dropIntake() {
        verticalIntakeMotor.set(ControlMode.PercentOutput, -0.5);
    }
}
