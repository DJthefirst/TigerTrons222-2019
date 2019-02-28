package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;


public class HatchOut_Pnu extends InstantCommand {

	public HatchOut_Pnu() {
		super();
 
		requires(Robot.m_hatch);
	}

	@Override
	protected void initialize() {
		Robot.m_hatch.pitchUp();
	}

	@Override 
    protected boolean isFinished()
    {
        return true;
    }

}