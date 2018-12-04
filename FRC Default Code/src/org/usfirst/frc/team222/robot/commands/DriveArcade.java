import org.usfirst.frc.team222.robot.RobotMap;

public class DriveArcade extends Command {

    public DriveArcade()
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
        double moveSpeed = -Robot.m_oi.driveController.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
        double moveSpeed = Robot.m_oi.driveController.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
    }

    @Override 
    protected boolean isFinished()
    {
        return false;
    }



    @Override 
    protected void end(){       
    }

    @Override 
    protected void interrupt()
    {
        
    }
}