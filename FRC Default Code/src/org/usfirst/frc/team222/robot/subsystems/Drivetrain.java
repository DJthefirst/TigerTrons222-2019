package org.usfirst.frc.team222.robot;
public class Drivetrain extends Subsystem {
		
DifferentialDrive differentialDrive = null ;

public Drivetrain()
{
	WPI_TalonSRX leftFrontTalon = WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX rightFrontTalon = WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX leftBackTalon = WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX rightBackTalon = WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);

	SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontTalon,leftBackTalon);
	SpeedControllerGroup rightMotors = new SpeedControllerGoup(rightFrontTalon,rightBackTalon);
	differentialDrive = DifferentialDrive(leftMotors,rightMotors);
}


public  void arcadeDrive (double moveSpeed, double rotateSpeed)
{
	differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
}











}