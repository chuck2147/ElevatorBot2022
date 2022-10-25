package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorGoToTopCommand extends CommandBase{
    private final ElevatorSubsystem elevatorSubsystem;
    private final double encoderValueTop;
    public ElevatorGoToTopCommand(ElevatorSubsystem elevatorSubsystem, double encoderValue) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.encoderValueTop = encoderValue;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        while (encoderValueTop > elevatorSubsystem.getElevatorEncoderValue()) {
            elevatorSubsystem.runMotor();
        } 
        elevatorSubsystem.stopMotor();
    }
}
