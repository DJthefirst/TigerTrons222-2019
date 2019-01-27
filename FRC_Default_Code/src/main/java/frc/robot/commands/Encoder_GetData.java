package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
import frc.robot.Robot;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

public class Encoder_GetData extends Command {

public static Drivetrain  objDrive = new Drivetrain();
CANSparkMax eSpark1 = objDrive.Spark1;

    public Encoder_GetData()
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

    CANEncoder SparkEncoder1;
    SparkEncoder1= eSpark1.getEncoder();

	System.out.println("Encoder Position" + SparkEncoder1.getPosition());
	System.out.println("Encoder Velocity" + SparkEncoder1.getVelocity());
    
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

	