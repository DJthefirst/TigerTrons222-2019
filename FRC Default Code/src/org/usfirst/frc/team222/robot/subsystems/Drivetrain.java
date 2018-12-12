package org.usfirst.frc.team222.robot;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.WPI_TalonSRX;  //unshure


public class Drivetrain extends Subsystem {
		
DifferentialDrive differentialDrive = null ;

public Drivetrain()
{
	WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX leftBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX rightBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);

	SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontTalon,leftBackTalon);
	SpeedControllerGroup rightMotors = new SpeedControllerGoup(rightFrontTalon,rightBackTalon);
	differentialDrive = DifferentialDrive(leftMotors,rightMotors);
}


public  void arcadeDrive (double moveSpeed, double rotateSpeed)
{
	differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
}

public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	setDefaultCommand(new DriveArcade());
}



}