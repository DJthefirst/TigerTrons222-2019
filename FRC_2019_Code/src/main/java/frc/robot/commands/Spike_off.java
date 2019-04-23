package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

 
public class Spike_off extends InstantCommand {
 
	public Spike_off() {
		super();
 
		requires(Robot.m_spike);
	}

	@Override
	protected void initialize() {
		Robot.m_spike.spikeDown();
	}

    @Override 
    protected boolean isFinished()
    {
        return true;
    }
}