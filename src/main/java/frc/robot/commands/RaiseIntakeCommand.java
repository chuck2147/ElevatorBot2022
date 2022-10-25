package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PerpetualCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.IntakeSubsystem;

public class RaiseIntakeCommand extends CommandBase{
    private final IntakeSubsystem intakeSubsystem; 

    public RaiseIntakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
      new PerpetualCommand(new RunCommand(()-> {
        intakeSubsystem.raiseIntake();
      }, intakeSubsystem)).withTimeout(1);
    }
}
