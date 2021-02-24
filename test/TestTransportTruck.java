import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTransportTruck {
    TransportTruck<Transportable> towTruck;

    @Before
    public void setUp() {
        towTruck = new TransportTruck<>(1001, 5, 22, 9, 4, 10 );
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
        // System.out.println("Model.Ramp is down?: " + towTruck.isFullyLowered());
        towTruck.store(new Volvo240(2, 4));
        towTruck.startEngine();
        assertFalse(towTruck.isMoving());
    }


    @Test
    public void loadCarOntoTowTruckAndCloseRamp() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240(2, 4));
        towTruck.raiseRamp();

        assertTrue(towTruck.isFullyRaised() );
    }

    @Test
    public void loadCarOntoTowTruckAndCloseRampAndStartEngine() {
        towTruck.lowerRamp();
        towTruck.store(new Volvo240(2, 4));
        towTruck.raiseRamp();
        towTruck.startEngine();
        assertTrue(towTruck.isMoving());
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
        towTruck.remove(); // Model.Car is sent to void!

        assertEquals(0, towTruck.getSize());
    }

    @Test
    public void loadTowTruckOnSelf() {
            towTruck.store(towTruck);
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
            towTruck.remove(); // Model.Car is sent to void!
        } catch(IllegalStateException ex){
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




