package frc.robot.subsystems;

//import frc.robot.commands.DriveArcade;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;



public class Drivetrain extends Subsystem {
		
	//motors 
	WPI_TalonSRX leftMasterTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Master_TALON);
	WPI_TalonSRX rightMasterTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Master_TALON);
	
	
	WPI_TalonSRX leftSlave1Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Slave1_TALON);
	WPI_TalonSRX leftSlave2Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Slave2_TALON);
	WPI_TalonSRX rightSlave1Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Slave1_TALON);
	WPI_TalonSRX rightSlave2Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Slave2_TALON);

	//Spark Spark1 = new Spark(RobotMap.DRIVETRAIN_SPARK);

	DifferentialDrive differentialDrive = new DifferentialDrive(rightMasterTalon,leftMasterTalon); //needs fixing
  

public Drivetrain()
{
	leftSlave1Talon.follow(leftMasterTalon);
	leftSlave2Talon.follow(leftMasterTalon);
	rightSlave1Talon.follow(rightMasterTalon);
	rightSlave2Talon.follow(rightMasterTalon);
}



public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	setDefaultCommand(new DriveArcade()); 
}


public  void arcadeDrive (double moveSpeed, double rotateSpeed)
{
	differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
}


}