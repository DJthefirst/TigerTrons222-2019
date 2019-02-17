package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
/*This command drives drives forward until an encoder value is met.
Created by Eric
*/

public class ArmUp extends Command {

    double armSpeed;
    double armPosition;
    private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();
    
    public ArmUp(double arminches)
    {
        requires(Robot.m_arm);
        armPosition = arminches;
    }


    @Override 
    protected void initialize()
    {

       // Robot.m_arm.ResetArmEncoder(); 
    }

    @Override 
    protected void execute()
    {
        double leftYstick = -Robot.m_oi.joystick.getRawAxis(RobotMap.DRIVER_CONTROLLER_ARM_AXIS);
		if (Math.abs(leftYstick) < 0.10) { leftYstick = 0;}

        //double motorOutput = armMotorMaster.getMotorOutputPercent();

        double targetPos = armPosition;
        armMotorMaster.set(ControlMode.MotionMagic, targetPos);

        // Read and print encoder values
       // System.out.println("Sensor Vel:" + armMotorMaster.getSelectedSensorVelocity());
       // System.out.println("Sensor Pos:" + armMotorMaster.getSelectedSensorPosition());
       // System.out.println("Out %" + armMotorMaster.getMotorOutputPercent());  
        // System.out.println("Dist: " + armDistance);          
    }
    

    @Override 
    protected boolean isFinished()
    {
        return false;
    }



    @Override 
    protected void end()
    {       
        Robot.m_arm.armDrive(0);
    }

    @Override 
    protected void interrupted()
    {
        end();
    }
}