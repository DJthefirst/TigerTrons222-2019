package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Settings;


public class BallOut_Pnu extends Command {

	private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();

	public BallOut_Pnu() {
		super();

		requires(Robot.m_ballPiston);
		requires(Robot.m_BallIntake);
	}

	@Override
	protected void initialize() {
		System.out.println("---Pitch Up---");

		if(armMotorMaster.getSelectedSensorPosition() > (Settings.Ball_Bot_Pos - 10))
		{
			Robot.m_ballPiston.pitchUp();
		}
	}

	@Override 
    protected void execute(){	
		Robot.m_BallIntake.BallDrive(.75);

	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}