package E_adt.distance;

public record DistanceK(double kilometers) implements Distance {
    @Override
    public double miles() {
        return kilometers / MI_KM_CONVERSION_CONSTANT;
    }
}
