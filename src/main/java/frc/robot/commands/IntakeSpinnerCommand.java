package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeSpinnerCommand extends IndefiniteCommand{
    private double speed;

    public IntakeSpinnerCommand(double speed){
        addRequirements(Intake.getInstance());
        this.speed=speed;
    }

    @Override
    public void initialize() {
        super.initialize();

    }

    @Override
    public void execute() {
        super.execute();

        Intake.getInstance().getSpinner().set(ControlMode.PercentOutput, speed);

    }

    @Override
    public void end(final boolean interrupted) {
        super.end(interrupted);
        Intake.getInstance().getSpinner().set(ControlMode.Disabled, 0);
    }
}