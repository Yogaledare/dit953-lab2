import org.junit.Test;
import static org.junit.Assert.*;

public class TestCar {
    Car saab95 = new Saab95();


    @Test
    public void testGetSaab95ModelName() {
        assertEquals("Saab95", saab95.getModelName());
    }
}
