package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotMap;
import frc.robot.subsystems.HatchLatcher;

public class LatchHatch extends InstantCommand{
    public LatchHatch(){
        addRequirements(HatchLatcher.getInstance());
    }


    @Override
    public void initialize() {
        super.initialize();
        HatchLatcher.getInstance().getExtenderSolenoid().set(HatchLatcher.getInstance().invert(HatchLatcher.getInstance().getExtenderVal()));
        HatchLatcher.getInstance().getFlowerSolenoid().set(HatchLatcher.getInstance().invert(HatchLatcher.getInstance().getFlowerVal()));
    }


}
