package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Spike extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Relay SpikeIntake = new Relay(RobotMap.SPIKE0,Direction.kBoth);

	public Spike() {
	}

	public void spikeUp() {
		
		SpikeIntake.set(Relay.Value.kReverse);
	}

	public void spikeDown() {
	
		SpikeIntake.set(Relay.Value.kForward);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}