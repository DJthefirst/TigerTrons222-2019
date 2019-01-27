package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class Drivetrain extends Subsystem {
		
	//motors 
	WPI_TalonSRX leftMasterTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Master_TALON);
	WPI_TalonSRX rightMasterTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Master_TALON);
	
	
	WPI_TalonSRX leftSlave1Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Slave1_TALON);
	WPI_TalonSRX leftSlave2Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_Slave2_TALON);
	WPI_TalonSRX rightSlave1Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Slave1_TALON);
	WPI_TalonSRX rightSlave2Talon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_Slave2_TALON);

	public CANSparkMax Spark1 = new CANSparkMax(RobotMap.DRIVETRAIN_SPARK1,MotorType.kBrushless);
	public CANSparkMax Spark2 = new CANSparkMax(RobotMap.DRIVETRAIN_SPARK2,MotorType.kBrushless);



	DifferentialDrive differentialDrive = new DifferentialDrive(rightMasterTalon,leftMasterTalon); //needs fixing
	//DifferentialDrive differentialDrive = new DifferentialDrive(Spark1,Spark2);

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

public CANSparkMax getValueSpark1() {
	return Spark1;
}

}