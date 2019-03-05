package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
//import frc.robot.Settings;

public class Autonomous extends CommandGroup {

  public Autonomous() {
    super();

    requires(Robot.m_ballPiston);
    
    addParallel(new HatchIn_Pnu());
    //addSequential(new Arm_Auto(Settings.Arm_Hat_Pos));
    addSequential(new Drive_Auto(1.5,.4,0,0));

    //addSequential(new Drive_Auto(1,0.6,0,0));

    
    //addSequential(new Arm_Auto(Settings.Arm_Mid_Pos));

    addParallel(new HatchOut_Pnu());
    addSequential(new Drive_Auto(1,-0.6,0,0));



    //addSequential(new HatchIn_Pnu());

    
    //Distance, Speed, Angle, Speed
    //addSequential(new Drive_Auto(0,0,15,.6));  //Distance, Speed, Angle, Speed
    //addSequential(new Drive_Auto(1,0.5,0,0));  //Distance, Speed, Angle, Speed
    //addSequential(new HatchOut_Pnu());         //Hatch
    //addSequential(new HatchIn_Pnu());

    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }

  //@Override 
 //protected boolean isFinished()
  //{
  //  return true;
  //}

  @Override 
  protected void end(){       
  }
}