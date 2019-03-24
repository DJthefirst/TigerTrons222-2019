package frc.robot.commands;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;

public class BallIntakecmd extends Command {

    double ballSpeed;

    public BallIntakecmd()
    {
        requires(Robot.m_BallIntake);
    }


    @Override 
    protected void initialize()
    {

    }


    @Override 
    protected void execute()
    {
        
            
        ballSpeed = Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_In)-Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_Out);
        //System.out.println("Intake: " + (Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_Out)));
       
        if(Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_In)-Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_Out) < 0 ){
            Robot.m_BallIntake.CurrntLimitFalse(); 

            ballSpeed = -0.75;
        }
        else{
            Robot.m_BallIntake.CurrntLimitTrue();  
        }
        //lower while intakeing
        Robot.m_BallIntake.BallDrive(ballSpeed);
    }

    
    @Override 
    protected boolean isFinished()
    {
        return false;
    }


    @Override 
    protected void end(){       
        Robot.m_BallIntake.BallDrive(0);
    }


    @Override 
    protected void interrupted()
    {
        end();
    }
}