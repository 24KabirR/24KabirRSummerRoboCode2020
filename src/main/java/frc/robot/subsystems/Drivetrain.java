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
    private static boolean isFinished = true;


    private static final boolean LEFT_MASTER_INVERTED = true;
    private static final boolean LEFT_FOLLOWER_INVERTED = true;
    private static final boolean RIGHT_MASTER_INVERTED = false;
    private static final boolean RIGHT_FOLLOWER_INVERTED = false;

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
        invertTalons(LEFT_MASTER_INVERTED, LEFT_FOLLOWER_INVERTED, RIGHT_MASTER_INVERTED, RIGHT_FOLLOWER_INVERTED)

        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
    }

    private void resetTalons() {
        leftMaster.reset();
        leftFollower.reset();
        rightMaster.reset();
        rightFollower.reset();
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