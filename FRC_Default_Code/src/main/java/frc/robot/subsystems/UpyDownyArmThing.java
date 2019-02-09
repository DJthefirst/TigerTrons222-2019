package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotMap;
import frc.robot.commands.ArmVertical;


public class UpyDownyArmThing extends Subsystem {
		
	//motors 
	WPI_TalonSRX armMotorMaster = new WPI_TalonSRX(RobotMap.ARM_MOTOR_Master_TALON);
	WPI_TalonSRX armMotorSlave = new WPI_TalonSRX(RobotMap.ARM_MOTOR_Slave_TALON);

public UpyDownyArmThing()
{
	armMotorSlave.follow(armMotorMaster);

}

public  void armDrive (double armSpeed)
{
	//armMotorMaster = armSpeed;
	armMotorMaster.set(ControlMode.PercentOutput, armSpeed);
}

public void ResetArmEncoder ()
{
armMotorMaster.setSelectedSensorPosition(0, 0, 0);
}


public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	setDefaultCommand(new ArmVertical()); 
}

public WPI_TalonSRX getArmTalon() {
	return armMotorMaster;
}



}