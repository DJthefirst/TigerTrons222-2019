package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Skid extends Subsystem {

	DoubleSolenoid pitchSolenoid = null;

	public Skid() {
		pitchSolenoid = new DoubleSolenoid(RobotMap.SKID_SOLENOID_DEPLOY, RobotMap.SKID_SOLENOID_RETRACT);
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

	}
}