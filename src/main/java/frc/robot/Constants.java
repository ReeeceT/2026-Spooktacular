package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public final class Constants {
    public final class CAN_IDs {
        public static final int FL_MOTOR_ID = 0; // Placeholder values
        public static final int FR_MOTOR_ID = 1;
        public static final int BL_MOTOR_ID = 2;
        public static final int BR_MOTOR_ID = 3;
    }

    public final class MotorControllers {
        public static final SparkMax FL_MOTOR = new SparkMax(CAN_IDs.FL_MOTOR_ID, MotorType.kBrushless);
        public static final SparkMax FR_MOTOR = new SparkMax(CAN_IDs.FR_MOTOR_ID, MotorType.kBrushless);

        public static final SparkMax BL_MOTOR = new SparkMax(CAN_IDs.BL_MOTOR_ID, MotorType.kBrushless);
        public static final SparkMax BR_MOTOR = new SparkMax(CAN_IDs.BR_MOTOR_ID, MotorType.kBrushless);
    }
}
