// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.Constants.CommandEnums;
import frc.robot.commands.CommandFactory;

// TODO: Reformat the Roborio and the re-deploy code

public class Robot extends TimedRobot {
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        ControllerBindings.getInstance().configureBindings();

        CommandScheduler.getInstance().schedule(
            CommandFactory.getCommand(CommandEnums.DRIVE_CMD)
        );
    }

    @Override
    public void teleopPeriodic() {}

    @Override
    public void teleopExit() {}

    public Robot() {}
}
