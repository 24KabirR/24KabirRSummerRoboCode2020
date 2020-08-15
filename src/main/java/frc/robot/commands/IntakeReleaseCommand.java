package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotMap;
import frc.robot.subsystems.HatchLatcher;

public class IntakeReleaseCommand extends InstantCommand{
    public IntakeReleaseCommand(){
        addRequirements(Intake.getInstance());
    }


    @Override
    public void initialize() {
        super.initialize();
        Intake.getInstance().getSolenoid().set(Intake.getInstance().invert(Intake.getInstance().getSolenoidVal()));
    }


}
