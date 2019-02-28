package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

 
public class HatchIn_Pnu extends InstantCommand {
 
	public HatchIn_Pnu() {
		super();
 
		requires(Robot.m_hatch);
	}

	@Override
	protected void initialize() {
		Robot.m_hatch.pitchDown();
	}

    @Override 
    protected boolean isFinished()
    {
        return true;
    }
}