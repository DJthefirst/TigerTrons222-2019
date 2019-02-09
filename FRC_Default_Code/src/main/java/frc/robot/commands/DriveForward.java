
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/*This command drives drives forward until an encoder value is met.
Created by Eric
*/

public class DriveForward extends Command {

    double driveSpeed;
    double driveDistance;
    private WPI_TalonSRX leftSlave1Talon = Robot.m_drivetrain.getLeftTalon();
    
    public DriveForward(double inches, double drivespeed)
    {
        requires(Robot.m_drivetrain);
        driveDistance = inches;
        driveSpeed = drivespeed;
    }


    @Override 
    protected void initialize()
    {
        Robot.m_drivetrain.ResetEncoder(); 
    }

    @Override 
    protected void execute()
    {

        driveDistance = driveDistance*1000;

        // Read and print encoder values
        System.out.println("Sensor Vel:" + leftSlave1Talon.getSelectedSensorVelocity());
        System.out.println("Sensor Pos:" + leftSlave1Talon.getSelectedSensorPosition());
        System.out.println("Out %" + leftSlave1Talon.getMotorOutputPercent());  
        System.out.println("Dist: " + driveDistance);

        while(leftSlave1Talon.getSelectedSensorPosition() > -driveDistance){ //negative is forward

            double moveSpeed = driveSpeed; //positive is forward
            if (moveSpeed>1){moveSpeed=1;} //max speed

            //optional
	        if (Math.abs(moveSpeed) < 0.10) {
			    // within 10% joystick, make it zero 
			    moveSpeed = 0;
		    }
            Robot.m_drivetrain.arcadeDrive(moveSpeed, 0);

            
        
        }
    }
    

    @Override 
    protected boolean isFinished()
    {
        return false;
    }



    @Override 
    protected void end(){       
        Robot.m_drivetrain.arcadeDrive(0,0);
    }

    @Override 
    protected void interrupted()
    {
        end();
    }
}