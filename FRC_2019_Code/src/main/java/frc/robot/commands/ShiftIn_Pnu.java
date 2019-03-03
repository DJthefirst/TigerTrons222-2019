package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;


public class ShiftIn_Pnu extends InstantCommand {

	public ShiftIn_Pnu() {
		super();
 
		requires(Robot.m_hatch);
	}

	@Override
	protected void initialize() {
		Robot.m_shift.pitchUp();
	}

	@Override 
    protected boolean isFinished()
    {
        return true;
    }

}