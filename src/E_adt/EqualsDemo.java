package E_adt;

import java.util.Objects;

class PersonWithNoEquals {
    private String name;
    private int age;

    public PersonWithNoEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class PersonWithOverloadedEquals {
    private String name;
    private int age;

    public PersonWithOverloadedEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 232 style (but not really correct)
    public boolean equals(PersonWithOverloadedEquals other) {
        return this.name.equals(other.name) && this.age == other.age;
    }
}

class PersonWithOverriddenEquals {
    private String name;
    private int age;

    public PersonWithOverriddenEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        // return this.name.equals(o.name) && this.age == o.age;
        // doesn't compile, since Object doesn't have fields called name and age

        // PersonWithOverriddenEquals other = (PersonWithOverriddenEquals) o;
        // return this.name.equals(other.name) && this.age == other.age;
        // with the cast, it compiles, and it runs well in many cases, but may
        // have a ClassCastException

        // the following works
        // if (o instanceof PersonWithOverriddenEquals) {
        //     PersonWithOverriddenEquals other = (PersonWithOverriddenEquals) o;
        //     return this.name.equals(other.name) && this.age == other.age;
        // } else {
        //     return false;
        // }

        // nowadays, we can combine the test and the cast:
        return o instanceof PersonWithOverriddenEquals other
                && this.name.equals(other.name) && this.age == other.age;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Person other && this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public int hashCode() {
        // return 42; // legal approach, but not useful

        // good approach:
        return Objects.hash(name, age);
        // When we use Objects.hash(...), we are guaranteed to have equal hash codes
        // for equal objects. Additionally, it is very, very likely that unequal objects
        // with have unequal hash codes, but this cannot be guaranteed (because there are
        // more possible objects than there are ints.)
    }
}

public class EqualsDemo {
    static void main() {
        PersonWithNoEquals p1 = new PersonWithNoEquals("John", 25);
        PersonWithNoEquals p2 = new PersonWithNoEquals("John", 25);
        IO.println(p1 == p2); // false
        IO.println(p1.equals(p2)); // false
        // PersonWithNoEquals inherits Object's equals method.
        // That method does not compare the contents of two objects.
        // It's just like asking whether p1 == p2, which is false.

        PersonWithOverloadedEquals p3 = new PersonWithOverloadedEquals("John", 25);
        PersonWithOverloadedEquals p4 = new PersonWithOverloadedEquals("John", 25);
        IO.println(p3.equals(p4)); // true, calls our equals method
        Object p5 = new PersonWithOverloadedEquals("John", 25);
        IO.println(p3.equals(p5)); // false, calls Object's equals method

        PersonWithOverriddenEquals p6 = new PersonWithOverriddenEquals("John", 25);
        Object p7 = new PersonWithOverriddenEquals("John", 25);
        IO.println(p6.equals(p7)); // true, calls our equals method
        PersonWithOverriddenEquals p8 = new PersonWithOverriddenEquals("John", 25);
        IO.println(p6.equals(p8)); // true, calls our method

        IO.println(p6.hashCode()); // some integer
        IO.println(p7.hashCode()); // some other integer (almost certainly)
        IO.println(p8.hashCode()); // yet another integer (almost certainly)

        Person p9 = new Person("John", 25);
        Object p10 = new Person("John", 25);
        IO.println(p9.hashCode());
        IO.println(p10.hashCode()); // p9 and p10 definitely have the same hash code
        Person p11 = new Person("Jane", 25);
        IO.println(p11.hashCode()); // p11 will almost certainly have a different hash code
    }
}
/*
When we write a class that inherits a method with some requirements, we must make sure
that our class does not violate the inherited requirements.
The Object class has, in addition to toString and equals, a method named hashCode().
This method returns an integer that is associated with the object it was called on.
The version of this method in Object returns distinct integers for distinct objects.
The specification of the hashCode() method states: if o1.equals(o2), then we must make
sure that o1.hashCode() == o2.hashCode(). If we override equals, thus making distict
objects considered equal, we are in violation hashCode()'s requirement, unless we also
override hashCode(). Bottom line: if you override equals, you almost certainly have to
override hashCode() as well.

How to override hashCode()? We could just have it always return the same int, say 42.
That is legal, as there is no requirement that unequal object have unequal hash codes.
But this approach leads to slow performance of HashSet and HashMap.
The best approach is to create an int based on the fields. Doing this yourself is not
easy, but there's a shortcut: Objects.hash(...)
 */
