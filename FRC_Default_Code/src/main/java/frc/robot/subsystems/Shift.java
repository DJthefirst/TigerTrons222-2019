package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Shift extends Subsystem {

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