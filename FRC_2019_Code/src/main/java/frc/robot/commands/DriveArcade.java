
package frc.robot.commands;
import frc.robot.RobotMap;

import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class DriveArcade extends Command {

    private CANEncoder driveEncoderLeft = Robot.m_drivetrain.getDriveEncoderLeft();
    private CANEncoder driveEncoderRight = Robot.m_drivetrain.getDriveEncoderRight();

    public DriveArcade()
    {
        requires(Robot.m_drivetrain);
    }


    @Override 
    protected void initialize()
    {
        Robot.m_drivetrain.ResetEncoder();
    }

    @Override 
    protected void execute()
    {
        double moveSpeed = -Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
        double rotateSpeed = Robot.m_oi.Controller.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);

        SmartDashboard.putNumber("Left Encoder", driveEncoderLeft.getPosition());
        SmartDashboard.putNumber("RIght Encoder",driveEncoderRight.getPosition());

        //System.out.println("Sensor Vel:" + leftSlave1Talon.getSelectedSensorVelocity());
        //System.out.println("Sensor Pos:" + leftSlave1Talon.getSelectedSensorPosition());
        //System.out.println("Out %" + leftSlave1Talon.getMotorOutputPercent());
       // System.out.println(moveSpeed);

	    if (Math.abs(moveSpeed) < 0.10) {
			// within 10% joystick, make it zero 
		moveSpeed = 0;
		}
		if (Math.abs(rotateSpeed) < 0.13) {
			// within 10% joystick, make it zero 
			rotateSpeed = 0;
		}

        Robot.m_drivetrain.arcadeDrive(moveSpeed,rotateSpeed);
        //System.out.println(moveSpeed);
        //System.out.println("rotate" + rotateSpeed);
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