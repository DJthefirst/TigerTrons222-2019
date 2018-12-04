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
        double rotateSpeed = Robot.m_oi.driveController.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
        Robot.m_drivetrain.arcadeDrive(moveSpeed,rotateSpeed);
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
    protected void interrupt()
    {
        endl();
    }
}