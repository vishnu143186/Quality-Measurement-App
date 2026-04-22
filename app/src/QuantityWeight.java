public class QuantityWeight {

    final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new QuantityWeight(converted, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(this, other, this.unit);
    }

    public static QuantityWeight add(QuantityWeight q1, QuantityWeight q2, WeightUnit targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase =
                q1.unit.convertToBaseUnit(q1.value) +
                        q2.unit.convertToBaseUnit(q2.value);

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        return Double.compare(thisBase, otherBase) == 0;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}