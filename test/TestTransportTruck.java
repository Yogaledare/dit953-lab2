import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestTransportTruck {
    TransportTruck<Transportable> towTruck;

    @Before
    public void setUp() {
        towTruck = new TransportTruck<Volvo240>(1001, 5, 22, 9, 4, 10 );
    }

    @Test
    public void loadCarOntoTowTruck() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240(2, 4));
        assertEquals(1, towTruck.getSize());
    }

    @Test
    public void loadCarOntoTowTruckAndStartEngineWithoutClosingRamp() {
        towTruck.lowerRamp();
        // System.out.println("Ramp is down?: " + towTruck.isFullyLowered());
        towTruck.store(new Volvo240(2, 4));
        towTruck.startEngine();
        assertNotEquals(0, towTruck.getCurrentSpeed(), 0.01);
    }


    @Test
    public void loadCarOntoTowTruckAndCloseRamp() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240(2, 4));
        towTruck.raiseRamp();

        assertEquals(70, towTruck.getRampAngle(),0.1);
    }

    @Test
    public void loadCarOntoTowTruckAndCloseRampAndStartEngine() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240(2, 4));
        towTruck.raiseRamp();
        towTruck.startEngine();
        assertEquals(0.1, towTruck.getCurrentSpeed(),0.01);
    }


    @Test
    public void loadCarOntoTowTruckAndCloseRampAndCountContent() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240(2, 4));
        towTruck.raiseRamp();

        assertEquals(1, towTruck.getSize());
    }


    @Test
    public void loadCarOntoTowTruckAndCloseRampAndOpenRampAndUnload() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240(2, 4));
        towTruck.raiseRamp();
        towTruck.startEngine();
        towTruck.stopEngine();
        towTruck.lowerRamp();
        towTruck.remove(); // Car is sent to void!

        assertEquals(0, towTruck.getSize());
    }

    @Test
    public void loadCarOntoTowTruckAndCloseRampAndForgetToOpenRampAndUnload() {
        try{
            towTruck.lowerRamp();
            towTruck.store(new Volvo240(2, 4));
            towTruck.raiseRamp();
            towTruck.startEngine();
            towTruck.stopEngine();
            towTruck.remove(); // Car is sent to void!
        }catch(IllegalStateException ex){
                assertEquals(1, towTruck.getSize());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryLoadACarThatIsTooFarAway() {
        Volvo240 farAwayVolvo = new Volvo240(2, 4);
        farAwayVolvo.setPosition(new Vector2D(100, 100));
        towTruck.lowerRamp();
        towTruck.store(farAwayVolvo);

    }
}




