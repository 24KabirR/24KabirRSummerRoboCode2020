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

public class Drivetrain
{
    private static final Drivetrain drivetrain;
    private static boolean isFinished = true;

    private Drivetrain() 
    {
        
    }

    public static getInstance() {
        if(drivetrain == null) {
            drivetrain = new Drivetrain();
        }
        return drivetrain;
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