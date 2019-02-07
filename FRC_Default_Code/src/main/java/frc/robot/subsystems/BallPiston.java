package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BallPiston extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
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
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}