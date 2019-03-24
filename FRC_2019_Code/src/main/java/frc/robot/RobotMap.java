package frc.robot;

public class RobotMap {

	public static final	int Drive_Left = 0;
	public static final	int Drive_Right = 1;

	//Sparks
	public static final int DRIVETRAIN_RIGHT_Master_SPARKMAX = 1;
	public static final int DRIVETRAIN_RIGHT_Slave1_SPARKMAX = 2;
	public static final int DRIVETRAIN_RIGHT_Slave2_SPARKMAX = 3;			
	public static final int DRIVETRAIN_LEFT_Master_SPARKMAX = 4;
	public static final int DRIVETRAIN_LEFT_Slave1_SPARKMAX = 5;
	public static final int DRIVETRAIN_LEFT_Slave2_SPARKMAX = 6;

	//Talons
	public static final int ARM_MOTOR_Master_TALON = 8;
	public static final int ARM_MOTOR_Slave_TALON = 9;
	public static final int Climb_MOTOR_Master_TALON = 7;
	public static final int Climb_MOTOR_Slave_TALON = 10;
	public static final int Intake_MOTOR_TALON = 12;
	
	//Encoders
	public static final int DRIVETRAIN_ENCODER_L = 0;
	public static final int DRIVETRAIN_ENCODER_R = 1;
	public static final int ARM_ENCODER_A = 2;

	//Gyro
	public static final int ROBOT_GYRO = 1;

	//Controllers
	public static final int OI_DRIVER_CONTROLLER1 = 0;
	public static final int OI_DRIVER_CONTROLLER2 = 1;
	
	//Joysticks
	public static final int DRIVER_CONTROLLER2_ARM_AXIS = 1;
	public static final int DRIVER_CONTROLLER2_CLIMB_AXIS = 2;
	public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1;
	public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 4;
	public static final int DRIVER_CONTROLLER_ROTATE_INTAKE_In = 2;
	public static final int DRIVER_CONTROLLER_ROTATE_INTAKE_Out = 3;
	public static final int	DRIVER_CONTROLLER2_ARM_SHIFT = 3;

	//Solenoids
	public static final int SHIFT_SOLENOID_DEPLOY = 0;
	public static final int SHIFT_SOLENOID_RETRACT = 1;
	public static final int SKID_SOLENOID_DEPLOY = 2;
	public static final int SKID_SOLENOID_RETRACT = 3;
	public static final int BALLPISTON_SOLENOID_DEPLOY =4;
	public static final int BALLPISTON_SOLENOID_RETRACT = 5;
	public static final int HATCH_SOLENOID_DEPLOY = 6;
	public static final int HATCH_SOLENOID_RETRACT = 7;
}
