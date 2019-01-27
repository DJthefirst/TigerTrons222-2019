package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shift extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	DoubleSolenoid pitchSolenoid = null;

	public Shift() {
		pitchSolenoid = new DoubleSolenoid(RobotMap.SHIFT_SOLENOID_DEPLOY, RobotMap.SHIFT_SOLENOID_RETRACT);
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