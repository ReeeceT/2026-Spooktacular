package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.Controllers;

public class ControllerBindings {
    private final CommandXboxController DRIVE_CONTROLLER;


    public ControllerBindings() {
        DRIVE_CONTROLLER = Controllers.XBOX;

        configureBindings();
    }

    public void configureBindings() {
        DRIVE_CONTROLLER.rightBumper().and(DRIVE_CONTROLLER.leftBumper()).whileTrue(
            
        );
    }
}
