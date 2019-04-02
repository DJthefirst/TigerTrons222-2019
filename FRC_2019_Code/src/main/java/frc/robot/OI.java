package frc.robot;

import edu.wpi.first.wpilibj.Joystick;  
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HatchIn_Pnu;
import frc.robot.commands.HatchOut_Pnu;
import frc.robot.commands.BallIn_Pnu;
import frc.robot.commands.BallOut_Pnu;
import frc.robot.commands.SkidIn_Pnu;
import frc.robot.commands.SkidOut_Pnu;
import frc.robot.commands.Skidcmd_Pnu;
import frc.robot.commands.DriveLimeLight;
import frc.robot.commands.LimeLight_Pipeline;
import frc.robot.commands.ShiftIn_Pnu;
import frc.robot.commands.ShiftOut_Pnu;
import frc.robot.commands.Arm_Auto;

public class OI<Joystick> {

	public XboxController Controller = new XboxController(RobotMap.OI_DRIVER_CONTROLLER1);
	public XboxController Controller2 = new XboxController(RobotMap.OI_DRIVER_CONTROLLER2);

	//Controller 1
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

	//Controller 2
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

		D5.whenPressed(new ShiftIn_Pnu());						//Left Button
		D5.whenReleased(new ShiftOut_Pnu());					
		D6.whileHeld(new DriveLimeLight());						//Right Button
		D7.whenPressed(new LimeLight_Pipeline());
		D8.whenPressed(new Skidcmd_Pnu());							//Back
							//Menu
		D9.whenPressed(new SkidOut_Pnu());						//Left Stick
		D9.whenReleased(new SkidIn_Pnu());

		//controller 2
		D11.whileHeld(new Arm_Auto(6));		//A 4
		D12.whileHeld(new Arm_Auto(2));		//B 
		D13.whileHeld(new Arm_Auto(4));		//X 6
		D14.whileHeld(new Arm_Auto(0));		//Y
		D15.whenPressed(new HatchOut_Pnu());					//Left Button
		D15.whenReleased(new HatchIn_Pnu());					
		D16.whenPressed(new BallOut_Pnu());						//Right Button
		D16.whenReleased(new BallIn_Pnu());
	}
}
