
package frc.robot.commands;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;

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
        double moveSpeed = -Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
        double rotateSpeed = Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);

        //System.out.println("Sensor Vel:" + leftSlave1Talon.getSelectedSensorVelocity());
        //System.out.println("Sensor Pos:" + leftSlave1Talon.getSelectedSensorPosition());
        //System.out.println("Out %" + leftSlave1Talon.getMotorOutputPercent());


	if (Math.abs(moveSpeed) < 0.10) {
			// within 10% joystick, make it zero 
			moveSpeed = 0;
		}
		if (Math.abs(rotateSpeed) < 0.15) {
			// within 10% joystick, make it zero 
			rotateSpeed = 0;
		}

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
    protected void interrupted()
    {
        end();
    }
}