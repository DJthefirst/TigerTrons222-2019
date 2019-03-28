package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.ArmJoy;
import frc.robot.commands.ClimbJoy;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;


public class Climb extends Subsystem {
		
	//motors 
	WPI_TalonSRX climbMotorMaster = new WPI_TalonSRX(RobotMap.Climb_MOTOR_Master_TALON);
	WPI_TalonSRX climbMotorSlave = new WPI_TalonSRX(RobotMap.Climb_MOTOR_Slave_TALON);

	public Climb()
	{
		climbMotorSlave.follow(climbMotorMaster);
	}

	public  void climbDrive (double climbSpeed){
		//Set Tallon speed
		climbMotorMaster.set(ControlMode.PercentOutput, climbSpeed);
	}





	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ClimbJoy()); 
	}


	public WPI_TalonSRX getClimbTalon() {
		return climbMotorMaster;
	}

}