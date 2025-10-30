package E_adt.distance;

// contains a utility method for working with distances
public class Distances {
    public static void printMilesAndKilometers(Distance distance) {
        IO.println(distance.miles() + "m " + distance.kilometers() + "k");
    }
}
