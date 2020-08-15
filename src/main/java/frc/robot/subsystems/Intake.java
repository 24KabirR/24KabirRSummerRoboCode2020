  
package frc.robot.subsystems;

import frc.robot.RobotMap;
import harkerrobolib.subsystems.HSIntake;
import harkerrobolib.wrappers.HSTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake extends SubsystemBase {
    private static Intake instance;

    private DoubleSolenoid solenoid;
    private HSTalon spinner;

    private Intake() {
        spinner=new HSTalon(RobotMap.INTAKE);
        solenoid=new DoubleSolenoid(RobotMap.INTAKE_FORWARD_PORT, RobotMap.INTAKE_REVERSE_PORT);
    }

    public static Intake getInstance() {
        if (instance == null)
            instance = new Intake();
        return instance;
    }

    public DoubleSolenoid getSolenoid() {
        return solenoid;
    }

    public DoubleSolenoid.Value getSolenoidVal() {
        return solenoid.get();
    }


    public DoubleSolenoid.Value invert(DoubleSolenoid.Value value){
        if(value == DoubleSolenoid.Value.kForward) {
             return DoubleSolenoid.Value.kReverse;
         } else {
             return DoubleSolenoid.Value.kForward;
         }        
     }

     public HSTalon getSpinner(){
         return spinner;
     }

}