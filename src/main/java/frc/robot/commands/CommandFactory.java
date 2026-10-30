package frc.robot.commands;

import frc.robot.Constants.CommandEnums;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.Constants.Controllers;
import frc.robot.commands.tankDrive.DriveCmd;

public final class CommandFactory {
    public Command getCommand(CommandEnums cmdEnum) { // Make this static again
        switch (cmdEnum) {
            case DRIVE_CMD: return new DriveCmd(Robot.DS, Controllers.XBOX);
            
            default: return null; 
        }
    }

    public CommandFactory() {};
}
