package frc.robot;

/**
 * Creates a drivetrain.
 * 
 * @author Kabir Ramzan
 * @author Ashwin Kuppahally
 * @author Varun Fuloria
 * @author Brendan Zankowski
 * @since August 11, 2020
 */

import edu.wpi.first.wpilibj.RobotBase;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.DriveWithVelocity;
import harkerrobolib.subsystems.HSDrivetrain;
import harkerrobolib.util.Conversions;
import harkerrobolib.wrappers.HSTalon;
import harkerrobolib.*;

public class Drivetrain extends SubsystemBase {
    private static final Drivetrain drivetrain;


    private static final boolean LEFT_MASTER_INVERTED = false;
    private static final boolean LEFT_FOLLOWER_INVERTED = false;
    private static final boolean RIGHT_MASTER_INVERTED = false;
    private static final boolean RIGHT_FOLLOWER_INVERTED = false;

    private static boolean leftSensorPhase = false;
    private static boolean rightSensorPhase = false;

    private static final double P = 1;
    private static final double I = 1;
    private static final double D = 1;
    private static final double SLOT_INDEX;

    private Drivetrain() {
        HSTalon leftMaster = new HSTalon();
        HSTalon leftFollower = new HSTalon();
        HSTalon rightMaster = new HSTalon();
        HSTalon rightFollower = new HSTalon();
    }

    public static getInstance() {
        if(drivetrain == null) {
            drivetrain = new Drivetrain();
        }
        return drivetrain;
    }

    public void talonInit() {
        resetTalons();
        followMasters();
        invertTalons(LEFT_MASTER_INVERTED, LEFT_FOLLOWER_INVERTED, RIGHT_MASTER_INVERTED, RIGHT_FOLLOWER_INVERTED);


        leftMaster.setSensorPhase(leftSensorPhase);
        rightMaster.setSensorPhase(rightSensorPhase);
    }

    private void resetTalons() {
        leftMaster.reset();
        leftFollower.reset();
        rightMaster.reset();
        rightFollower.reset();
    }

    public void configPositionPIDConstants() {
        leftMaster.config_kP(p);
        leftMaster.config_kI(i);
        leftMaster.config_kD(d);

        rightMaster.config_kP(p);
        rightMaster.config_kI(i);
        rightMaster.config_kD(d);

        selectProfileSlot(SLOT_INDEX, RobotMap.LOOP_INDEX);
        
        leftMaster.configSelectedFeedbackSensor(CTRE_MagEncoder_Reletive, RobotMap.LOOP_INDEX, 0);
        rightMaster.configSelectedFeedbackSensor(CTRE_MagEncoder_Reletive, RobotMap.LOOP_INDEX, 0);
    }

    private void followMasters() {
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
    }

    private void invertTalons(boolean leftMasterInverted, boolean leftFollowerInverted, boolean rightMasterInverted, boolean rightFollowerInverted) {
        leftMaster.setInverted(leftMasterInverted);
        leftFollower.setInverted(leftFollowerInverted);
        rightMaster.setInverted(rightMasterInverted);
        rightFollower.setInverted(rightFollowerInverted);
    }


    public void setPercentOutput(double x, double y){
        leftMaster.set(ControlMode.PercentOutput, y + x);
        rightMaster.set(ControlMode.PercentOutput, y - x);
    }
    /* public moveForward() {

    }

    public moveBackward() {

    }

    public turnLeft() {

    }

    public turnRight() {
        
    }

    public execute() {
        if(isFinished) {
            isFinished = false;
            // Code here
            isFinished = true;
        }
    }  */
    
}