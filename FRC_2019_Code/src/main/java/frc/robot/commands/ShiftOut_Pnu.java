package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

 
public class ShiftOut_Pnu extends InstantCommand {
 
	public ShiftOut_Pnu() {
		super();
 
		requires(Robot.m_hatch);
	}

	@Override
	protected void initialize() {
		Robot.m_shift.pitchDown();
	}

    @Override 
    protected boolean isFinished()
    {
        return true;
    }
}