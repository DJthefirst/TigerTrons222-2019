
package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 *
 */
public class DriveEncoder_Reset extends InstantCommand {

    private WPI_TalonSRX leftSlave1Talon = Robot.m_drivetrain.getLeftTalon();

    public DriveEncoder_Reset() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.m_drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Robot.cascadeLift.resetEncoder();
        //leftSlave1Talon.setSelectedSensorPosition(0, 0, 0);
        leftSlave1Talon.set(0);
        //maybe
        //leftSlave1Talon.getSensorCollection().setQuadraturePosition(0, 0);
    }
}