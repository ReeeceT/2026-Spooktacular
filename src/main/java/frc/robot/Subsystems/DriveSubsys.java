package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.REVLibError;

import frc.robot.Constants;

public class DriveSubsys extends SubsystemBase {
    private final SparkMax RIGHT_SIDE;
    private final SparkMax LEFT_SIDE;

    public DriveSubsys() {
        LEFT_SIDE = Constants.MotorControllers.FL_MOTOR;
        RIGHT_SIDE = Constants.MotorControllers.FR_MOTOR;

        LEFT_SIDE.configure(
            new SparkMaxConfig()
                .idleMode(IdleMode.kCoast), 
            ResetMode.kResetSafeParameters, // erm why are all of the only applicable arguments all deprecated
            PersistMode.kPersistParameters
        );

        RIGHT_SIDE.configure(
            new SparkMaxConfig()
                .idleMode(IdleMode.kCoast), 
            ResetMode.kResetSafeParameters, 
            PersistMode.kPersistParameters
        );

        Constants.MotorControllers.BL_MOTOR.configure(
            new SparkMaxConfig()
                .follow(Constants.CAN_IDs.FL_MOTOR_ID)
                .idleMode(IdleMode.kCoast), 
            ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters
        );

        Constants.MotorControllers.BR_MOTOR.configure(
            new SparkMaxConfig()
                .follow(Constants.CAN_IDs.FR_MOTOR_ID)
                .idleMode(IdleMode.kCoast), 
            ResetMode.kResetSafeParameters, 
            PersistMode.kPersistParameters
        );
    }

    /**
     * @param leftY   - Speed of each side is determined by this parameter
     * @param rightX  - Turning is determined by this parameter
     * 
     */
    public void drive(double leftY, double rightX) {
        // Assuming that left on the joystick is -1, and right is +1
        // lol this is unbelievably disgusting and nearly completely unreadable
        LEFT_SIDE.set((rightX > 0 && leftY > 0) ? (leftY - Math.abs(rightX)) : (rightX > 0 && leftY < 0) ? (leftY + Math.abs(rightX)) : leftY);
        RIGHT_SIDE.set((rightX < 0 && leftY > 0) ? (leftY - Math.abs(rightX)) : (rightX < 0 && leftY < 0) ? (leftY + Math.abs(rightX)) : leftY);
    }

    public void brake() {
        LEFT_SIDE.set(0);
        RIGHT_SIDE.set(0);
    }
}
