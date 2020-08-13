package frc.robot;

public class DriveToPosition extends CommandBase {
    private int encoderPosition;
    private final int ERROR_THRESHOLD = 50;
    public DriveToPosition(int ticks){
        addRequirements(Drivetrain.getInstance());
        encoderPositions = ticks;
    }
    @Override
    public void initialize() {
        super.initialize();
        
        Drivetrain.getInstance().getLeftMaster().setSelectedSendorPosition(0, RobotMap.LOOP_INDEX, 0);
        Drivetrain.getInstance().getRightMaster().setSelectedSendorPosition(0, RobotMap.LOOP_INDEX, 0);
    }

    @Override
    public void execute() {
        super.execute();
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position, encoderPosition);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position, encoderPosition);
    }
    @Override
    public boolean isFinished() {
        return (Drivetrain.getInstance().getLeftMaster().getCloseLoopError(RobotMap.LOOP_INDEX) < ERROR_THRESHOLD && Drivetrain.getInstance().getRightMaster().getCloseLoopError(RobotMap.LOOP_INDEX) < ERROR_THRESHOLD)
    }
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Disabled, 0);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Disabled, 0);
    }
}