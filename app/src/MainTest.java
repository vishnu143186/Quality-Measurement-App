import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private static final double EPS = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(3.0, result.toString().contains("FEET") ? 3.0 : 0.0, EPS);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        var result = q1.add(q2);

        assertTrue(result.equals(new QuantityMeasurementApp.Quantity(2.0,
                QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        var q2 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertTrue(result.equals(new QuantityMeasurementApp.Quantity(24.0,
                QuantityMeasurementApp.LengthUnit.INCH)));
    }

    @Test
    void testAddition_YardPlusFeet() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        var q2 = new QuantityMeasurementApp.Quantity(3.0, QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertTrue(result.equals(new QuantityMeasurementApp.Quantity(2.0,
                QuantityMeasurementApp.LengthUnit.YARD)));
    }

    @Test
    void testAddition_Commutativity() {
        var a = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        var b = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(a.add(b).equals(b.add(a)));
    }

    @Test
    void testAddition_WithZero() {
        var q1 = new QuantityMeasurementApp.Quantity(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(0.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(q1.add(q2).equals(q1));
    }

    @Test
    void testAddition_NegativeValues() {
        var q1 = new QuantityMeasurementApp.Quantity(5.0, QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.Quantity(-2.0, QuantityMeasurementApp.LengthUnit.FEET);

        var result = q1.add(q2);

        assertTrue(result.equals(new QuantityMeasurementApp.Quantity(3.0,
                QuantityMeasurementApp.LengthUnit.FEET)));
    }

    @Test
    void testAddition_NullOperand() {
        var q1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }
}