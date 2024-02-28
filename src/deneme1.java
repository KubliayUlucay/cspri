import List.LinkedList;
import List.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class deneme1 {
    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File("input1.txt");
        Scanner reader = new Scanner(textFile);
        int numTestCases = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < numTestCases; i++) {
            char operator = reader.next().charAt(0);
            String poly1 = reader.next();
            String poly2 = reader.next();

            LinkedList temp1;
            LinkedList temp2;
            // Process the polynomials and show them in the linked list
            convertToLinkedList (poly1);
            convertToLinkedList(poly2);

//            // Display the linked lists for verification
//            System.out.println("Polynomial 1:");
//           // polyList1.display();
//            System.out.println("Polynomial 2:");
//            //polyList2.display();
        }

        reader.close();
    }

    private static void convertToLinkedList(String polynomial) {
        int numPolynomials = polynomial.split("\\+").length;




        String[] terms = polynomial.split("\\+|-");
        for (int i = 0; i < numPolynomials; i++) {
            LinkedList a = createNodeFromTerm(terms[i]);
            System.out.println(a);
        }

    }

    private static LinkedList createNodeFromTerm(String term) {
        int coefficient = 0;
        int exponentX = 0;
        int exponentY = 0;
        int exponentZ = 0;

        // Split the term into coefficient and factors
        String[] factors = term.split("(?=[xyz])");
        for (String factor : factors) {
            if (!factor.isEmpty()) {
                char variable = factor.charAt(0);
                int exponent = 1;
                if (factor.length() > 1) {
                    exponent = Integer.parseInt(factor.substring(1));
                }

                switch (variable) {
                    case 'x':
                        exponentX = exponent;
                        break;
                    case 'y':
                        exponentY = exponent;
                        break;
                    case 'z':
                        exponentZ = exponent;
                        break;
                    default:
                        // If no variable, it's the coefficient
                        coefficient = Integer.parseInt(factor);
                        break;
                }
            }
        }

        LinkedList result = new LinkedList();
        result.insertLast(new Node(coefficient));
        result.insertLast(new Node(exponentX));
        result.insertLast(new Node(exponentY));
        result.insertLast(new Node(exponentZ));

        return result;
    }
}