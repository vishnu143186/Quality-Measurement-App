public class QuantityMeasurementApp {

    public static class Quantity {

        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        // Convert to another unit
        public Quantity convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

            double base = unit.convertToBaseUnit(value);
            double converted = targetUnit.convertFromBaseUnit(base);

            return new Quantity(converted, targetUnit);
        }

        // UC6 (default addition)
        public Quantity add(Quantity other) {
            return add(this, other, this.unit);
        }

        // UC7 (target unit addition)
        public static Quantity add(Quantity q1, Quantity q2, LengthUnit targetUnit) {

            if (q1 == null || q2 == null) {
                throw new IllegalArgumentException("Operands cannot be null");
            }

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double sumBase =
                    q1.unit.convertToBaseUnit(q1.value) +
                            q2.unit.convertToBaseUnit(q2.value);

            double result = targetUnit.convertFromBaseUnit(sumBase);

            return new Quantity(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisBase = unit.convertToBaseUnit(value);
            double otherBase = other.unit.convertToBaseUnit(other.value);

            return Double.compare(thisBase, otherBase) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }
}