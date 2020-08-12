package frc.robot;

public class DriveToPosition extends CommandBase {
    private int encoderPositions;
    DriveToPosition(int ticks){
        addRequirements(Drivetrain.getInstance());
        encoderPositions = ticks;
    }
    @Override
    public void initialize() {
        super.initialize();
        Drivetrain.configPositionPIDConstants();
        Drivetrain.leftMaster.setSelectedSendorPosition(0, RobotMap.LOOP_INDEX, 0);
        Drivetrain.rightMaster.setSelectedSendorPosition(0, RobotMap.LOOP_INDEX, 0);
    }

    @Override
    public void execute() {
        super.execute();
        Drivetrain.leftMaster.set(ControlMode.Position, encoderPosition);
        Drivetrain.rightMaster.set(ControlMode.Position, encoderPosition);
    }
    @Override
    public boolean isFinished(){
        if(Math.abs(encoderPosition-Drivetrain.leftMaster.getSelectedSensorPosition)<leftMaster.getCloseLoopError(RobotMap.LOOP_INDEX) &&
        Math.abs(encoderPosition-Drivetrain.rightMaster.getSelectedSensorPosition)<rightMaster.getCloseLoopError(RobotMap.LOOP_INDEX)){
            return true;
        }
        return false;
    }
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        Drivetrain.leftMaster.set(ControlMode.Disabled, 0);
        Drivetrain.rightMaster.set(ControlMode.Disabled, 0);
    }
}