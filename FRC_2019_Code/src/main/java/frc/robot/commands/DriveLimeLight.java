
package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class DriveLimeLight extends Command {
 
    double P = .3;
    double I = 0.3;//.25
    double D = 0.01;
    double integral, previous_error, setpoint = 0;
    double xx;
    double yy;

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
        xx = tx.getDouble(0.0);
        yy = ty.getDouble(0.0);

        SmartDashboard.putNumber("LimelightX", xx);
        SmartDashboard.putNumber("LimelightY", yy);

        double moveSpeed = ((Math.pow(78,(0.092*(yy/1.78+8))))+43)/40;
        double rotateSpeed = PID();

      //optional
	    if (Math.abs(moveSpeed) < 0.90) {moveSpeed = 0;}
		if (Math.abs(rotateSpeed) < 0.10) {rotateSpeed = 0;}
        if (rotateSpeed > 1)    {rotateSpeed = 1;}
        if (rotateSpeed < -1)   {rotateSpeed = -1;}
        if (moveSpeed > .7)     {moveSpeed = .7;}
        if (moveSpeed < -.7)    {moveSpeed = -.7;}


        Robot.m_drivetrain.arcadeDrive(0, rotateSpeed);
    }

    public double PID(){
        double error = 0 - xx/10; // Error = Target - Actual
        integral = integral + (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        double derivative = (error - previous_error);
        previous_error = error;
        double turnspeed = P*error + I*integral + D*derivative;
        return -turnspeed;
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