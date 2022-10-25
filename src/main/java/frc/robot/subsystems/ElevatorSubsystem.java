// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.PIDSetter;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonFX elevatorMotor = new TalonFX(Constants.ELEVATOR_MOTOR_ID);
  private DoubleSolenoid elevatorBreak = new DoubleSolenoid(PneumaticsModuleType.REVPH, 
  Constants.ELEVATOR_BREAK_FORWARD, Constants.ELEVATOR_BREAK_BACKWARD);

  public ElevatorSubsystem() {
    new PIDSetter(0, 0, 0, 0, elevatorMotor);
    elevatorMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void runMotor() {
    elevatorMotor.set(ControlMode.PercentOutput, Constants.ELEVATOR_MOTOR_SPEED);
  }

  public void reverseMotor() {
    elevatorMotor.set(ControlMode.PercentOutput, -Constants.ELEVATOR_MOTOR_SPEED);
  }

  public double getElevatorEncoderValue() {
    return elevatorMotor.getSelectedSensorPosition();
  }
public void stopMotor() {
  elevatorMotor.set(ControlMode.PercentOutput, 0);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
