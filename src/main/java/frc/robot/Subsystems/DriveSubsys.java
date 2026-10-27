package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants;

public class DriveSubsys extends SubsystemBase {
    private final SparkMax RIGHT_MOTOR;
    private final SparkMax LEFT_MOTOR;

    public DriveSubsys() {
        super();

        RIGHT_MOTOR = Constants.MotorControllers.F_RIGHT_MOTOR;
        Constants.MotorControllers.B_RIGHT_MOTOR.configure(
            new SparkMaxConfig().follow(Constants.CAN_IDs.FR_MOTOR_ID), 
            ResetMode.kResetSafeParameters, // erm why are all of the only applicable arguments all deprecated
            PersistMode.kPersistParameters
        );

        LEFT_MOTOR = Constants.MotorControllers.F_LEFT_MOTOR;
        Constants.MotorControllers.B_LEFT_MOTOR.configure(
            new SparkMaxConfig().follow(Constants.CAN_IDs.BR_MOTOR_ID), 
            ResetMode.kResetSafeParameters, // erm why are all of the only applicable arguments all deprecated
            PersistMode.kPersistParameters
        );
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
