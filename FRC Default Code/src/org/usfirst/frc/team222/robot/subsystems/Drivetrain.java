package org.usfirst.frc.team222.robot;
public class Drivetrain extends Subsystem {
		
DifferentialDrive differentialDrive = null ;

public Drivetrain()
{
	Talon leftFrontTalon = Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	Talon rightFrontTalon = Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	Talon leftBackTalon = Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	Talon rightBackTalon = Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);

	SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontTalon,leftBackTalon);
	SpeedControllerGroup rightMotors = new SpeedControllerGoup(rightFrontTalon,rightBackTalon);
	differentialDrive = DifferentialDrive(leftMotors,rightMotors);
}


public  void arcadeDrive (double moveSpeed, double rotateSpeed)
{
	differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
}











}