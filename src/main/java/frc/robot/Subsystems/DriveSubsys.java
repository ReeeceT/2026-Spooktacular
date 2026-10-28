package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.math.MathUtil;

import frc.robot.Constants;

public class DriveSubsys extends SubsystemBase {
    private final SparkMax RIGHT_SIDE;
    private final SparkMax LEFT_SIDE;

    public DriveSubsys() {
        LEFT_SIDE = Constants.MotorControllers.FL_MOTOR;
        LEFT_SIDE.configure(
            new SparkMaxConfig()
                .idleMode(IdleMode.kCoast), 
            ResetMode.kResetSafeParameters, 
            PersistMode.kPersistParameters
        );

        RIGHT_SIDE = Constants.MotorControllers.FR_MOTOR;
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
     * @param leftY   - Throttle
     * @param rightX  - Steering
     */
    public void drive(double leftY, double rightX) {
        // LEFT_SIDE.set((rightX > 0 && leftY > 0) ? (leftY - Math.abs(rightX)) : (rightX > 0 && leftY < 0) ? (leftY + Math.abs(rightX)) : leftY);
        // RIGHT_SIDE.set((rightX < 0 && leftY > 0) ? (leftY - Math.abs(rightX)) : (rightX < 0 && leftY < 0) ? (leftY + Math.abs(rightX)) : leftY);

        LEFT_SIDE.set(MathUtil.clamp(leftY - rightX, -1.0, 1.0));
        RIGHT_SIDE.set(MathUtil.clamp(leftY + rightX, -1.0, 1.0));
      
    }

    public void brake() {
        LEFT_SIDE.set(0);
        RIGHT_SIDE.set(0);
    }
}
