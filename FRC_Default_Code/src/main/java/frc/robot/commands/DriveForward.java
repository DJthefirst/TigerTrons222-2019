
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveForward extends Command {

    private WPI_TalonSRX leftSlave1Talon = Robot.m_drivetrain.getLeftTalon();
    double moveSpeed;

    public DriveForward()
    {
        requires(Robot.m_drivetrain);
    }


    @Override 
    protected void initialize()
    {

    }

    @Override 
    protected void execute()
    {


    if(leftSlave1Talon.getSelectedSensorPosition()<5000)
    {
        moveSpeed = 0.7; 
    }
    else{
        moveSpeed = 0.0; 
    }
              
    Robot.m_drivetrain.arcadeDrive(moveSpeed, 0);
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