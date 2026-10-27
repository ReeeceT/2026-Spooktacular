package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;

import frc.robot.Constants;

public class DriveSubsys extends SubsystemBase {
    private final SparkMax RIGHT_MOTORS;
    private final SparkMax LEFT_MOTORS;

    public DriveSubsys() {
        super();

        RIGHT_MOTORS = Constants.MotorControllers.RIGHT_MOTOR; // Currently just a single motor. Need to set followers
        LEFT_MOTORS = Constants.MotorControllers.LEFT_MOTOR;
    }

    public void driveForward(double leftY, double rightY) {
        RIGHT_MOTORS.set(rightY);
        LEFT_MOTORS.set(leftY);
    }

    public void brake() {
        RIGHT_MOTORS.set(0);
        LEFT_MOTORS.set(0);
    }
}
