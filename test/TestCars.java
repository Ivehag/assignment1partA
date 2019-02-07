import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.*;
import java.util.LinkedList;

public class TestCars {
    /***
     * Test for Volvo240
     */
    public Volvo240 volvo;
    public Saab95 Saab;
    public Scania scania;
    public CarTransporter transporter;


    @Before
    public void init() {
        volvo = new Volvo240(4, 100, 0, Color.black, "Volvo240", 0, 0);
        scania = new Scania(2, 300, 1, Color.black, "Scania", 0, 0, 0);
        transporter = new CarTransporter(2, 300, 1, Color.black, "Transporter", 0, 0);
        Saab = new Saab95(2, 125, 0, Color.red, "Saab95", 0, 0, false);
    }

    @Test
    public void testGetNumberOfDoorsForVolvo240() {
        assertTrue(volvo.getNrDoors() == 4);
    }

    @Test
    public void testSetNumberOfDoorsForVolvo240() {
        volvo.setNrDoors(2);
        assertTrue(volvo.getNrDoors() == 2);
    }

    @Test
    public void testGetColorForVolvo240() {
        assertTrue(volvo.getColor() == Color.black);
    }

    @Test
    public void testSetColorForVolvo240() {
        volvo.setColor(Color.red);
        assertTrue(volvo.getColor() == Color.red);
    }

    @Test
    public void testGetCurrentSpeedVolvo240() {
        assertEquals(0, volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testGetModelNameForVolvo240() {
        assertTrue("Volvo240".contains(volvo.getModelName()));
    }

    @Test
    public void testGasVolvo240() {
        volvo.gas(0.5);
        assertEquals(Math.max(1.25 * 0.5, 0), volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testERRORGasVolvo240() {
        double tmp = volvo.getCurrentSpeed();
        volvo.gas(-0.5);
        assertEquals(tmp, volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testBrakeVolvo240() {
        double tmp = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertEquals(Math.max(tmp - volvo.getEnginePower() * 0.01 * 1.25 * 0.5, 0), volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testERRORBrakeVolvo240() {
        double tmp = volvo.getCurrentSpeed();
        volvo.brake(-0.5);
        assertEquals(tmp, volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testIncorrectValueForGasAmountVolvo240() {
        double tmp = volvo.getCurrentSpeed();
        volvo.gas(1.3);
        assertEquals(tmp, volvo.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testDirectionAfterTurningLeftVolvo240() {
        volvo.direction = AbstractCar.Direction.EAST;
        volvo.turnLeft();
        assertTrue(volvo.direction == AbstractCar.Direction.NORTH);
    }

    @Test
    public void testDirectionAfterTurningRightVolvo240() {
        volvo.direction = AbstractCar.Direction.EAST;
        volvo.turnRight();
        assertTrue(volvo.direction == AbstractCar.Direction.SOUTH);
    }

    @Test
    public void testMoveVolvo240() {
        volvo.setCurrentSpeed(2);
        volvo.direction = AbstractCar.Direction.NORTH;
        double tmp = volvo.getY();
        volvo.move();
        assertTrue(volvo.getY() > tmp);

    }

    @Test
    public void testStopEngine240() {
        volvo.setCurrentSpeed(2);
        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed(), 0.1);
    }

    /***
     * Tests for Saab95
     */


    @Test
    public void getBooleanTurboForSaab95() {
        assertTrue(Saab.getTurboStatus() == false);
    }


    @Test
    public void getXCoordinatesForSaab95() {
        assertTrue(Saab.x == 0);
    }

    @Test
    public void getYCoordinatesForSaab95() {
        assertTrue(Saab.y == 0);
    }


    @Test
    public void testGetNumberOfDoorsForSaab95() {
        assertTrue(Saab.getNrDoors() == 2);
    }

    @Test
    public void testGetEnginePowerForSaab95() {
        assertTrue(Saab.getEnginePower() == 125);

    }

    @Test
    public void testGetColorForSaab95() {
        assertTrue(Saab.getColor() == Color.red);
    }

    @Test
    public void testGetCurrentSpeedForSaab95() {
        assertTrue(Saab.getCurrentSpeed() == 0);
    }

    @Test
    public void testStopEngineSaab95() {
        Saab.setCurrentSpeed(2);
        Saab.stopEngine();
        assertEquals(0, Saab.getCurrentSpeed(), 0.1);
    }

    /***
     * Tests for Scania
     */


    @Test
    public void testGradientWithSpeed() {
        scania.tipTruckBed(20);
        assertEquals(0, scania.getCurrentTruckBedGradient(), 0.1);
    }

    @Test
    public void testGradientWithoutSpeed() {
        scania.setCurrentSpeed(0);
        scania.tipTruckBed(20);
        assertEquals(20, scania.getCurrentTruckBedGradient(), 0.1);
    }

    /***
     * Tests for CarTransporter
     */

    @Test
    public void testLoadCars() {
        transporter.loadCar(volvo);
        assertTrue(transporter.getCarAtIndex(0) == volvo);
    }
}

