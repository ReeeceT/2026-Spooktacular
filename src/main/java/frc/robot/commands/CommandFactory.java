package frc.robot.commands;

import frc.robot.Constants.CommandEnums;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Subsystems;
import frc.robot.Constants.Controllers;
import frc.robot.Constants.Subsystems;
import frc.robot.commands.tankDrive.DriveCmd;

public final class CommandFactory {
    public static Command getCommand(CommandEnums cmdEnum) {
        switch (cmdEnum) {
            case DRIVE_CMD: return new DriveCmd(Subsystems.DS, Controllers.XBOX, Controllers.JOYSTICK);
            
            default: return null; 
        }
    }

    private CommandFactory() {};
}
