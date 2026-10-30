package frc.robot.commands.tankDrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DigitalConstants;
import frc.robot.Subsystems.DriveSubsys;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriveCmd extends Command {

    private final DriveSubsys DS;
    private final CommandXboxController Xbox;

    private double leftY;
    private double rightX;

    public DriveCmd(DriveSubsys DS, CommandXboxController Xbox) {
        this.DS = DS;
        this.Xbox = Xbox;
        addRequirements(DS); // For the purpose of letting the command scheduler know that this subsytem is a resource of this command.
    }

    @Override
    public void execute() {
        leftY = Xbox.getLeftY();
        rightX = Xbox.getRightX();

        if (Xbox.leftBumper().getAsBoolean() == true) {
            // Go slow speed if left bumper
            leftY = Math.abs(leftY) < DigitalConstants.JOYSTICK_DEADBAND ? 0 : leftY * 0.25; 
            rightX = Math.abs(rightX) < DigitalConstants.JOYSTICK_DEADBAND ? 0 :  rightX * 0.25;
        } else if (Xbox.rightBumper().getAsBoolean() == true) {
            // Go max speed if right bumper
            leftY = Math.abs(leftY) < DigitalConstants.JOYSTICK_DEADBAND ? 0 : leftY; 
            rightX = Math.abs(rightX) < DigitalConstants.JOYSTICK_DEADBAND ? 0 : rightX;
        } else {
            // Go normal speed if nothing pressed
            leftY = Math.abs(leftY) < DigitalConstants.JOYSTICK_DEADBAND ? 0 : leftY * 0.75; 
            rightX = Math.abs(rightX) < DigitalConstants.JOYSTICK_DEADBAND ? 0 : rightX * 0.75;
        }

        DS.drive(leftY, rightX);
    }

}
