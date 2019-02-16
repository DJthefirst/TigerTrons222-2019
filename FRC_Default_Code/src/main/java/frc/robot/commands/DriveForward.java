
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import edu.wpi.first.wpilibj.AnalogGyro;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.Settings;


public class DriveForward extends Command {

    double driveSpeed;
    double driveDistance;
    double angle;
    double turnSpeed;
    double Kp = .2;  //turn intensity

    private WPI_TalonSRX leftSlave1Talon = Robot.m_drivetrain.getLeftTalon();
    private AnalogGyro gyro = new AnalogGyro(RobotMap.ROBOT_GYRO);
    

    public DriveForward(double inches, double drivespeed, double turnangle, double turnspeed)
    {
        requires(Robot.m_drivetrain);
        driveDistance = inches;
        driveSpeed = drivespeed;
        angle = turnangle;
        turnSpeed = turnspeed;
    }


    @Override 
    protected void initialize()
    {
        Robot.m_drivetrain.ResetEncoder();
        gyro.reset();
    }

    @Override 
    protected void execute()
    {
        driveDistance = driveDistance*(Settings.Encoder_RotationsPerInch);

        //double angle = gyro.getAngle();
        while(Math.abs(leftSlave1Talon.getSelectedSensorPosition()) > Math.abs(driveDistance)){ //negative is forward

            double moveSpeed = driveSpeed; //positive is forward
            angle = angle - gyro.getAngle();
            angle = angle*Kp;

            if (moveSpeed > 1){moveSpeed = 1;}
	        if (Math.abs(moveSpeed) < 0.10) {
			    moveSpeed = 0;
            }
            if (turnSpeed > 1){turnSpeed = 1;}
	        if (Math.abs(turnSpeed) < 0.10) {
			    turnSpeed = 0;
            }
            if (angle > turnSpeed){angle = turnSpeed;}
        
            Robot.m_drivetrain.arcadeDrive(moveSpeed, angle);
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