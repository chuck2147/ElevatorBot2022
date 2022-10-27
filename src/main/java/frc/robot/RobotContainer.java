// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ElevatorButtonCommand;
import frc.robot.commands.ElevatorGoToBottomCommand;
import frc.robot.commands.ElevatorGoToMiddleCommand;
import frc.robot.commands.ElevatorGoToTopCommand;
import frc.robot.commands.ElevatorButtonCommand;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController controller = new XboxController(0);
  private final JoystickButton elevatorButton = new JoystickButton(controller, 1);
  private final JoystickButton elevatorBottomButton = new JoystickButton(controller, 2);
  private final JoystickButton elevatorMiddleButton = new JoystickButton(controller, 3);
  private final JoystickButton elevatorTopButton = new JoystickButton(controller, 4);
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final JoystickButton intakeForwardButton = new JoystickButton(controller, 5);
  private final JoystickButton intakeReverseButton = new JoystickButton(controller, 6);
  private final JoystickButton intakePistonOpenButton = new JoystickButton(controller, 7);
  private final JoystickButton intakePistonCloseButton = new JoystickButton(controller, 8);

  private final ElevatorButtonCommand elevatorCommand = new ElevatorButtonCommand(elevatorSubsystem);
  private final ElevatorButtonCommand m_autoCommand = new ElevatorButtonCommand(elevatorSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    elevatorButton.whileHeld(elevatorCommand);
    elevatorButton.whenReleased(elevatorSubsystem::stopMotor);//hi
    elevatorBottomButton.whenPressed(new ElevatorGoToBottomCommand(elevatorSubsystem, Constants.ELEVATOR_BOTTOM_ENCODER_VALUE));
    elevatorBottomButton.whenReleased(elevatorSubsystem::stopMotor);
    elevatorMiddleButton.whenPressed(new ElevatorGoToMiddleCommand(elevatorSubsystem, Constants.ELEVATOR_MIDDLE_ENCODER_VALUE));
    elevatorMiddleButton.whenReleased(elevatorSubsystem::stopMotor);
    elevatorTopButton.whenPressed(new ElevatorGoToTopCommand(elevatorSubsystem, Constants.ELEVATOR_TOP_ENCODER_VALUE));
    elevatorTopButton.whenReleased(elevatorSubsystem::stopMotor); 

    intakeForwardButton.whileHeld(intakeSubsystem::runIntake);
    intakeForwardButton.whenReleased(intakeSubsystem::stopIntake); 
    intakeReverseButton.whileHeld(intakeSubsystem::reverseIntake);
    intakeReverseButton.whenReleased(intakeSubsystem::stopIntake);
    intakePistonOpenButton.whenPressed(intakeSubsystem::OpenIntake); 
    intakePistonCloseButton.whenPressed(intakeSubsystem::ClosedIntake);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
     // An ExampleCommand will run in autonomous
     return m_autoCommand;
   }
}
