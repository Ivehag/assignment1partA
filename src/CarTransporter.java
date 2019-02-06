import java.awt.*;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

public class CarTransporter<T extends AbstractCar> extends AbstractCar {
    private Ramp ramp;
    private List<T> cars;
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

    public Ramp getRampStatus() {
        return ramp;
    }

    public void loadCar(T car) {
        boolean carCloseToTransporter = getX() - car.getX() <= delta && getY() - car.getY() <= delta;

        if (carCloseToTransporter && getRampStatus() == Ramp.DOWN) {
            cars.add(car);
        }
    }

}
