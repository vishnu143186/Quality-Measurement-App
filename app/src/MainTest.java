import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private static final double EPS = 1e-6;

    @Test
    void testAddition_TargetUnit_Feet() {
        var f = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var i = new QuantityMeasurementApp.Quantity(12.0, LengthUnit.INCH);

        var result = QuantityMeasurementApp.Quantity.add(f, i, LengthUnit.FEET);

        assertTrue(result.equals(new QuantityMeasurementApp.Quantity(2.0, LengthUnit.FEET)));
    }

    @Test
    void testAddition_TargetUnit_Inches() {
        var f = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var i = new QuantityMeasurementApp.Quantity(12.0, LengthUnit.INCH);

        var result = QuantityMeasurementApp.Quantity.add(f, i, LengthUnit.INCH);

        assertTrue(result.equals(new QuantityMeasurementApp.Quantity(24.0, LengthUnit.INCH)));
    }

    @Test
    void testAddition_TargetUnit_Yards() {
        var f = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var i = new QuantityMeasurementApp.Quantity(12.0, LengthUnit.INCH);

        var result = QuantityMeasurementApp.Quantity.add(f, i, LengthUnit.YARD);

        // Better assertion (numeric instead of string)
        assertEquals(0.666666,
                result.equals(new QuantityMeasurementApp.Quantity(0.666666, LengthUnit.YARD)) ? 0.666666 : 0.0,
                1e-3);
    }

    @Test
    void testAddition_Commutativity_WithTargetUnit() {
        var a = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.Quantity(12.0, LengthUnit.INCH);

        var r1 = QuantityMeasurementApp.Quantity.add(a, b, LengthUnit.YARD);
        var r2 = QuantityMeasurementApp.Quantity.add(b, a, LengthUnit.YARD);

        assertTrue(r1.equals(r2));
    }

    @Test
    void testAddition_NullTargetUnit() {
        var f = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var i = new QuantityMeasurementApp.Quantity(12.0, LengthUnit.INCH);

        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.Quantity.add(f, i, null);
        });
    }
}