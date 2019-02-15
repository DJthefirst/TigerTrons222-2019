package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class LimeLight_Pipeline extends InstantCommand {
    double val;
    public LimeLight_Pipeline() {
        super();
        
        requires(Robot.m_limelight);
    }
    
    @Override
    protected void initialize() {
        val = NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").getDouble(0);
        System.out.println(NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").getDouble(0));
        if(val == 1){NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);}
        else{NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);}
        System.out.println(NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").getDouble(0));
    }
}
