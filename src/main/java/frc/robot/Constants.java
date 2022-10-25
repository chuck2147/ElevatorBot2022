// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.43;
    /**
     * The front-to-back distance between the drivetrain wheels.
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_WHEELBASE_METERS = 0.49;

    public static final int DRIVETRAIN_PIGEON_ID = 13;

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 1;
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 2;
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 3;
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(0);


    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 4;
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 5;
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 6;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(0);


    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 7;
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 8;
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 9;
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(0);
    

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 10;
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 11;
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 12;
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(0);

    public final static int ELEVATOR_MOTOR_ID = 14;
    public final static int ELEVATOR_BREAK_FORWARD = 4;
    public final static int ELEVATOR_BREAK_BACKWARD = 5;
    public final static double ELEVATOR_MOTOR_SPEED = 0.5;
    public final static double ELEVATOR_BOTTOM_ENCODER_VALUE = 0;
    public final static double ELEVATOR_MIDDLE_ENCODER_VALUE = 1000;
    public final static double ELEVATOR_TOP_ENCODER_VALUE = 5000;

    public final static int VERTICAL_INTAKE_MOTOR_ID = 15;
    public final static int LEFT_INTAKE_MOTOR_ID = 16;
    public final static int RIGHT_INTAKE_MOTOR_ID = 17;
    public final static int LEFT_DOUBLESOLENOID_FORWARD_CHANNEL = 0;
    public final static int LEFT_DOUBLESOLENOID_REVERSE_CHANNEL = 1;
    public final static int RIGHT_DOUBLESOLENOID_FORWARD_CHANNEL = 2; 
    public final static int RIGHT_DOUBLESOLENOID_REVERSE_CHANNEL = 3;
}
