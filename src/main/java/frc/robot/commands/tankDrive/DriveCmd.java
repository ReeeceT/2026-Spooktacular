package frc.robot.commands.tankDrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsys;
import frc.robot.Constants.DigitalConstants;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

public class DriveCmd extends Command {

    private final DriveSubsys DS;
    private final CommandXboxController Xbox;
    private final CommandJoystick JOYSTICK;

    private double xboxLeftY;
    private double xboxRightX;

    private double joystickY;
    private double joystickX;

    public DriveCmd(DriveSubsys DS, CommandXboxController Xbox, CommandJoystick Joystick) {
        this.DS = DS;
        this.Xbox = Xbox;
        this.JOYSTICK = Joystick;
        addRequirements(DS); // For the purpose of letting the command scheduler know that this subsytem is a resource of this command.
    }

    @Override
    public void execute() {
        xboxLeftY = Xbox.getLeftY();
        xboxRightX = Xbox.getRightX();

        joystickY = JOYSTICK.getY();
        joystickX = JOYSTICK.getX();

        if (Xbox.leftBumper().getAsBoolean() == true) {
            // Go slow speed if left bumper
            xboxLeftY = Math.abs(xboxLeftY) > DigitalConstants.JOYSTICK_DEADBAND ? xboxLeftY * 0.25 : 0; 
            xboxRightX = Math.abs(xboxRightX) > DigitalConstants.JOYSTICK_DEADBAND ? xboxRightX * 0.25: 0;

            joystickY = Math.abs(joystickY) > DigitalConstants.JOYSTICK_DEADBAND ? joystickY * 0.25 : 0; 
            joystickX = Math.abs(joystickX) > DigitalConstants.JOYSTICK_DEADBAND ? joystickX * 0.25: 0;
        } else if (Xbox.rightBumper().getAsBoolean() == true) {
            // Go max speed if right bumper
            xboxLeftY = Math.abs(xboxLeftY) > DigitalConstants.JOYSTICK_DEADBAND ? xboxLeftY : 0; 
            xboxRightX = Math.abs(xboxRightX) > DigitalConstants.JOYSTICK_DEADBAND ? xboxRightX : 0;

            joystickY = Math.abs(joystickY) > DigitalConstants.JOYSTICK_DEADBAND ? joystickY : 0; 
            joystickX = Math.abs(joystickX) > DigitalConstants.JOYSTICK_DEADBAND ? joystickX : 0;
        } else {
            // Go normal speed if nothing pressed
            xboxLeftY = Math.abs(xboxLeftY) > DigitalConstants.JOYSTICK_DEADBAND ? xboxLeftY * 0.75 : 0; 
            xboxRightX = Math.abs(xboxRightX) > DigitalConstants.JOYSTICK_DEADBAND ? xboxRightX * 0.75: 0;

            joystickY = Math.abs(joystickY) > DigitalConstants.JOYSTICK_DEADBAND ? joystickY * 0.75 : 0; 
            joystickX = Math.abs(joystickX) > DigitalConstants.JOYSTICK_DEADBAND ? joystickX * 0.75: 0;
        }

        DS.drive(xboxLeftY, xboxRightX);
    }

}
