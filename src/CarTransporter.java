import java.awt.*;
import java.util.List;
import java.util.Stack;
import java.util.spi.AbstractResourceBundleProvider;

public class CarTransporter<T extends AbstractCar> extends AbstractCar {
    private Ramp ramp;
    private Stack<T> cars = new Stack<>();
    private double delta = 2;

    private enum Ramp {UP, DOWN}

    ;

    public CarTransporter(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);

    }


    public void setRampUp() {
        if (getCurrentSpeed() == 0) {
            ramp = Ramp.UP;
        }
    }

    /***
     * we want to throw a exception if getCurrentSpeed()!=0
     */
    public void setRampDown() {
        if (getCurrentSpeed() == 0) {
            ramp = Ramp.DOWN;
        }
    }

    /***
     * get method
     * @return
     */
    public Ramp getRampStatus() {
        return ramp;
    }

    /***
     * Speed factor
     * @return
     */
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }


    public void loadCar(T car) {
        boolean carCloseToTransporter = Math.abs(getX() - car.getX()) <= delta && Math.abs(getY() - car.getY()) <= delta;

        if (carCloseToTransporter && getRampStatus() == Ramp.DOWN && car.getClass() != CarTransporter.class) {
            car.setY(getY());
            car.setX(getX());
            cars.push(car);
        }

    }

    /***
     * Unload the car of class T on top of the Stack
     */
    public void unloadCar() {
        cars.pop();
    }

    /***
     * Set method
     */
    public void setCarPositionEqualsToCarTransporter() {
        for (int i = 0; i < cars.size(); i++) {
            cars.elementAt(i).setX(getX());
            cars.elementAt(i).setY(getY());
        }

    }

    /***
     * Get method
     * @param i
     * @return
     */
    public T getCarAtIndex(int i) {
        return cars.elementAt(i);
    }

}
