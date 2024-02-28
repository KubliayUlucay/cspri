import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class deneme2 {

    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File("input1.txt");
        Scanner reader = new Scanner(textFile);
        int numTestCases = Integer.parseInt(reader.nextLine()); // that gives us how many times we should run the code

    }
}
