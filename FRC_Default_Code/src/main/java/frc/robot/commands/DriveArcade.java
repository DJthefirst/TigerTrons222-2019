
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
        double moveSpeed = -Robot.m_oi.joystick.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
        double rotateSpeed = Robot.m_oi.joystick.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);

    /*  intigrate this
	if (Math.abs(forward) < 0.10) {
			/* within 10% joystick, make it zero 
			forward = 0;
		}
		if (Math.abs(turn) < 0.10) {
			/* within 10% joystick, make it zero 
			turn = 0;
		}
		/* print the joystick values to sign them, comment
		 * out this line after checking the joystick directions. 
		System.out.println("JoyY:" + forward + "  turn:" + turn );
		/* drive the robot, when driving forward one side will be red.  
		 * This is because DifferentialDrive assumes 
		 * one side must be negative 
		_drive.arcadeDrive(forward, turn);
    */





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