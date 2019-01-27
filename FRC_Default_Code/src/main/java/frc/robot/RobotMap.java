/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {


	public static final 
		int Drive_Left = 0;
		int Drive_Right = 1;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.



				//Talons
	public static final int DRIVETRAIN_RIGHT_Master_TALON = 1;
	public static final int DRIVETRAIN_RIGHT_Slave1_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_Slave2_TALON = 3;			
	public static final int DRIVETRAIN_LEFT_Master_TALON = 4;
	public static final int DRIVETRAIN_LEFT_Slave1_TALON = 5;
	public static final int DRIVETRAIN_LEFT_Slave2_TALON = 6;
	public static final int DRIVETRAIN_SPARK1 = 0;
	public static final int DRIVETRAIN_SPARK2 = 1;
				//Joystick
	public static final int OI_DRIVER_CONTROLLER = 0;

				//may need axis 0,1
	public static final int DRIVER_CONTROLLER_MOVE_AXIS = 5;
	public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 4;
	


	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:

	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Solenoids
	public static final int SHOOTER_PITCH_SOLENOID_DEPLOY = 6;
	public static final int SHOOTER_PITCH_SOLENOID_RETRACT = 1;
	public static final int ARM_PITCH_SOLENOID_DEPLOY = 6;
	public static final int ARM_PITCH_SOLENOID_RETRACT = 1;
	public static final int SHIFT_SOLENOID_DEPLOY = 6;
	public static final int SHIFT_SOLENOID_RETRACT = 1;
	public static final int BALLPISTON_SOLENOID_DEPLOY = 6;
	public static final int BALLPISTON_SOLENOID_RETRACT = 1;
}
