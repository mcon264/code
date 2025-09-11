/*
A successful recursive method has the following:
- a case or cases where no recursion is performed,
  thus allowing the process to eventually end
- a recursive case (or cases) *that eventually
  lead to the base case(s)*
 */

// the first two methods will cause a
// StackOverflowError.
// the last two will not

void main() {
    // forever("hi");

    // forever2("hello");

    notForever("hello");

    alsoNotForever("hello");
}

// this method has no base case
void forever(String s) {
    IO.println(s);
    forever(s);
}

// this method has a base case, but the
// recursive case does not ensure that we
// will eventually reach the base case
void forever2(String s) {
    if (s.isEmpty()) {
        return;
    } else {
        IO.println(s);
        forever2(s);
    }
}

// this method has a base case,
// and has a recursive case that ensures
// that the base case will eventually be reached
void notForever(String s) {
    if (s.isEmpty()) {
        return;
    } else {
        IO.println(s);
        notForever(s.substring(1));
    }
}

// this method has an implicit base case:
// if s.isEmpty(), nothing will happen,
// and the recursive process will be able to end
void alsoNotForever(String s) {
    if (!s.isEmpty()) {
        IO.println(s);
        alsoNotForever(s.substring(1));
    }
}