package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.BallIntakecmd;;

public class BallIntake extends Subsystem {
		
	//motors 
	WPI_TalonSRX armMotorIntakeMaster = new WPI_TalonSRX(RobotMap.Intake_MOTOR_TALON);

public BallIntake()
{
	
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

}

