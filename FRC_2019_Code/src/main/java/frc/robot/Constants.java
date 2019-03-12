
//Pid Settings

package frc.robot;

public class Constants {

	public static final int kSlotIdx = 0;

	public static final int kPIDLoopIdx = 0;

	public static final int kTimeoutMs = 30;

	
	//Pid Values
	
    //Gains(kp, ki, kd, kf, izone, peak output);
	public static final Gains ARM_kGains = new Gains(10, 0.001, 5, 0, 0, 1.0); 
	public static final Gains DRIVE_kGains = new Gains(0, 0.0, 0.0, 0.2, 0, 1.0);
	public static final Gains TURN_kGains = new Gains(0, 0.0, 0.0, 0.2, 0, 1.0);
	public static final double Turn_kGain = .04;
}
