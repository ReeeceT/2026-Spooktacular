package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveSubsys;
import frc.robot.Constants.digitalConstants;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class DriveCmd extends Command {

    private final DriveSubsys DS;
    private final CommandXboxController Xbox;

    private double leftY;
    private double rightY;

    public DriveCmd(DriveSubsys DS, CommandXboxController Xbox) {
        super();

        this.DS = DS;
        this.Xbox = Xbox;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        leftY = Xbox.getLeftY();
        leftY = leftY > digitalConstants.JOYSTICK_Y_DEADBAND ? leftY : 0; // Apply Deadband

        rightY = Xbox.getRightY();
        rightY = rightY > digitalConstants.JOYSTICK_Y_DEADBAND ? rightY : 0; // Apply Deadband

        DS.driveForward(leftY, rightY);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("The drive command has ended?! It shouldn't be doing that at all");
    }

}
