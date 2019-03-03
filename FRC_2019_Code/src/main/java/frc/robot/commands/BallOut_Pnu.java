package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.Settings;


public class BallOut_Pnu extends InstantCommand {

	private WPI_TalonSRX armMotorMaster = Robot.m_arm.getArmTalon();

	public BallOut_Pnu() {
		super();

		requires(Robot.m_ballPiston);


	}

	@Override
	protected void initialize() {
		System.out.println("---Pitch Up---");

		if(armMotorMaster.getSelectedSensorPosition() > (Settings.Arm_Bot_Pos - 10))
		{
			Robot.m_ballPiston.pitchUp();
		}
	}
}