import List.Polynomial.Polynomial;
import List.Polynomial.Term;
import List.Polynomial.TermNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class deneme3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input1.txt"));
        FileWriter writer = new FileWriter("output1.txt");

        int numTestCases = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < numTestCases; i++) {
            String[] testCase = reader.readLine().split(" ");
            char operator = testCase[0].charAt(0);

            String[] polynomials = new String[2];
            polynomials[0] = testCase[1];
            polynomials[1] = testCase[2];

            Polynomial[] polynomialLinkedLists = new Polynomial[2];

            for (int j = 0; j < 2; j++) {
                polynomialLinkedLists[j] = createPolynomialLinkedList(polynomials[j]);
            }

            // Displaying the linked lists for each polynomial (optional)
            for (int j = 0; j < 2; j++) {
                System.out.println("Linked List for Polynomial " + (j + 1) + ": " + polynomialLinkedLists[j]);
            }

            // TODO: Implement addition, subtraction, and multiplication operations
            Polynomial result = performOperation(operator, polynomialLinkedLists[0], polynomialLinkedLists[1]);

            // Writing the result to the output file
            writer.write(result.toString());
            writer.write("\n");
        }

        reader.close();
        writer.close();
    }

    private static Polynomial createPolynomialLinkedList(String polynomial) {
        Polynomial linkedList = new Polynomial();

        String[] terms = polynomial.split("[+-]");
        for (String term : terms) {
            linkedList.insertLast(createTermNode(term));
        }

        return linkedList;
    }

    private static TermNode createTermNode(String term) {
        int coefficient = 1;
        int exponentX = 0;
        int exponentY = 0;
        int exponentZ = 0;

        String[] factors = term.split("[xyz]");
        for (String factor : factors) {
            if (!factor.isEmpty()) {
                if (factor.equals("-")) {
                    coefficient = -1;
                } else if (factor.equals("+")) {
                    coefficient = 1;
                } else {
                    coefficient *= Integer.parseInt(factor);
                }
            }
        }

        if (term.contains("x")) {
            exponentX = getExponent(term, "x");
        }
        if (term.contains("y")) {
            exponentY = getExponent(term, "y");
        }
        if (term.contains("z")) {
            exponentZ = getExponent(term, "z");
        }

        Term term1 = new Term(coefficient, exponentX, exponentY, exponentZ);
        return new TermNode(term1);
    }

    private static int getExponent(String term, String variable) {
        int index = term.indexOf(variable);
        if (index + 1 < term.length() && Character.isDigit(term.charAt(index + 1))) {
            return Integer.parseInt(term.substring(index + 1));
        }
        return 1;
    }

    private static Polynomial performOperation(char operator, Polynomial poly1, Polynomial poly2) {
        // TODO: Implement addition, subtraction, and multiplication operations
        // Placeholder implementation (you need to complete this part)
        return poly1;
    }
}
