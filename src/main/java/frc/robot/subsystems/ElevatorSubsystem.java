// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.PIDSetter;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonFX elevatorMotor = new TalonFX(Constants.ELEVATOR_MOTOR_ID);
  public ElevatorSubsystem() {
    new PIDSetter(0.25, 0, 1, 1, elevatorMotor);
  }

  public void runMotor() {
    elevatorMotor.set(ControlMode.PercentOutput, Constants.ELEVATOR_MOTOR_SPEED);
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
