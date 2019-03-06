package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Skidcmd_Pnu extends InstantCommand {

	NetworkTableEntry skidState;

	public Skidcmd_Pnu() {
		super();
 
		requires(Robot.m_skid);
	}


	@Override
	protected void initialize(){
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		NetworkTable table = inst.getTable("datatable");
		double skidState = table.getEntry("skidState").getDouble(0.00);

		if(skidState == 1)
		{
			Robot.m_skid.pitchUp();
			NetworkTableInstance.getDefault().getTable("datatable").getEntry("skidState").setNumber(0);
		}

		if(skidState == 0)
		{
			Robot.m_shift.pitchDown();
			NetworkTableInstance.getDefault().getTable("datatable").getEntry("skidState").setNumber(1);
		}	
		System.out.println("Skid state: " + skidState);
	}
}