package frc.robot.commands.tankDrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsys;
import frc.robot.Constants.DigitalConstants;
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
    public void initialize() {
        
    }

    @Override
    public void execute() {
        leftY = Xbox.getLeftY();
        leftY = leftY > DigitalConstants.JOYSTICK_DEADBAND ? leftY : 0; 

        rightX = Xbox.getRightX();
        rightX = rightX > DigitalConstants.JOYSTICK_DEADBAND ? rightX : 0; 

        DS.drive(leftY, rightX);
    }

    @Override
    public void end(boolean interrupted) {

    }

}
