package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.Settings;

public class Arm_Auto extends Command {

    double targetPos;
    int armState;
    int arm_state;
    private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();
    
    public Arm_Auto(int ArmState)
    {
        requires(Robot.m_arm);
        armState = ArmState;
    }

    @Override 
    protected void initialize()
    {
        System.out.println("---Running Arm Auto COMMAND---");
    }

    @Override 
    protected void execute()
    {

        if (Robot.m_oi.Controller2.getRawAxis(RobotMap.DRIVER_CONTROLLER2_ARM_SHIFT) > .2){
            arm_state = armState + 1;   
        }
        else{
            arm_state = armState;
        }

        switch (arm_state)
        {
        case 0:
            targetPos = (Settings.Ball_Top_Pos);
            break;
        case 1:
            targetPos = (Settings.Hatch_Top_Pos);
            break;
        case 2:
            targetPos = (Settings.Ball_Mid_Pos);
            break;
        case 3:
            targetPos = (Settings.Hatch_Mid_Pos);
            break;
        case 4:
            targetPos = (Settings.Ball_Hab_Pos);
            break;
        case 5:
            targetPos = (Settings.Hatch_Hab_Pos);
            break;
        case 6:
            targetPos = (Settings.Ball_Bot_Pos);
            break;
        case 7:
            targetPos = (Settings.Hatch_Bot_Pos);
            break;
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