package frc.robot.Subsystems;

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
    public void drive(double leftY, double rightX, double joystickY, double joystickX) {
        double speed = -leftY; // Xbox Y axis reads negative when pushed forward
        double turn = rightX;  // Positive turns right

        double joystickSpeed = -joystickY;
        double joystickTurn = joystickX;

        // Left side is mounted flipped, so its output is negated
        LEFT_SIDE.set(-MathUtil.clamp((speed - turn) + (joystickSpeed - joystickTurn), -1.0, 1.0));
        RIGHT_SIDE.set(MathUtil.clamp((speed + turn) + (joystickSpeed + joystickTurn), -1.0, 1.0));
    }

    public void brake() {
        LEFT_SIDE.set(0);
        RIGHT_SIDE.set(0);
    }
}
