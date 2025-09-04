package A_intro;

import java.util.Objects;

public class ArrayUtils {
    // a Javadoc comment
    /**
     * Returns the maximum element of an array.
     * @param a an array
     * @return the max
     * @throws NullPointerException if a is null
     * @throws IllegalArgumentException if a is empty
     */
    public static double max(double[] a) {
        // This method has two preconditions (something that needs to be true in order for the method to work properly):
        // a != null, and a.length > 0
        // We can enforce them by throwing exceptions if the caller violates them.

        // if (a == null) {
        //     throw new NullPointerException("array is null");
        // }
        // equivalently:
        Objects.requireNonNull(a, "array is null");

        if (a.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }

        double maxSoFar = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxSoFar) {
                maxSoFar = a[i];
            }
        }

        return maxSoFar;
    }
}