package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorGoToMiddleCommand extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;
    private final double encoderValue;
    public ElevatorGoToMiddleCommand(ElevatorSubsystem elevatorSubsystem, double encoderValue) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.encoderValue = encoderValue;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        while (encoderValue < elevatorSubsystem.getElevatorEncoderValue()) {
            elevatorSubsystem.runMotor();
        } 
        elevatorSubsystem.stopMotor();
    }
}
