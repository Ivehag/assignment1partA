import java.awt.*;

public class Volvo240 extends AbstractCar implements Movable {
    /***
     * Constant given be Volvo240's trim
     */
    private final static double trimFactor = 1.25;
  /*  public int Volvo240nrDoors = 4;
    public Color Volvo240color = Color.black;
    public double Volvo240enginePower = 100;
    public String Volvo240modelName = "Volvo240";*/

    //  public int nrDoors; // Number of doors on the car
    // public double enginePower; // Engine power of the car
    //  public double currentSpeed; // The current speed of the car
    //  public Color color; // Color of the car
    //public String modelName; // The car model name

    /***
     * Constructor for Volvo240
     * @param nrDoors see AbstractCar
     * @param enginePower see AbstractCar
     * @param currentSpeed see AbstractCar
     * @param color see AbstractCar
     * @param modelName see AbstractCar
     * @param x see AbstractCar
     * @param y see AbstractCar
     */
    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
       /* nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();*/
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);

     //   stopEngine();

    }


    /*

        public int getNrDoors() {

            return nrDoors;
        }

        public double getEnginePower() {
            return enginePower;
        }

        public double getCurrentSpeed() {
            return currentSpeed;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color clr) {
            color = clr;
        }

        public void startEngine() {
            currentSpeed = 0.1;
        }

        public void stopEngine() {
            currentSpeed = 0;
        }
    */

    /***
     * Method to calculate the factor of speed
     * @return Total velocity of the Volvo240
     */
    private double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    /***
     * Increases the total speed of the Volvo240
     * @param amount amount of speed increment
     */

    private void incrementSpeed(double amount) {

        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));

    }

    /***
     * Decrement of speed of the Volvo240
     * @param amount amount of speed decrement
     */
    private void decrementSpeed(double amount) {

        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));

    }

    /***
     * Gives gas to the Volvo240
     * @param amount amount of gas (speed increment) to the Volvo240
     */
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        boolean isIncrementSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) > getCurrentSpeed();
        boolean isInCurrentSpeedInterval = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) >= 0 && Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()) <= getEnginePower();
        if (amount >= 0 && amount <= 1 && isIncrementSpeed && isInCurrentSpeedInterval) {
            incrementSpeed(amount);
        }
    }

    /***
     * Uses breaks of the Volvo240
     * @param amount amount of break (speed decrement) of the Volvo240
     */

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        boolean isDecrementSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0) < getCurrentSpeed();
        boolean isInCurrentSpeedInterval = Math.max(getCurrentSpeed() - speedFactor() * amount, 0) >= 0 && Math.max(getCurrentSpeed() - speedFactor() * amount, 0) <= getEnginePower();
        if (amount >= 0 && amount <= 1 && isDecrementSpeed && isInCurrentSpeedInterval) {
            decrementSpeed(amount);
        }
    }
}
