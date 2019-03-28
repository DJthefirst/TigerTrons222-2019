package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climbcmd extends Command {

    private WPI_TalonSRX climbMotorMaster = Robot.m_climb.getClimbTalon();


    double climbSpeed;

    public Climbcmd(double ClimbSpeed)
    {
        requires(Robot.m_climb);
        climbSpeed = ClimbSpeed;
    }


    @Override 
    protected void initialize()
    {

    }


    @Override 
    protected void execute()
    {

        Robot.m_climb.climbDrive(climbSpeed);
       
        SmartDashboard.putNumber("Climb Sensor Vel", climbMotorMaster.getSelectedSensorVelocity());
        SmartDashboard.putNumber("Climb Sensor Pos:", climbMotorMaster.getSelectedSensorPosition());
        SmartDashboard.putNumber("Climb Out %", climbMotorMaster.getMotorOutputPercent());
    }

    @Override 
    protected boolean isFinished()
    {
        return false;
    }


    @Override 
    protected void end(){       
        Robot.m_climb.climbDrive(0);
    }

    
    @Override 
    protected void interrupted()
    {
        end();
    }
}