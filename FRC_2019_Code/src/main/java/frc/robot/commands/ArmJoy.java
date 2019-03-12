package frc.robot.commands;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmJoy extends Command {

    private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();
    private static int loop = 0;

    public ArmJoy()
    {
        requires(Robot.m_arm);
    }


    @Override 
    protected void initialize()
    {

    }


    @Override 
    protected void execute()
    {
        double armPosition = Robot.m_oi.Controller2.getRawAxis(RobotMap.DRIVER_CONTROLLER2_ARM_AXIS)*.5;
        if (Math.abs(armPosition) < 0.10) { armPosition = 0;}
        Robot.m_arm.armDrive(armPosition);
        
        if (++loop >= 40) {
			loop = 0;

        }
       
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
    protected void end(){       
        Robot.m_arm.armDrive(0);
    }

    
    @Override 
    protected void interrupted()
    {
        end();
    }
}