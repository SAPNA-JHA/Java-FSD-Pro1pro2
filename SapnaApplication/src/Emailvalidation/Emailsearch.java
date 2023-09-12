package Emailvalidation;
import java.util.Scanner;

public class Emailsearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Sample array of email IDs
        String[] employeeEmails = {
            "sapna.jha@gmail.com",
            "srishti.jha@gmail.com",
            "shweta.jha@gmail.com",
            "shruti.jha@gmail.com",
            "neha.jha@gmail.com",
            "sahil.jha@gmail.com",
            "samridhi.jha@gmail.com",
            
        };

        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // User input for the email ID to search
        System.out.print("Enter the email ID to search: ");
        String emailToSearch = sc.nextLine();

        // Perform the search
        boolean display = false;
        for (String email : employeeEmails) {
            if (email.equals(emailToSearch)) {
               display = true;
                break;
            }
        }

        // Display the result
        if (display) {
            System.out.println( "valid email");
        } else {
            System.out.println( " invalid email");
        }

        // Close the scanner
        sc.close();
    }
}
