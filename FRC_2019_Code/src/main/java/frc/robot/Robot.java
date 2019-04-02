package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Autonomous;
import frc.robot.commands.Autonomous2;
import frc.robot.commands.Autonomous_Sand;
import frc.robot.commands.Autonomous1;
import frc.robot.subsystems.Hatch;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.BallPiston;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shift;
import frc.robot.subsystems.Skid;
import frc.robot.subsystems.UpyDownyArmThing;

import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	//public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
	public static Limelight m_limelight = null;
	public static Drivetrain m_drivetrain = null;
	public static Hatch m_hatch = null;
	public static BallPiston m_ballPiston = null;
	public static BallIntake m_BallIntake = null;
	public static Shift m_shift = null;
	public static Skid m_skid = null;
	public static UpyDownyArmThing m_arm = null;
	public static OI m_oi;
	public static Object commands;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	//SendableChooser<Command> m_cameraMode = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override

	public void robotInit() {

		//drivetrain
		m_limelight = new Limelight();
		m_drivetrain = new Drivetrain();
		m_hatch = new Hatch();
		m_skid = new Skid();
		m_BallIntake = new BallIntake();
		m_ballPiston = new BallPiston();
		m_shift = new Shift();
		m_arm = new UpyDownyArmThing();
		m_oi = new OI();
		m_autonomousCommand = new Autonomous();
	

		m_chooser.addDefault("Default Auto", new Autonomous_Sand());
		SmartDashboard.putData("Auto mode", m_chooser);
		m_chooser.addOption("Sand Storm", new Autonomous_Sand());
		SmartDashboard.putData("Auto mode", m_chooser);
		m_chooser.addOption("Autonomus 1", new Autonomous1());
		SmartDashboard.putData("Auto mode", m_chooser);
		m_chooser.addOption("Autonomus 2", new Autonomous2());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		//THINK ABOUT IT
		//m_cameraMode.addDefault("Default Camera", new #());
		//SmartDashboard.putData("Camera", m_cameraMode);
		//m_chooser.addOption("Sand Storm", new DrivePipeline());
		//SmartDashboard.putData("Camera", m_cameraMode);
		//m_chooser.addOption("Limelight", new Autonomous1());
		//SmartDashboard.putData("Camera", m_cameraMode);
	
		

		NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);
		//new DoubleSolenoid(RobotMap.SHIFT_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);
		//new DoubleSolenoid(RobotMap.SKID_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);
		//new DoubleSolenoid(RobotMap.BALLPISTON_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);
		//new DoubleSolenoid(RobotMap.HATCH_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(1);

		//new DoubleSolenoid(RobotMap.SHIFT_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);
		//new DoubleSolenoid(RobotMap.SKID_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);
		//new DoubleSolenoid(RobotMap.BALLPISTON_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);
		//new DoubleSolenoid(RobotMap.HATCH_SOLENOID_DEPLOY,RobotMap.SHIFT_SOLENOID_RETRACT).set(DoubleSolenoid.Value.kForward);


		
		//    String autoSelected = SmartDashboard.getString("Auto Selector","Default");
		//    switch(autoSelected) {
		//  	case "My Auto": autonomousCommand = new Autonomous();
		//  		break; 
		//  	case "Autonomus2": autonomousCommand = new Autonomous2();
		// 		 break; 
		// 	 case "Autonomus3": autonomousCommand = new Autonomous3();
		//  		break; 	 
		//  default:
		//  		autonomousCommand = new Autonomous();
		//  break;}

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			//m_autonomousCommand.start(); trying to eliminate rapid fire solenoid
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		m_autonomousCommand.start(); //when you take this out, autonomous does not cycle
	}
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0);

		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
