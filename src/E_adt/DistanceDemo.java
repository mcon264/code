import E_adt.distance.Distance;
import E_adt.distance.Distances;

void main() {
    Distance d1 = Distance.ofMiles(10);
    IO.println(d1.miles()); // 10.0
    IO.println(d1.kilometers()); // 16.0934

    Distance d2 = Distance.ofKilometers(10);
    Distances.printMilesAndKilometers(d2); // 6.213727366498068m 10.0k

    Distance sum = d1.plus(d2);
    IO.println(sum.miles()); // 16.21372736649807
    IO.println(sum.kilometers()); // 26.093400000000003
}