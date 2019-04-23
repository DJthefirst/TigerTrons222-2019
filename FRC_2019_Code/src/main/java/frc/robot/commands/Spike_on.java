package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

 
public class Spike_on extends InstantCommand {
 
	public Spike_on() {
		super();
 
		requires(Robot.m_spike);
	}

	@Override
	protected void initialize() {
		Robot.m_spike.spikeUp();
	}

    @Override 
    protected boolean isFinished()
    {
        return true;
    }
}