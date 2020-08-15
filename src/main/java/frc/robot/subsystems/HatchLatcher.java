package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class HatchLatcher extends SubsystemBase {
    private static HatchLatcher hatchLatcher;

    private final DoubleSolenoid extenderSolenoid;

    private final DoubleSolenoid flowerSolenoid;

    private HatchLatcher() {
        extenderSolenoid = new DoubleSolenoid(RobotMap.EXTENDER_FORWARD_PORT, RobotMap.EXTENDER_REVERSE_PORT);
        flowerSolenoid = new DoubleSolenoid(RobotMap.FLOWER_FORWARD_PORT, RobotMap.FLOWER_REVERSE_PORT);
        
    }


    public DoubleSolenoid getExtenderSolenoid() {
        return extenderSolenoid;
    }
    public DoubleSolenoid getFlowerSolenoid() {
        return flowerSolenoid;
    }

    public static HatchLatcher getInstance() {
        if(hatchLatcher == null) {
            hatchLatcher = new HatchLatcher();
        }
        return hatchLatcher;
    }

    public DoubleSolenoid.Value getExtenderVal() {
        return extenderSolenoid.get();
    }

    public DoubleSolenoid.Value getFlowerVal(){
        return flowerSolenoid.get();
    }
    

    public DoubleSolenoid.Value invert(DoubleSolenoid.Value value){
       if(value == DoubleSolenoid.Value.kForward) {
            return DoubleSolenoid.Value.kReverse;
        } else {
            return DoubleSolenoid.Value.kForward;
        }        
    }

}