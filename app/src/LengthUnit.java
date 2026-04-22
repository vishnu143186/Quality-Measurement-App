public enum WeightUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(0.0328084);

    private final double toFeetFactor;

    void LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * toFeetFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toFeetFactor;
    }

    public double getConversionFactor() {
        return toFeetFactor;
    }
}
