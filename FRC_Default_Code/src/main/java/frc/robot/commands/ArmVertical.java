package frc.robot.commands;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmVertical extends Command {

    private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();
    private static int loop = 0;

    public ArmVertical()
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
        double armPosition = -Robot.m_oi.joystick.getRawAxis(RobotMap.DRIVER_CONTROLLER_ARM_AXIS);
        Robot.m_arm.armDrive(armPosition);
        
        if (++loop >= 40) {
			loop = 0;
       // System.out.println("Sensor Vel:" + armMotorMaster.getSelectedSensorVelocity());
       // System.out.println("Sensor Pos:" + armMotorMaster.getSelectedSensorPosition());
       // System.out.println("Out %" + armMotorMaster.getMotorOutputPercent());
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