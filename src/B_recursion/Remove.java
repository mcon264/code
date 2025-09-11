void main() {
    String original = "xabxc";
    String result = remove('x', original);
    IO.println(result); // abc

    IO.println(remove('y', "yyy")); // nothing is printed here
}

/*
remove('x', "xabxc")
= remove('x',  "abxc")
= 'a' + remove('x', "bxc")
= 'a' + ('b' + remove('x', "xc"))
= 'a' + ('b' + remove('x', "c"))
= 'a' + ('b' + ('c' + remove('x', "")))
= 'a' + ('b' + ('c' + ""))
= 'a' + ('b' + "c")
= 'a' + "bc"
= "abc"
*/

// returns a String that is the same as s
// but with all occurrences of ch removed
String remove(char ch, String s) {
    if (s.isEmpty()) {
        return s;
    } else if (s.charAt(0) == ch) {
        // disregard first char, and recursively
        // remove ch from rest of s
        return remove(ch, s.substring(1));
    } else { // the first char is not ch
        // keep the first char, and recursively
        // remove ch from rest of s
        return s.charAt(0) + remove(ch, s.substring(1));
    }
}