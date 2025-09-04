// JEP 512: https://openjdk.org/jeps/512
// IO doc: https://download.java.net/java/early_access/jdk25/docs/api/java.base/java/lang/IO.html

void main() {
    String name = IO.readln("name: ");
    printGreeting(name);
}

void printGreeting(String name) {
    IO.println("Hello, " + name + "!");
}