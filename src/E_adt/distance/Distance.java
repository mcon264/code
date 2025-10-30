package E_adt.distance;

/**
 * A measurement of distance.
 */
public interface Distance {
    // a constant (static final field)
    /**
     * Constant used for converting between miles and kilometers:
     * <ul>
     *     <li>mi to km: multiply by 1.60934</li>
     *     <li>km to mi: divide by 1.60934</li>
     * </ul>
     */
    double MI_KM_CONVERSION_CONSTANT = 1.60934;

    // abstract methods
    /**
     * Returns the distance in miles.
     */
    double miles();

    /**
     * Returns the distance in kilometers.
     */
    double kilometers();

    // static methods
    /**
     * Returns a Distance representing the specified number of miles.
     */
    static Distance ofMiles(double miles) {
        return new DistanceM(miles);
        // equally valid: return new DistanceK(miles * MI_KM_CONVERSION_CONSTANT);
    }

    /**
     * Returns a Distance representing the specified number of kilometers.
     */
    static Distance ofKilometers(double kilometers) {
        return new DistanceK(kilometers);
        // equally valid: return new DistanceM(kilometers / MI_KM_CONVERSION_CONSTANT);
    }

    // default method
    /**
     * Returns a Distance representing the sum of this Distance and the provided other Distance.
     */
    default Distance plus(Distance other) {
        return ofMiles(this.miles() + other.miles());
        // equally valid: return ofKilometers(this.kilometers() + other.kilometers());
    }
}
