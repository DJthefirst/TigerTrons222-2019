package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class BallOut extends InstantCommand {
	/**
	 * Add your docs here.
	 */
	public BallOut() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.m_ballPiston);


	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		Robot.m_ballPiston.pitchUp();
	}
}