import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestTransportTruck {
    TransportTruck<Vehicle> towTruck;

    @Before
    public void setUp() {
        LIFO<Vehicle> platform = new LIFO<>(1,2.6, 6);
        towTruck = new TransportTruck<>("MAN", Color.yellow, 500, 2, 9, platform, 4, 10 );
    }

    @Test
    public void loadCarOntoTowTruck() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240());
        assertEquals(1, towTruck.getStorageCount());

    }

    @Test
    public void loadCarOntoTowTruckAndStartEngineWithoutClosingRamp() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240());
        towTruck.startEngine();
        assertNotEquals(0, towTruck.getCurrentSpeed(), 0.01);
    }


    @Test
    public void loadCarOntoTowTruckAndCloseRamp() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240());
        towTruck.raiseRamp();

        assertEquals(70, towTruck.getRampAngle(),0.1);
    }

    @Test
    public void loadCarOntoTowTruckAndCloseRampAndStartEngine() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240());
        towTruck.raiseRamp();
        towTruck.startEngine();
        assertEquals(0.1, towTruck.getCurrentSpeed(),0.01);
    }


    @Test
    public void loadCarOntoTowTruckAndCloseRampAndCountContent() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240());
        towTruck.raiseRamp();

        assertEquals(1, towTruck.getStorageCount());
    }


    @Test
    public void loadCarOntoTowTruckAndCloseRampAndOpenRampAndUnload() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240());
        towTruck.raiseRamp();
        towTruck.startEngine();
        towTruck.stopEngine();
        towTruck.lowerRamp();
        towTruck.remove(); // Car is sent to void!

        assertEquals(0, towTruck.getStorageCount());
    }

    @Test
    public void loadCarOntoTowTruckAndCloseRampAndForgetToOpenRampAndUnload() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240());
        towTruck.raiseRamp();
        towTruck.startEngine();
        towTruck.stopEngine();
        towTruck.remove(); // Car is sent to void!

        assertEquals(1, towTruck.getStorageCount());
    }

}



