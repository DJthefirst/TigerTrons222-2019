package frc.robot.autonomus;


import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.commands.DriveArcade;

public class Forward implements AutonomusInterface {

    private double startingDistance;
    private double mWantedDistance;
    private double mVelocity;
    private double mGyro;
    private double encoder;
   Drivetrain dt = new Drivetrain();
  DifferentialDrive df = dt.differentialDrive;

     public Forward(double distance, double velocity, double gyro) {
        mWantedDistance = distance;
        mVelocity = velocity;
        mGyro = gyro;
    }

    @Override
    public void start() {
       
        doYourJobMotherFucker();
    }

    @Override
    public void doYourJobMotherFucker() {

        while(encoder<mWantedDistance)
        { 


           // -1-0=Backwards 0- 1=Fowards

           //wez obiekty z kalsy drive train
    //foward

            Drivetrain.leftMasterTalon=1;
            Drivetrain.rightMasterTalon=1;
            
  











        }
        
    }

   
    
       
    

    @Override
    public void done() {
      
    }

    @Override
    public boolean isFinished() {
        return false;
    }

  
            
}

// package frc.robot.autonomus;


// import frc.robot.subsystems.Drivetrain;

// /**
//  * DriveStraightAction drives the robot straight at a settable angle, distance,
//  * and velocity. This action begins by setting the drive controller, and then
//  * waits until the distance is reached.
//  *
//  * @see Action
//  * @see Drive
//  * @see Rotation2d
//  */
// public class Forward implements AutonomusInterface {

//     private double startingDistance;
//     private double mWantedDistance;
//     private double mVelocity;
//     private double mHeading;
//     private Drivetrain mDrive = Drivetrain.getInstance();

//     public Forward(double distance, double velocity) {
//         this(distance, velocity, 0);
//     }

//     public Forward(double distance, double velocity, double heading) {
//         mWantedDistance = distance;
//         mVelocity = velocity;
//         mHeading = heading;
//     }

//     @Override
//     public void start() {
//         startingDistance = getCurrentDistance();
//       //  mDrive.setVelocityHeadingSetpoint(mVelocity, Rotation2d.fromDegrees(mHeading));
//     }

//     @Override
//     public void update() {
//     }

//     @Override
//     public boolean isFinished() {
//         boolean rv = false;
//         if (mWantedDistance > 0) {
//             rv = getCurrentDistance() - startingDistance >= mWantedDistance;
//         } else {
//             rv = getCurrentDistance() - startingDistance <= mWantedDistance;
//         }
//         if (rv) {
//             mDrive.arcadeDrive(0, 0);//speed of moving speed of rotation
//         }
//         return rv;
//     }

//     @Override
//     public void done() {
//         mDrive.arcadeDrive(0, 0);
//     }

//     private double getCurrentDistance() {
//         return 1; //change if you want it to work
//             }
// }
