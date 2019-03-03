/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;  
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HatchIn_Pnu;
import frc.robot.commands.HatchOut_Pnu;
import frc.robot.commands.BallIn_Pnu;
import frc.robot.commands.BallIntakecmd_Btn;
import frc.robot.commands.BallOut_Pnu;
import frc.robot.commands.SkidIn;
import frc.robot.commands.SkidOut;
import frc.robot.commands.DriveLimeLight;
import frc.robot.commands.Drive_Auto;
import frc.robot.commands.LimeLight_Pipeline;
import frc.robot.commands.ShiftIn_Pnu;
import frc.robot.commands.ShiftOut_Pnu;
import frc.robot.commands.Arm_Auto;
import frc.robot.commands.Autonomous;
import frc.robot.Settings;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @param <Joystick>
 */
public class OI<Joystick> {

	public XboxController Controller = new XboxController(RobotMap.OI_DRIVER_CONTROLLER1);
	public XboxController Controller2 = new XboxController(RobotMap.OI_DRIVER_CONTROLLER2);

	Button D1 = new JoystickButton(Controller, 1);
	Button D2 = new JoystickButton(Controller, 2);
	Button D3 = new JoystickButton(Controller, 3);
	Button D4 = new JoystickButton(Controller, 4);
	Button D5 = new JoystickButton(Controller, 5);
	Button D6 = new JoystickButton(Controller, 6);
	Button D7 = new JoystickButton(Controller, 7);
	Button D8 = new JoystickButton(Controller, 8);
	Button D9 = new JoystickButton(Controller, 9);
	Button D10 = new JoystickButton(Controller, 10);

	Button D11 = new JoystickButton(Controller2, 1);
	Button D12 = new JoystickButton(Controller2, 2);
	Button D13 = new JoystickButton(Controller2, 3);
	Button D14 = new JoystickButton(Controller2, 4);
	Button D15 = new JoystickButton(Controller2, 5);
	Button D16 = new JoystickButton(Controller2, 6);
	Button D17 = new JoystickButton(Controller2, 7);
	Button D18 = new JoystickButton(Controller2, 8);
	Button D19 = new JoystickButton(Controller2, 9);
	Button D20 = new JoystickButton(Controller2, 10);
	
	//public?
//public Joystick driver = new Joystick(0);

//// CREATING BUTTONS
	public OI()
	{
		// controller 1
		//D1.whenPressed(new HatchOut_Pnu());
		//D1.whenReleased(new HatchIn_Pnu());
		//D2.whenPressed(new BallOut_Pnu());
		//D2.whenReleased(new BallIn_Pnu());	
		//D2.whileHeld(new BallIntakecmd_Btn());
		D3.whenPressed(new SkidIn());
		D3.whenReleased(new SkidOut());
		D5.whenPressed(new ShiftIn_Pnu());
		D5.whenReleased(new ShiftOut_Pnu());
		//D8.whileHeld(new DriveForward(40, 0.8, 25 ,.5)); //arcing turn
		D8.whenPressed(new Autonomous());
		//D7.whileHeld(new Autonomous());
		D7.whenPressed(new LimeLight_Pipeline());
		//D7.whileHeld(new Drive_Auto(0, 0.4, 10 ,.5));
		//D8.whileHeld(new DriveForward(30, 0.8, 25 ,1)); //Distance, Speed, Angle, Speed
		D6.whileHeld(new DriveLimeLight());
		//D6.whileHeld(new DriveGyro());
		//D7.whenPressed(new DriveEncoder_Reset());
		//D7.whileHeld(new ArmUp(800));
		


		//controller 2
		//D11.whenPressed(new HatchOut());
		//D11.whenReleased(new HatchIn());
		D11.whileHeld(new Arm_Auto(Settings.Arm_Bot_Pos));
		D12.whileHeld(new Arm_Auto(Settings.Arm_Mid_Pos));
		D13.whileHeld(new Arm_Auto(Settings.Arm_Hat_Pos));
		D14.whileHeld(new Arm_Auto(Settings.Arm_Top_Pos));
		//D14.whileHeld(new Arm_Auto(500));//Max!
		D15.whenPressed(new HatchOut_Pnu());
		D15.whenReleased(new HatchIn_Pnu());
		D16.whenPressed(new BallOut_Pnu());
		D16.whenReleased(new BallIn_Pnu());







		//D12.whenPressed(new BallOut());
		//D12.whenReleased(new BallIn());	
		//D13.whenPressed(new SkidIn());
		//D13.whenReleased(new SkidOut());	
		//D15.whenPressed(new Shiftcmd());
		//D14.whileHeld(new DriveForward(40, 0.8, 25 ,.5)); //arcing turn
		//D3.whileHeld(new DriveForward(40, 0.8, 0 ,0));
		//D2.whileHeld(new DriveForward(30, 0.8, 25 ,1)); //Distance, Speed, Angle, Speed
		//D6.whileHeld(new DriveLimeLight());
		//D6.whileHeld(new DriveGyro());
		//D7.whenPressed(new DriveEncoder_Reset());
		//D7.whileHeld(new ArmUp(800));
		//D17.whenPressed(new LimeLight_Pipeline());
		//D18.whileHeld(new ArmUp(900));



	}
	

	//public Joystick GetJoystick()
	//{
	//	return driver;
	//}
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
