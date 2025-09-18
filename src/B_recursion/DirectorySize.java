// didn't cover on 9/10

/*
A program that asks the user for the name of a file or directory.
If user enters a file name, prints the size of the file in bytes.
If the user enters a directory name, prints the total size of all
files in that directory, going all the way down to sub-directories, 
sub-sub-directories, etc., as deep as necessary.

File instance methods:
- length()
- isDirectory()
- isFile()
- listFiles()
*/

void main() {
    String name = IO.readln("Enter the name of a directory or file: ");
    File directoryOrFile = new File(name);
    IO.println(computeSize(directoryOrFile) + " bytes");
}

long computeSize(File directoryOrFile) {
    if (!directoryOrFile.isDirectory() && !directoryOrFile.isFile()) {
        throw new IllegalArgumentException("neither a file nor a directory");
    }

    if (directoryOrFile.isFile()) {
        return directoryOrFile.length();
    } else { // directoryOrFile.isDirectory()
        File[] children = directoryOrFile.listFiles();
        long size = 0;

        for (File child : children) {
            size += computeSize(child); // recursive call
        }

        return size;
    }
}