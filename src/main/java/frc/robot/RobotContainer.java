// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ElevatorButtonCommand;
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
  private final Joystick controller = new Joystick(0);
  private final JoystickButton elevatorButton = new JoystickButton(controller, 1);
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  
  private final JoystickButton pistonOpenButton = new JoystickButton(controller, 2);
  private final JoystickButton pistonCloseButton = new JoystickButton(controller, 3);

  private final JoystickButton intakeForwardButton = new JoystickButton(controller, 4);
  private final JoystickButton intakeReverseButton = new JoystickButton(controller, 5);


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
    intakeForwardButton.whileHeld(intakeSubsystem::intakeForward);
    intakeReverseButton.whileHeld(intakeSubsystem::intakeReverse);
    pistonOpenButton.whenPressed(intakeSubsystem::intakeForwardPiston);
    pistonCloseButton.whenPressed(intakeSubsystem::intakeReversePiston);
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
