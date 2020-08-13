package frc.robot.commands.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class DriveToPosition extends CommandBase {
    private int encoderPosition;
    private final int ERROR_THRESHOLD = 50;
    public DriveToPosition(final int ticks) {
        addRequirements(Drivetrain.getInstance());
        encoderPosition = ticks;
    }
    @Override
    public void initialize() {
        super.initialize();
        
        Drivetrain.getInstance().getLeftMaster().setSelectedSensorPosition(0, RobotMap.LOOP_INDEX, 0);
        Drivetrain.getInstance().getRightMaster().setSelectedSensorPosition(0, RobotMap.LOOP_INDEX, 0);
    }

    @Override
    public void execute() {
        super.execute();
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position, encoderPosition);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position, encoderPosition);
    }
    @Override
    public boolean isFinished() {
        return (Drivetrain.getInstance().getLeftMaster().getClosedLoopError(RobotMap.LOOP_INDEX) < ERROR_THRESHOLD
                && Drivetrain.getInstance().getRightMaster().getClosedLoopError(RobotMap.LOOP_INDEX) < ERROR_THRESHOLD);
    }
    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Disabled, 0);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Disabled, 0);
    }
}