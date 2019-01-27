
//Change packgae
package frc.robot.autonomus;

/**
 * Action Interface, an interface that describes an iterative action. It is run
 * by an autonomous action, called by the method runAction in AutoModeBase (or
 * more commonly in autonomous modes that extend AutoModeBase)
 *
 * @see com.team254.frc2016.auto.AutoModeBase#runAction
 */
public interface AutonomusInterface {

    /**
     * Returns whether or not the code has finished execution. When implementing
     * this interface, this method is used by the runAction method every cycle
     * to know when to stop running the action
     * 
     * @return boolean
     */
    public abstract boolean isFinished();
   

    /**
 

     */
    public abstract void doYourJobMotherFucker();

    /**
     * Run code once 1x the action finishes, usually for clean up
     */
    public abstract void done();

    /**
     * Run code 1x when the action is started, for set up
     */
    public abstract void start();
}