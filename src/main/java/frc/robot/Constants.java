package frc.robot;



import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsys;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

public final class Constants {
    public final class Controllers {
        public static final CommandXboxController XBOX = new CommandXboxController(0);
    }

    public final class Subsystems {
        public static final DriveSubsys DS = new DriveSubsys();
    }

    public final class CAN_IDs {
        public static final int FR_MOTOR_ID = 1;
        public static final int BR_MOTOR_ID = 2; // Follows RF 

        public static final int FL_MOTOR_ID = 3;
        public static final int BL_MOTOR_ID = 4; // Follows LF
    }

    public final class MotorControllers {
        public static final SparkMax FR_MOTOR = new SparkMax(CAN_IDs.FR_MOTOR_ID, MotorType.kBrushless);
        public static final SparkMax BR_MOTOR = new SparkMax(CAN_IDs.BR_MOTOR_ID, MotorType.kBrushless);

        public static final SparkMax FL_MOTOR = new SparkMax(CAN_IDs.FL_MOTOR_ID, MotorType.kBrushless);
        public static final SparkMax BL_MOTOR = new SparkMax(CAN_IDs.BL_MOTOR_ID, MotorType.kBrushless);
    }

    public final class DigitalConstants {
        public static final double JOYSTICK_DEADBAND = 0.1;
    }

    public enum CommandEnums {
        DRIVE_CMD;
    }
}
