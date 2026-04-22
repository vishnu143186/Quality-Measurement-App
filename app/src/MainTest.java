import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testFeetSameValue() {
        assertTrue(Quantity.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeetDifferentValue() {
        assertFalse(Quantity.compareFeet(1.0, 2.0));
    }

    @Test
    void testInchesSameValue() {
        assertTrue(Quantity.compareInches(1.0, 1.0));
    }

    @Test
    void testInchesDifferentValue() {
        assertFalse(Quantity.compareInches(1.0, 2.0));
    }

    @Test
    void testNullComparison() {
        Quantity.Feet f = new Quantity.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testSameReference() {
        Quantity.Inches i = new Quantity.Inches(1.0);
        assertTrue(i.equals(i));
    }

    @Test
    void testNonNumericInput() {
        Quantity.Feet f = new Quantity.Feet(1.0);
        assertFalse(f.equals("Invalid"));
    }
}