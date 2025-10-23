package E_adt.distance;

public interface Distance {
    /**
     * Constant used for converting between miles and kilometers:
     * <ul>
     *     <li>mi to km: multiply by 1.60934</li>
     *     <li>km to mi: divide by 1.60934</li>
     * </ul>
     */
    double MI_KM_CONVERSION_CONSTANT = 1.60934;

    /**
     * Returns the distance in miles.
     */
    double miles();

    /**
     * Returns the distance in kilometers.
     */
    double kilometers();

    static Distance ofMiles(double miles) {
        return new DistanceM(miles);
        // equally valid: return new DistanceK(miles * MI_KM_CONVERSION_CONSTANT);
    }

    static Distance ofKilometers(double kilometers) {
        return new DistanceK(kilometers);
        // equally valid: return new DistanceM(kilometers / MI_KM_CONVERSION_CONSTANT);
    }

    default Distance plus(Distance other) {
        return ofMiles(this.miles() + other.miles());
        // equally valid: return ofKilometers(this.kilometers() + other.kilometers());
    }
}
