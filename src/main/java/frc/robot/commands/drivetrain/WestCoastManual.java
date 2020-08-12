package frc.robot.commands.drivetrain;

import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

public class WestCoastManual extends harkerrobolib.commands.drivetrain.WestCoastManaul{
    public WestCoastManual(){
        super(Drivetrain.getInstance(), 
        Drivetrain.DRIVE_VELOCITY_SLOT, Drivetrain.ANGLE_POSITION_SLOT, 
        OI.getInstance().getDriverGamepad(), 
        Drivetrain.MAX_DRIVE_VELOCITY, Drivetrain.MAX_ROTATION_VELOCITY, 
        Drivetrain.PIGEON_kP, 
        OUTPUT_MULTIPLIER);
    
    }


    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public void end(boolean interrupted) {

        super.end(interrupted);
         
    }
}