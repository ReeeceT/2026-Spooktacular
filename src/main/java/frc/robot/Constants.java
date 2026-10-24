package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public final class Constants {
    public final class Controllers {
        public static final CommandXboxController XBOX = new CommandXboxController(0);
    }

    public final class CAN_IDs {
        public static final int RF_MOTOR_ID = 1;
        public static final int RB_MOTOR_ID = 2;

        public static final int LF_MOTOR_ID = 3;
        public static final int LB_MOTOR_ID = 4;
    }

    public final class MotorControllers {
        public static final SparkMax RIGHT_MOTOR = new SparkMax(CAN_IDs.RF_MOTOR_ID, MotorType.kBrushless);
        public static final SparkMax RIGHT_F_MOTOR = new SparkMax(CAN_IDs.RB_MOTOR_ID, MotorType.kBrushless);

        public static final SparkMax LEFT_MOTOR = new SparkMax(CAN_IDs.LF_MOTOR_ID, MotorType.kBrushless);
        public static final SparkMax LEFT_F_MOTOR = new SparkMax(CAN_IDs.LB_MOTOR_ID, MotorType.kBrushless);
    }
}
