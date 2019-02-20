package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class BallPiston extends Subsystem {
	
	DoubleSolenoid pitchSolenoid = null;

	public BallPiston() {
		pitchSolenoid = new DoubleSolenoid(RobotMap.BALLPISTON_SOLENOID_DEPLOY, RobotMap.BALLPISTON_SOLENOID_RETRACT);
	}

	public void pitchUp() {
		pitchSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void pitchDown() {
		pitchSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	@Override
	public void initDefaultCommand() {
	
	}
}