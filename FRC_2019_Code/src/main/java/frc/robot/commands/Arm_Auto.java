package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Settings;

public class Arm_Auto extends Command {

    double armPosition;
    private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();
    
    public Arm_Auto(double arminches)
    {
        requires(Robot.m_arm);
        armPosition = arminches;
    }


    @Override 
    protected void initialize()
    {
        System.out.println("---Running Arm Auto COMMAND---");
    }

    @Override 
    protected void execute()
    {
        double leftYstick = Robot.m_oi.Controller2.getRawAxis(RobotMap.DRIVER_CONTROLLER2_ARM_AXIS)*.5;
		if (Math.abs(leftYstick) < 0.10) { leftYstick = 0;}

        double targetPos = armPosition;
        
        if (Robot.m_oi.Controller2.getRawAxis(RobotMap.DRIVER_CONTROLLER2_ARM_SHIFT) > .2){
            targetPos = targetPos - (Settings.HatchToBall);
        }
        armMotorMaster.set(ControlMode.MotionMagic, targetPos);


        SmartDashboard.putNumber("Sensor Vel", armMotorMaster.getSelectedSensorVelocity());
        SmartDashboard.putNumber("Sensor Pos:", armMotorMaster.getSelectedSensorPosition());
        SmartDashboard.putNumber("Out %", armMotorMaster.getMotorOutputPercent());       
    }
    

    @Override 
    protected boolean isFinished()
    {
        return false;
    }


    @Override 
    protected void end()
    {       
        Robot.m_arm.armDrive(0);
    }

    
    @Override 
    protected void interrupted()
    {
        end();
    }
}