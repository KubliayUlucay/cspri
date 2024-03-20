import List.Polynomial.Polynomial;
import List.Polynomial.Term;
import List.Polynomial.TermNode;
import List.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class deneme4 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input1.txt");
        File outputFile = new File("output1.txt");

        Scanner scanner = new Scanner(inputFile);
        FileWriter writer = new FileWriter(outputFile);

        int numTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after reading the number of test cases

        for (int i = 0; i < numTestCases; i++) {
            char operator = scanner.next().charAt(0);
            String expression1 = scanner.next();
            String expression2 = scanner.nextLine().trim(); // Read the rest of the line

            Polynomial polynomial1 = parsePolynomial(expression1);
            Polynomial polynomial2 = parsePolynomial(expression2);

            Polynomial result;
            switch (operator) {
                case '+':
                    result = polynomial1.add(polynomial2);
                    break;
                case '-':
                    Polynomial negatedPoly2 = negatePolynomial(polynomial2);
                    result = polynomial1.add(negatedPoly2);
                    break;
                case '*':
                    result = polynomial1.multiply(polynomial2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }

            writer.write(result.toString() + "\n");
        }

        scanner.close();
        writer.close();
    }

    private static Polynomial parsePolynomial(String expression) {
        Polynomial polynomial = new Polynomial();
        String[] terms = expression.split("[+]");

        for (String term : terms) {
            TermNode termNode = parseTerm(term.trim());
            polynomial.insertLast(termNode);
        }

        return polynomial;
    }

    private static TermNode parseTerm(String term) {
        // Example term: 5x3y2

        // Initialize coefficients and exponents
        int coefficient = 1;  // Default coefficient is 1
        int exponentX = 0;
        int exponentY = 0;
        int exponentZ = 0;

        // Split the term based on individual variables
        String[] parts = term.split("x|y|z");

        // Process each part to determine coefficient and exponent
        for (String part : parts) {
            if (!part.isEmpty()) {
                if (Character.isDigit(part.charAt(0))) {
                    // If the part starts with a digit, it's a coefficient
                    coefficient *= Integer.parseInt(part);
                } else {
                    // If the part does not start with a digit, it's a variable, determine its exponent
                    if (part.contains("x")) {
                        exponentX = getExponent(part);
                    } else if (part.contains("y")) {
                        exponentY = getExponent(part);
                    } else if (part.contains("z")) {
                        exponentZ = getExponent(part);
                    }
                }
            }
        }

        return new TermNode(new Term(coefficient, exponentX, exponentY, exponentZ));
    }

    // Helper method to get the exponent from a variable part
    private static int getExponent(String part) {
        return part.length() == 1 ? 1 : Integer.parseInt(part.substring(1));
    }

    private static Polynomial negatePolynomial(Polynomial polynomial) {
        Polynomial negatedPoly = new Polynomial();

        TermNode current = polynomial.getHead();
        while (current != null) {
            int negatedCoefficient = -current.getData().getCoefficient();
            negatedPoly.insertLast(new TermNode(new Term(negatedCoefficient, current.getData().getDegree())));
            current = current.getNext();
        }

        return negatedPoly;
    }
}