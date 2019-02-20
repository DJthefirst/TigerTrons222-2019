
package frc.robot.commands;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;

public class BallIntakecmd extends Command {


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
        Robot.m_BallIntake.BallDrive(Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_Out)-Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_In));
        //System.out.println("Intake: " + (Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_INTAKE_Out)));

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