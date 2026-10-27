package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;

import frc.robot.Constants;

public class DriveSubsys extends SubsystemBase {
    private final SparkMax RIGHT_MOTOR;
    private final SparkMax LEFT_MOTOR;

    public DriveSubsys() {
        super();

        RIGHT_MOTOR = Constants.MotorControllers.F_RIGHT_MOTOR; // Currently just a single motor. Need to set followers
        RIGHT_FOLLOWER = Constants.MotorControllers.B_RIGHT_MOTOR.follow

        LEFT_MOTOR = Constants.MotorControllers.F_LEFT_MOTOR;
    }

    public void drive(double leftY, double rightY) {
        RIGHT_MOTOR.set(rightY);
        LEFT_MOTOR.set(leftY);
    }

    public void brake() {
        RIGHT_MOTOR.set(0);
        LEFT_MOTOR.set(0);
    }
}
