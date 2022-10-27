package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlFrameEnhanced;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    private TalonFX leftIntakeMotor = new TalonFX(Constants.LEFT_INTAKE_MOTOR_ID);
    private TalonFX rightIntakeMotor = new TalonFX(Constants.RIGHT_INTAKE_MOTOR_ID);
    private TalonFX verticalIntakeMotor = new TalonFX(Constants.VERTICAL_INTAKE_MOTOR_ID);
    private PneumaticsModuleType leftIntakeDoubleSolenoidType = PneumaticsModuleType.REVPH;
    private PneumaticsModuleType rightIntakeDoubleSolenoidType = PneumaticsModuleType.REVPH;
    private DoubleSolenoid IntakeDoubleSolenoid = new DoubleSolenoid(leftIntakeDoubleSolenoidType, 
    Constants.INTAKE_PISTON_FORWARD_CHANNEL, Constants.INTAKE_PISTON_REVERSE_CHANNEL);

    public IntakeSubsystem() {
        leftIntakeMotor.setNeutralMode(NeutralMode.Coast);
        rightIntakeMotor.setNeutralMode(NeutralMode.Coast);
        verticalIntakeMotor.setNeutralMode(NeutralMode.Brake);

        leftIntakeMotor.setInverted(false);
        rightIntakeMotor.setInverted(false);
    }

    public void runIntake() {
        leftIntakeMotor.set(ControlMode.PercentOutput, 0.5);
        rightIntakeMotor.set(ControlMode.PercentOutput, 0.5);
    }

    public void reverseIntake() {
        leftIntakeMotor.set(ControlMode.PercentOutput, -0.5);
        rightIntakeMotor.set(ControlMode.PercentOutput, -0.5);
    }
    public void stopIntake() {
        leftIntakeMotor.set(ControlMode.PercentOutput, 0);
        rightIntakeMotor.set(ControlMode.PercentOutput, 0);
    }

    public void raiseIntake() {
        verticalIntakeMotor.set(ControlMode.PercentOutput, 0.5);
    }

    public void dropIntake() {
        verticalIntakeMotor.set(ControlMode.PercentOutput, -0.5);
    }

    public void OpenIntake() {
        IntakeDoubleSolenoid.set(Value.kForward);
    }

    public void ClosedIntake() {
        IntakeDoubleSolenoid.set(Value.kReverse);
    }
}
