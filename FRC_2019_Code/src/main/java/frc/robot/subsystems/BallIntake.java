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


	public BallIntake(){
		armMotorIntakeMaster.configContinuousCurrentLimit(Settings.IntakeCon_Amp, timeoutMs);
		armMotorIntakeMaster.configPeakCurrentLimit(Settings.IntakeMax_Amp, timeoutMs);
		armMotorIntakeMaster.configPeakCurrentDuration(Settings.IntakeTime_Amp);
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

