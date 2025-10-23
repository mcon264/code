package E_adt.distance;

public record DistanceM(double miles) implements Distance {
    @Override
    public double kilometers() {
        return miles * MI_KM_CONVERSION_CONSTANT;
    }
}
