package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;


public class SkidOut_Pnu extends InstantCommand {
 
	public SkidOut_Pnu() {
		super();

		requires(Robot.m_skid);
	}

	@Override
	protected void initialize() {
		Robot.m_skid.pitchUp();
	}
}