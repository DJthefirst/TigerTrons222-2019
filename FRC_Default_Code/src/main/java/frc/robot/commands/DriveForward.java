
package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;

public class DriveForward extends Command {

    public DriveForward()
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
        double moveSpeed = .7;
        

      //optional
	if (Math.abs(moveSpeed) < 0.10) {
			// within 10% joystick, make it zero 
			moveSpeed = 0;
		}
		//if (Math.abs(rotateSpeed) < 0.10) {
			// within 10% joystick, make it zero 
		//	rotateSpeed = 0;
		//}
		// print the joystick values to sign them, comment
		 // out this line after checking the joystick directions. 
	//	System.out.println("JoyY:" + moveSpeed + "  turn:" + rotateSpeed );
         

        Robot.m_drivetrain.arcadeDrive(moveSpeed, 0);
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