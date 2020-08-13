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
import harkerrobolib.util.Conversions;
import harkerrobolib.wrappers.HSTalon;
import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;


public class OI {
    private static OI oi;

    private HSGamepad driverGamepad;
    private HSGamepad operatorGamepad;

    private OI() {
        driverGamepad = new XboxGamepad(RobotMap.DRIVER_PORT);
        operatorGamepad = new XboxGamepad(RobotMap.OPERATOR_PORT);
        
    }    

    public HSGamepad getDriverGamepad() {
        return driverGamepad;
    }

    public HSGamepad getOperatorGamepad() {
        return operatorGamepad;
    }

    public static OI getInstance() {
        if(oi == null) {
            oi = new OI();
        }
        return oi;
    }
}