import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private final int X = 800;
    private final int Y = 800;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<AbstractCar> cars = new ArrayList<>();
    private boolean scania;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(4, 100, 0, Color.black, "Volvo240", 0, 0));
        cc.cars.add(new Saab95(4,100,0,Color.CYAN,"Saab95", 300,300,false));
        //scania;

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AbstractCar car : cars) {
                //          System.out.println(car.direction);
                if (car.getX() > X - 100) {
                    car.direction = AbstractCar.Direction.WEST;
                } else if (car.getX() < 0) {
                    car.direction = AbstractCar.Direction.EAST;
                } else if (car.getY() < 0) {
                    car.direction = AbstractCar.Direction.SOUTH;
                } else if (car.getY() > Y - 300) {
                    car.direction = AbstractCar.Direction.NORTH;
                }
                //     System.out.println(car.direction);
                //   System.out.println(car.getY());
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.gas(gas);
        }
    }

    void startAllEngines() {
        for (AbstractCar c : cars) {
            c.startEngine();
        }
    }

    void turnOffAllEngines() {
        for (AbstractCar c : cars) {
            c.stopEngine();
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.brake(brake);
        }
    }

    void setAllDirections(AbstractCar.Direction dir) {
        for (AbstractCar car : cars) {
            car.direction = dir;
        }
    }

    void turboOn() {
        for (AbstractCar car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (AbstractCar car : cars) {
            if (car.getClass() == Saab95.class) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void lowerTruckBed() {
        for (AbstractCar car : cars) {
            if (car.getClass() == Scania.class) {
                ((Scania) car).tipTruckBed(70);
            }
        }
    }

    void liftTruckBed() {
        for (AbstractCar car : cars) {
            if (car.getClass() == Scania.class) {
                ((Scania) car).liftTruckBed(70);
            }
        }
    }
}
