import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeightTest {

    private static final double EPS = 1e-6;

    @Test
    void testEquality_KgToGram() {
        var kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var g = new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(g));
    }

    @Test
    void testConversion_KgToPound() {
        var kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        var result = kg.convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.convertTo(WeightUnit.POUND).convertTo(WeightUnit.POUND).value, 1e-3);
    }

    @Test
    void testAddition_KgPlusGram() {
        var kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var g = new QuantityWeight(1000.0, WeightUnit.GRAM);

        var result = kg.add(g);

        assertTrue(result.equals(new QuantityWeight(2.0, WeightUnit.KILOGRAM)));
    }

    @Test
    void testAddition_TargetUnit_Gram() {
        var kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var g = new QuantityWeight(1000.0, WeightUnit.GRAM);

        var result = QuantityWeight.add(kg, g, WeightUnit.GRAM);

        assertTrue(result.equals(new QuantityWeight(2000.0, WeightUnit.GRAM)));
    }

    @Test
    void testWeightVsLength_NotEqual() {
        var weight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var length = new QuantityMeasurementApp.Quantity(1.0, LengthUnit.FEET);

        assertFalse(weight.equals(length));
    }
}