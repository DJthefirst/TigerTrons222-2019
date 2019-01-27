package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
/**
 *
 */
public class LimeLight_GetData extends Command {

    public LimeLight_GetData() {
    //    requires(Robot.LimeLight);
    
        setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
     
    }


    @Override 
    protected void execute()
    {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        //read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0); 
        System.out.println("x;"+ tx +" y;"+ ty +" area;"+ area);


        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
    }

    @Override 
    protected boolean isFinished()
    {
        return false;
    }

    @Override 
    protected void end(){       
    }

    @Override 
    protected void interrupted()
    {
        end();
    }

    
}