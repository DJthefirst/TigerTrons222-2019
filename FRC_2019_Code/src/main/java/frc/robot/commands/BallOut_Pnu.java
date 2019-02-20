package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;


public class BallOut_Pnu extends InstantCommand {

	public BallOut_Pnu() {
		super();

		requires(Robot.m_ballPiston);


	}

	@Override
	protected void initialize() {
		System.out.println("---Pitch Up---");
		Robot.m_ballPiston.pitchUp();
	}
}