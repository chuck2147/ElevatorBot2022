package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorGoToBottomCommand extends CommandBase{
    private final ElevatorSubsystem elevatorSubsystem;
    private final double encoderValueBottom;
    public ElevatorGoToBottomCommand(ElevatorSubsystem elevatorSubsystem, double encoderValue) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.encoderValueBottom = encoderValue;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        while (encoderValueBottom < elevatorSubsystem.getElevatorEncoderValue()) {
            elevatorSubsystem.reverseMotor();
        } 
        elevatorSubsystem.stopMotor();
    }
}
