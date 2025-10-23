import E_adt.distance.Distance;

void main() {
    Distance d1 = Distance.ofMiles(10);
    IO.println(d1.miles()); // 10.0
    IO.println(d1.kilometers()); // ...

    Distance d2 = Distance.ofKilometers(10);

    Distance sum = d1.plus(d2);
}