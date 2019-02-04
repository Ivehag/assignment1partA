import java.awt.*;

public class Saab95 extends AbstractCar implements Movable {
    /***
     * Variable which shows whether the turbo in SAAB95 is on or off
     */
    private boolean turboOn;


    /***
     * Constructor for SAAB95
     * @param nrDoors see AbstractCar
     * @param enginePower see AbstractCar
     * @param currentSpeed see AbstractCar
     * @param color see AbstractCar
     * @param modelName see AbstractCar
     * @param x see AbstractCar
     * @param y see AbstractCar
     * @param turboOn boolean if turbo is on or off
     */
    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, boolean turboOn) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
      /*  nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();*/
        //  super(nrDoors, enginePower, currentSpeed, color, modelName, x, y, dx, dy);
        this.turboOn = turboOn;
        //stopEngine();

    }


    /***
     * Method to move the SAAB95
     */
/*
    public void move() {
        turnRight();
        turnLeft();
    }
*/
    /***
     * Sets new direction when turning left
     */
  /*  public void turnLeft() {
        boolean drivesStraightForward = dx == 0 && y > 0;
        boolean drivesReverseDirection = dx == 0 && y < 0;
        boolean drivesInRightDirection = dx > 0 && y == 0;
        boolean drivesInLeftDirection = dx < 0 && y == 0;

        if (drivesStraightForward) {
            dx = -currentSpeed;
            dy = 0;
        }
        if (drivesInRightDirection) {
            dy = currentSpeed;
            dx = 0;
        }
        if (drivesInLeftDirection) {
            dy = currentSpeed;
            dx = 0;
        }
        if (drivesReverseDirection) {
            dx = -currentSpeed;
            dy = 0;
        }
    }
*/

/*
    public void turnRight() {
        boolean drivesStraightForward = dx == 0 && y > 0;
        boolean drivesReverseDirection = dx == 0 && y < 0;
        boolean drivesInRightDirection = dx > 0 && y == 0;
        boolean drivesInLeftDirection = dx < 0 && y == 0;

        if (drivesStraightForward) {
            dx = currentSpeed;
            dy = 0;
        }
        if (drivesInRightDirection) {
            dy = -currentSpeed;
            dx = 0;
        }
        if (drivesInLeftDirection) {
            dy = -currentSpeed;
            dx = 0;
        }
        if (drivesReverseDirection) {
            dx = currentSpeed;
            dy = 0;
        }
    }
*/
    /*  public int getNrDoors(){
          return nrDoors;
      }
      public double getEnginePower(){
          return enginePower;
      }

      public double getCurrentSpeed(){
          return currentSpeed;
      }

      public Color getColor(){
          return color;
      }

      public void setColor(Color clr){
          color = clr;
      }

      public void startEngine(){
          currentSpeed = 0.1;
      }

      public void stopEngine(){
          currentSpeed = 0;
      }
  */

    /***
     * Sets boolean turboOn to true
     */
    public void setTurboOn() {
        this.turboOn = true;
    }

    /***
     * Sets boolean turboOn to false
     */
    public void setTurboOff() {
        this.turboOn = false;
    }

    /***
     * Checks turbo status
     * @return boolean turboOn
     */

    public boolean getTurboStatus() {
        return turboOn;
    }


    /***
     *  velocity factor of the Saab95
     * @return Total velocity of the Saab95
     */

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /***
     * Increases the speed of the Saab95
     * @param amount amount of speed increment
     */
    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /***
     * Decreases the speed of the Saab95
     * @param amount amount of speed decrement
     */
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    /***
     * Gives gas to the Saab95
     * @param amount amount of gas (speed increment) to the Saab95
     */
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        boolean isIncrementSpeed = getCurrentSpeed() + speedFactor() * amount > getCurrentSpeed();
        boolean isInCurrentSpeedInterval = getCurrentSpeed() + speedFactor() * amount >= 0 && getCurrentSpeed() + speedFactor() * amount <= enginePower;
        if (amount >= 0 && amount <= 1 && isIncrementSpeed && isInCurrentSpeedInterval) {
            incrementSpeed(amount);
        }
    }

    /***
     * Uses breaks of the Saab95
     * @param amount amount of break (speed decrement) of the Saab95
     */
    // TODO fix this method according to lab pm
    public void brake(double amount) {
        boolean isDecrementSpeed = getCurrentSpeed() + speedFactor() * amount < getCurrentSpeed();
        boolean isInCurrentSpeedInterval = getCurrentSpeed() + speedFactor() * amount >= 0 && getCurrentSpeed() + speedFactor() * amount <= enginePower;
        if (amount >= 0 && amount <= 1 && isDecrementSpeed && isInCurrentSpeedInterval) {
            decrementSpeed(amount);
        }
    }
}