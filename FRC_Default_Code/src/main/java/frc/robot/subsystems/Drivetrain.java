package frc.robot.subsystems;

//import frc.robot.commands.DriveArcade;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;



public class Drivetrain extends Subsystem {
		
	//motors 
	WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX leftBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
	WPI_TalonSRX rightBackTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);


	SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontTalon,leftBackTalon);
	SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);

	DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors,rightMotors); //needs fixing
  

public Drivetrain()
{

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