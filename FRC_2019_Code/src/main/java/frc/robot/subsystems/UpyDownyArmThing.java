package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.ArmJoy;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;


public class UpyDownyArmThing extends Subsystem {
		
	//motors 
	WPI_TalonSRX armMotorMaster = new WPI_TalonSRX(RobotMap.ARM_MOTOR_Master_TALON);
	WPI_TalonSRX armMotorSlave = new WPI_TalonSRX(RobotMap.ARM_MOTOR_Slave_TALON);

	public UpyDownyArmThing()
	{
		armMotorSlave.follow(armMotorMaster);

		/* Configure Sensor Source for Pirmary PID */
		armMotorMaster.configSelectedFeedbackSensor(FeedbackDevice.Analog, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
	
		/* Set relevant frame periods to be at least as fast as periodic rate */
		armMotorMaster.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		armMotorMaster.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		/* Set the peak and nominal outputs */
		armMotorMaster.configNominalOutputForward(0, Constants.kTimeoutMs);
		armMotorMaster.configNominalOutputReverse(0, Constants.kTimeoutMs);
		armMotorMaster.configPeakOutputForward(1, Constants.kTimeoutMs);
		armMotorMaster.configPeakOutputReverse(-1, Constants.kTimeoutMs);
	
		/* Set Motion Magic gains in slot0 - see documentation */
		armMotorMaster.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		armMotorMaster.config_kF(Constants.kSlotIdx, Constants.ARM_kGains.kF, Constants.kTimeoutMs);
		armMotorMaster.config_kP(Constants.kSlotIdx, Constants.ARM_kGains.kP, Constants.kTimeoutMs);
		armMotorMaster.config_kI(Constants.kSlotIdx, Constants.ARM_kGains.kI, Constants.kTimeoutMs);
		armMotorMaster.config_kD(Constants.kSlotIdx, Constants.ARM_kGains.kD, Constants.kTimeoutMs);
	
		/* Set acceleration and vcruise velocity - see documentation */
		armMotorMaster.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
		armMotorMaster.configMotionAcceleration(6000, Constants.kTimeoutMs);
		
		/* Zero the sensor */
		//armMotorMaster.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
	}



	public  void armDrive (double armSpeed){
		//Set Tallon speed
		armMotorMaster.set(ControlMode.PercentOutput, armSpeed);
	}


	public void ResetArmEncoder (){
		//reset encoder (not in use)
		armMotorMaster.setSelectedSensorPosition(0, 0, 0);
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ArmJoy()); 
	}


	public WPI_TalonSRX getArmTalon() {
		return armMotorMaster;
	}

}