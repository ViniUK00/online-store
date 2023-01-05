/*@author Ervin Bilo 21512979
* Computer Science
* Tutor: Dr. Ikram Ur Rehman
* Online Store
* */

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner object for reading input
        Scanner input = new Scanner(System.in);

        // list of products and prices (following same indexes)
        String[] products = {"Apple", "Banana", "Pineapple", "Kiwi"};
        double[] prices = {0.96, 0.99, 1.99, 0.72};

        // list to keep the quantities we give a length of the products list
        int[] quantities = new int[products.length];
        // total keeps the total amount that we add to the cart
        double total = 0;

        System.out.println("Welcome to Ervin's store. \nOur Local Products: ");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%s - £%.2f\n", products[i], prices[i]); // Format Specifiers (String, 2 decimal places float, next line)
        }
        while (true) {
            // ask the user to choose a product
            System.out.println("Enter the product of your choice you want to buy (or q to exit): ");
            String choice = input.next();

            // if user enters q then loops stops here
            if (Objects.equals(choice, "q")) {
                break;
            }

            // initializing index
            int index = -1;
            // if the product the user entered is in the products list then will give us the index of the same product
            for (int i = 0; i < products.length; i++) {
                if (products[i].equalsIgnoreCase(choice)) {
                    index = i;
                    break;
                }
            }

            // if there is not the product you searched for in the online store then will enter the following if statement
            if (index == -1) {
                System.out.println("No results for " + choice);
                System.out.println("Try checking your spelling");
                continue; // will go back to the top of the while loop
            }

            // ask the user to choose a quantity
            System.out.println("Enter the quantity you want: ");
            int quantity = input.nextInt();

            // adding the price to our total amount
            double currentQuantityPrice = prices[index] * quantity;
            total += currentQuantityPrice;

            // updating the quantities
            quantities[index] += quantity;
        }

        // showing the quantities we have in out cart
        for (int i = 0; i < products.length; i++) {
            if (quantities[i] > 0) {
                System.out.printf("%d %s(s)\n", quantities[i], products[i]); //	(Decimal integer , String, next line)
            }
        }
        // showing the total amount
        System.out.printf("Total amount: £%.2f",total);
    }
}
