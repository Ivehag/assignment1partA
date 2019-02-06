import java.awt.*;

public class Scania extends AbstractCar {
    private double currentTruckBedGradient;

    public Scania(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y, double currentTruckBedGradient) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
        this.currentTruckBedGradient = currentTruckBedGradient;
    }

    public double getCurrentTruckBedGradient() {
        return currentTruckBedGradient;
    }

    private void setTruckBedGradient(double gradient) {
        this.currentTruckBedGradient = gradient;
    }

    public void tipTruckBed(double gradients) {
        double maxTruckBedGradient = 70.0;
        if (getCurrentTruckBedGradient() + gradients < maxTruckBedGradient && getCurrentSpeed() == 0) {
            setTruckBedGradient(getCurrentTruckBedGradient() + gradients);
        }
    }

    public void liftTruckBed(double gradients) {
        double minTruckBedGradient = 0.0;
        if (getCurrentTruckBedGradient() - gradients > minTruckBedGradient && getCurrentSpeed() == 0) {
            setTruckBedGradient(getCurrentTruckBedGradient() - gradients);
        }
    }

    private double speedFactor() {
        return getEnginePower() * 0.01;
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
