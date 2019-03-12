package frc.robot.commands;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;


public class BallIn_Pnu extends InstantCommand {

	public BallIn_Pnu() {
		super();

		requires(Robot.m_ballPiston);
	}

	@Override
	protected void initialize() {
		Robot.m_ballPiston.pitchDown();
	}
}