package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.LimeLight_GetData;

public class Limelight extends Subsystem {
		

    public Limelight()
    {

    }

    public void initDefaultCommand() {
    setDefaultCommand(new LimeLight_GetData());    
    }
}