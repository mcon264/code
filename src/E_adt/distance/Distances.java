package E_adt.distance;

// contains utility methods for working with distances
public class Distances {
    public void printMilesAndKilometers(Distance distance) {
        IO.println(distance.miles() + "k " + distance.kilometers() + "m");
    }
}
