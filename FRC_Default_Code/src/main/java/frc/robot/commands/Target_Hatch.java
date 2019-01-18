package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Target_Hatch extends Command {

public static LimeLight_GetData valuesObj = new LimeLight_GetData();

@Override 
    protected void initialize()
    {
            
    }


    @Override 
    protected void execute()
    {
       
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