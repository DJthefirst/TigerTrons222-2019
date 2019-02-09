package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/*This command drives drives forward until an encoder value is met.
Created by Eric
*/

public class ArmUp extends Command {

    double armSpeed;
    double armDistance;
    private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();
    
    public ArmUp(double arminches, double armspeed)
    {
        requires(Robot.m_arm);
        armDistance = arminches;
        armSpeed = armspeed;
    }


    @Override 
    protected void initialize()
    {
       // Robot.m_arm.ResetArmEncoder(); 
    }

    @Override 
    protected void execute()
    {

        armDistance = armDistance*100;

        // Read and print encoder values
        System.out.println("Sensor Vel:" + armMotorMaster.getSelectedSensorVelocity());
        System.out.println("Sensor Pos:" + armMotorMaster.getSelectedSensorPosition());
        System.out.println("Out %" + armMotorMaster.getMotorOutputPercent());  
        // System.out.println("Dist: " + armDistance);
        if (armDistance > armMotorMaster.getSelectedSensorPosition());
        {
            while(armMotorMaster.getSelectedSensorPosition() < armDistance)
            { //negative is forward
                Robot.m_arm.armDrive(armSpeed);
                Robot.m_drivetrain.arcadeDrive(0, 0);
            }
            
        
        }
        if(armDistance < armMotorMaster.getSelectedSensorPosition());
        {
            while(armMotorMaster.getSelectedSensorPosition() < armDistance)
            { //negative is forward 
                Robot.m_arm.armDrive(-armSpeed);
                Robot.m_drivetrain.arcadeDrive(0, 0);
            }
            
        
        }
    }
    

    @Override 
    protected boolean isFinished()
    {
        return false;
    }



    @Override 
    protected void end(){       
        Robot.m_arm.armDrive(0);
    }

    @Override 
    protected void interrupted()
    {
        end();
    }
}