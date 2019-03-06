package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;


public class SkidOut extends InstantCommand {
 
	public SkidOut() {
		super();

		requires(Robot.m_skid);
	}

	@Override
	protected void initialize() {
		Robot.m_skid.pitchUp();
	}
}