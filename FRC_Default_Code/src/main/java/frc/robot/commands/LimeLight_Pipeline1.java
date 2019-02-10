package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class LimeLight_Pipeline1 extends InstantCommand {
      
    public LimeLight_Pipeline1() {
        super();
      
        requires(Robot.m_limelight);
    }
    
    @Override
    protected void initialize() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
    }
}