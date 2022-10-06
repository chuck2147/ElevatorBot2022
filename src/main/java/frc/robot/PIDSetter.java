package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;

public class PIDSetter {
    public PIDSetter(double p, double i, double d, double f, TalonFX motor) {
        motor.config_kP(0, p);
        motor.config_kI(0, i);
        motor.config_kD(0, d);
        motor.config_kF(0, f);
    }

    public PIDSetter(double p, double i, double d) {
        PIDController pid = new PIDController(p, i, d);
    }
}
