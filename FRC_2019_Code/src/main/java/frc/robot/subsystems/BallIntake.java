package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Settings;

import frc.robot.RobotMap;
import frc.robot.commands.BallIntakecmd;

public class BallIntake extends Subsystem {
		
	//motors 
	int timeoutMs = 300;
	WPI_TalonSRX armMotorIntakeMaster = new WPI_TalonSRX(RobotMap.Intake_MOTOR_TALON);
	//armMotorIntakeMaster.configContinuousCurrentLimit(5, 100);
	//armMotorIntakeMaster.configPeakCurrentLimit(35, 10); /* 35 A */
	//armMotorIntakeMaster.configPeakCurrentDuration(200, 10); /* 200ms */
	//armMotorIntakeMaster.configContinuousCurrentLimit(30, 10); /* 30

	public BallIntake(){
		armMotorIntakeMaster.configContinuousCurrentLimit(Settings.IntakeCon_Amp, timeoutMs);
		armMotorIntakeMaster.configPeakCurrentLimit(Settings.IntakeMax_Amp, timeoutMs);
		armMotorIntakeMaster.enableCurrentLimit(true); 
		
	}

	public  void BallDrive (double armIntakeSpeed)
	{ 
		//armMotorMaster = armSpeed;
		armMotorIntakeMaster.set(armIntakeSpeed);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new BallIntakecmd()); 
	}

	public void CurrntLimitFalse(){
		armMotorIntakeMaster.enableCurrentLimit(false); 	
	}

	public void CurrntLimitTrue(){
		armMotorIntakeMaster.enableCurrentLimit(true); 	
	}


}

