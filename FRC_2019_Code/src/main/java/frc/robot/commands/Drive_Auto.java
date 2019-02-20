package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import edu.wpi.first.wpilibj.AnalogGyro;
import com.revrobotics.CANEncoder;
import frc.robot.RobotMap;
import frc.robot.Settings;
import frc.robot.Constants;

public class Drive_Auto extends Command {

    double driveSpeed;
    double driveDistance;
    double angle;
    double turnSpeed;
    double Kp = Constants.Turn_kGain;  //turn intensity
    double moveSpeed = 0;
    double loop = 0;
    double turnAngle = 0;
    private CANEncoder driveEncoder = Robot.m_drivetrain.getLeftEncoder();
    private AnalogGyro gyro = new AnalogGyro(RobotMap.ROBOT_GYRO);
    

    public Drive_Auto(double inches, double drivespeed, double turnangle, double turnspeed)
    {
        requires(Robot.m_drivetrain);
        driveDistance = inches*(Settings.Encoder_RotationsPerInch);
        driveSpeed = drivespeed;
        angle = turnangle;
        turnSpeed = turnspeed;
    }


    @Override 
    protected void initialize()
    {
        Robot.m_drivetrain.ResetEncoder();
        gyro.reset();
        System.out.println("---Running Drive Auto COMMAND---");
    }

    @Override 
    protected void execute()
    {
        //turnAngle = 0;
        //moveSpeed = 0;
		
        moveSpeed = driveSpeed; 

        //turning
        turnAngle = -angle + gyro.getAngle();
        turnAngle = turnAngle*Kp;

        //set limits
        if (moveSpeed > 1){moveSpeed = 1;}
	    if (Math.abs(moveSpeed) < 0.10) {moveSpeed = 0;}
        if (turnAngle > turnSpeed){turnAngle = turnSpeed;}
        if (turnAngle < -turnSpeed){turnAngle = -turnSpeed;}

        //stop once goal is reached
        if(Math.abs(driveEncoder.getPosition()) > Math.abs(driveDistance)){ 
            moveSpeed = 0;
        }

        //dispalay values
        if (++loop >= 10) {
            loop = 0;
            System.out.println("turnAngle: " + turnAngle +" |Gyro: "+ gyro.getAngle());
            System.out.println(driveEncoder.getPosition());
        }

        Robot.m_drivetrain.arcadeDrive(moveSpeed, turnAngle);
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