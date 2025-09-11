void main() {
    IO.println(reverse("slam"));
}

String reverse(String s) {
    if (s.isEmpty()) {
        return s;
    } else {
        return reverse(s.substring(1)) + s.charAt(0);
    }
}