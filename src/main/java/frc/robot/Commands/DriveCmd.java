package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveSubsys;
import frc.robot.Constants.Subsystems;

public class DriveCmd extends Command {

    private final DriveSubsys DS = Subsystems.DS;
    
    public DriveCmd() {
        super();


    }

    @Override
    public void initialize() {
        DS.driveForward();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

}
