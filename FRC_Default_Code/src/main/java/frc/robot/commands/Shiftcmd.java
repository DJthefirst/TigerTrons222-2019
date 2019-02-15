package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Shiftcmd extends InstantCommand {

	NetworkTableEntry shiftState;

	public Shiftcmd() {
		super();
 
		requires(Robot.m_shift);
	}

	// Called once when the command executes
	@Override
	protected void initialize(){
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		NetworkTable table = inst.getTable("datatable");
		double shiftState = table.getEntry("ShiftState").getDouble(0.00);

		if(shiftState == 1)
		{
			Robot.m_shift.pitchUp();
			NetworkTableInstance.getDefault().getTable("datatable").getEntry("ShiftState").setNumber(0);
		}

		if(shiftState == 0)
		{
			Robot.m_shift.pitchDown();
			NetworkTableInstance.getDefault().getTable("datatable").getEntry("ShiftState").setNumber(1);
		}	
		System.out.println("state: " + shiftState);
	}
}