/*
Build a data entry program that does the following:
    a. Runs in a loop until the user chooses to stop
    b. Allows the user to select what kind of bill they would like to input and then prompts
       them only for attributes needed to construct that kind of bill instance
    c. Creates bill instances and places them in an array or list of type Bill[]
    d. Once the user stops entering data, print out all accumulated Bill instances using their toString() methods
    e. Iterates through all bills and prints the total sum of all bills for the month
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BillTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // user input
        double total = 0;
        System.out.println("""
                What kind of bill would you like to input? Enter an appropriate number.
                0: Mortgage
                1: Credit card
                2: Electric Bill
                -1: Exits program""");
        // array to hold bill instances
        ArrayList<String> bills = new ArrayList<String>();

        // repeatedly input bills; -1 terminates
        int billType = input.nextInt();
        while (billType != -1) {
            switch (billType) {
                case 0:
                    // mortgage
                    System.out.println("Enter the vendor's name, principal, interest, taxes, and insurance.");
                    Mortgage mortgage = new Mortgage(input.next(), input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble());
                    bills.add(mortgage.toString()); // append mortgage item to the list
                    total += total + mortgage.getPaymentAmount(); // add sum of bill to total
                    break;
                case 1:
                    // credit card
                    System.out.println("Enter the vendor's name, charges, and credits.");
                    CreditCard creditCard = new CreditCard(input.next(), input.nextDouble(), input.nextDouble());
                    bills.add(creditCard.toString()); // append credit card item to list
                    total += total + creditCard.getPaymentAmount(); // add sum of bill to total
                    break;
                case 2:
                    // electric bill
                    System.out.println("Enter the vendor's name, base charge, cost per kilowatt-hour(kWh), and number of kWh.");
                    ElectricBill electricBill = new ElectricBill(input.next(), input.nextDouble(), input.nextDouble(), input.nextDouble());
                    bills.add(electricBill.toString()); // append electric bill to list
                    total += total + electricBill.getPaymentAmount(); // add sum of bill to total
                    break;
            }
            System.out.println("""
                What kind of bill would you like to input? Enter an appropriate number.
                0: Mortgage
                1: Credit card
                2: Electric Bill
                -1: Exits program""");
            billType = input.nextInt(); // looping point
        }

        // print out all accumulated Bill instances and total sum of all bills
        System.out.printf("\nAll bill entries:\n" + bills + "\n\nTotal sum of all bills: $%,.2f", total);
    }
}
