package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClimbJoy extends Command {

    private WPI_TalonSRX climbMotorMaster = Robot.m_climb.getClimbTalon();


    double climbSpeed;

    public ClimbJoy()
    {
        requires(Robot.m_climb);
    }

    @Override 
    protected void initialize()
    {

    }

@Override 
protected void execute()
{
    double climbPosition = Robot.m_oi.Controller2.getRawAxis(RobotMap.DRIVER_CONTROLLER2_CLIMB_AXIS)*.5;
    if (Math.abs(climbPosition) < 0.10) { climbPosition = 0;}
    Robot.m_climb.climbDrive(climbPosition);
   
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