package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends Subsystem {
		
	//motors 
	CANSparkMax leftMasterSparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_Master_SPARKMAX,MotorType.kBrushless);
	CANSparkMax rightMasterSparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_Master_SPARKMAX,MotorType.kBrushless);
	
	
	CANSparkMax leftSlave1SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_Slave1_SPARKMAX,MotorType.kBrushless);
	CANSparkMax leftSlave2SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT_Slave2_SPARKMAX,MotorType.kBrushless);
	CANSparkMax rightSlave1SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_Slave1_SPARKMAX,MotorType.kBrushless);
	CANSparkMax rightSlave2SparkMax = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT_Slave2_SPARKMAX,MotorType.kBrushless);
	CANEncoder driveEncoder;
	//CANSparkMax Spark1 = new CANSparkMax(RobotMap.DRIVETRAIN_SPARK1,MotorType.kBrushless);
	//CANSparkMax Spark2 = new CANSparkMax(RobotMap.DRIVETRAIN_SPARK2,MotorType.kBrushless);



	DifferentialDrive differentialDrive = new DifferentialDrive(rightMasterSparkMax,leftMasterSparkMax); //needs fixing
	//DifferentialDrive differentialDrive = new DifferentialDrive(Spark1,Spark2);

	
public Drivetrain()
{
	leftSlave1SparkMax.follow(leftMasterSparkMax);
	leftSlave2SparkMax.follow(leftMasterSparkMax);
	rightSlave1SparkMax.follow(rightMasterSparkMax);
	rightSlave2SparkMax.follow(rightMasterSparkMax);
	driveEncoder = leftMasterSparkMax.getEncoder();
}

public  void arcadeDrive (double moveSpeed, double rotateSpeed)
{
	differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
}

public void ResetEncoder ()
{
	//leftSlave1Talon.setSelectedSensorPosition(0, 0, 0);
}


public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	setDefaultCommand(new DriveArcade()); 
}

public CANEncoder getLeftEncoder() {
	return driveEncoder;
}



}