package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants;

public class DriveSubsys extends SubsystemBase {
    private final SparkMax RIGHT_SIDE;
    private final SparkMax LEFT_SIDE;

    public DriveSubsys() {
        super();

        RIGHT_SIDE = Constants.MotorControllers.FR_MOTOR;
        Constants.MotorControllers.BR_MOTOR.configure(
            new SparkMaxConfig().follow(Constants.CAN_IDs.FR_MOTOR_ID), 
            ResetMode.kResetSafeParameters, // erm why are all of the only applicable arguments all deprecated
            PersistMode.kPersistParameters
        );

        LEFT_SIDE = Constants.MotorControllers.FL_MOTOR;
        Constants.MotorControllers.BL_MOTOR.configure(
            new SparkMaxConfig().follow(Constants.CAN_IDs.FL_MOTOR_ID), 
            ResetMode.kResetSafeParameters, // erm why are all of the only applicable arguments all deprecated
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
        if (rightX < 0) LEFT_SIDE.set(leftY - Math.abs(rightX));
        if (rightX > 0) RIGHT_SIDE.set(leftY - Math.abs(rightX));
    }

    public void brake() {
        LEFT_SIDE.set(0);
        RIGHT_SIDE.set(0);
    }
}
