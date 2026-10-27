package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.Controllers;

public class ControllerBindings {
    private static final ControllerBindings INSTANCE = new ControllerBindings();
    private final CommandXboxController DRIVE_CONTROLLER = Controllers.XBOX;
    
    public void configureBindings() {
        // Put all controller bindings here
    }

    public static ControllerBindings getInstance() {
        return INSTANCE;
    }

    private ControllerBindings() {}
}
