package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorGoToMiddleCommand extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;
    private final double encoderValueMiddle;
    public ElevatorGoToMiddleCommand(ElevatorSubsystem elevatorSubsystem, double encoderValue) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.encoderValueMiddle = encoderValue;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        while (true) {
            if(encoderValueMiddle - 50 > elevatorSubsystem.getElevatorEncoderValue()) {
                if (encoderValueMiddle - 50 > elevatorSubsystem.getElevatorEncoderValue()) {
                elevatorSubsystem.runMotor(); 
                }
            } else if (encoderValueMiddle + 50 < elevatorSubsystem.getElevatorEncoderValue()) {
                if (encoderValueMiddle - 50 < elevatorSubsystem.getElevatorEncoderValue()) {
                    elevatorSubsystem.reverseMotor();
                }
            } else elevatorSubsystem.stopMotor();
        } 
    }
}
