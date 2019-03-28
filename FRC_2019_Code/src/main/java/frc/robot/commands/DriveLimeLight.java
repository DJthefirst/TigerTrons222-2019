
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class DriveLimeLight extends Command {

    public DriveLimeLight()
    {
        requires(Robot.m_drivetrain);
    }
    @Override 
    protected void initialize()
    {
    }
    @Override 
    protected void execute()
    {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        //read values periodically
        double xx = tx.getDouble(0.0);
        double yy = ty.getDouble(0.0);
        double Are = ta.getDouble(0.0);

        SmartDashboard.putNumber("LimelightX", xx);
        SmartDashboard.putNumber("LimelightY", yy);
        SmartDashboard.putNumber("LimelightArea", Are);

        System.out.println("x;"+ xx +" y;"+ yy +" area;"+ Are);

        xx = xx/20;
        Are = 5/Are;


        double moveSpeed = Are;
        double rotateSpeed = xx;

      //optional
	if (Math.abs(moveSpeed) < 0.90) {
			// within 10% joystick, make it zero 
			moveSpeed = 0;
		}
		if (Math.abs(rotateSpeed) < 0.10) {
			// within 10% joystick, make it zero 
			rotateSpeed = 0;
        }
        
        if (rotateSpeed > 1) {
			// within 100% joystick, make it zero 
			rotateSpeed = 1;
        }
        
        if (rotateSpeed < -1) {
			// within 100% joystick, make it zero 
			rotateSpeed = -1;
        }
        
        if (moveSpeed > .7) {
			// within 100% joystick, make it zero 
			moveSpeed = .7;
        }
        
        if (moveSpeed < -.7) {
			moveSpeed = -.7;
		}


        Robot.m_drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
    }

    @Override 
    protected boolean isFinished()
    {
        return false;
    }
    @Override 
    protected void end(){       
        Robot.m_drivetrain.arcadeDrive(0,0);
    }
    @Override 
    protected void interrupted()
    {
        end();
    }
}