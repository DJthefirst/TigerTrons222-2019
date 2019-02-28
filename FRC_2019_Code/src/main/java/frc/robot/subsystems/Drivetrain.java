package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.AnalogGyro;

public class Drivetrain extends Subsystem {
		
	//motors 
	CANSparkMax leftMasterSparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_Master_SPARKMAX,MotorType.kBrushless);
	CANSparkMax rightMasterSparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_Master_SPARKMAX,MotorType.kBrushless);
	CANSparkMax leftSlave1SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_Slave1_SPARKMAX,MotorType.kBrushless);
	CANSparkMax leftSlave2SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_Slave2_SPARKMAX,MotorType.kBrushless);
	CANSparkMax rightSlave1SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_Slave1_SPARKMAX,MotorType.kBrushless);
	CANSparkMax rightSlave2SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_Slave2_SPARKMAX,MotorType.kBrushless);
	CANEncoder driveEncoder;

	DifferentialDrive differentialDrive = new DifferentialDrive(rightMasterSparkMax,leftMasterSparkMax); 
	private AnalogGyro gyro = new AnalogGyro(RobotMap.ROBOT_GYRO);
public Drivetrain()
{
	leftSlave1SparkMax.follow(leftMasterSparkMax);
	leftSlave2SparkMax.follow(leftMasterSparkMax);
	rightSlave1SparkMax.follow(rightMasterSparkMax);
	rightSlave2SparkMax.follow(rightMasterSparkMax);
	driveEncoder = leftSlave1SparkMax.getEncoder();
}


public void arcadeDrive (double moveSpeed, double rotateSpeed)
{
	differentialDrive.arcadeDrive(moveSpeed,-rotateSpeed);
}


public void ResetEncoder ()
{
	driveEncoder.setPosition(0);
}


public void initDefaultCommand() 
{
	setDefaultCommand(new DriveArcade()); 
}

public CANEncoder getDriveEncoder() {
	return driveEncoder;

}


public AnalogGyro getDriveGyro() {
	
	return gyro;
}



}