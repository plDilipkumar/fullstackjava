
import java.io.*;

// Custom Exception
class AgeException extends Exception {
    AgeException(String msg) {
        super(msg);
    }
}

public class example {
    public static void main(String[] args) {
        // Unchecked Exception Example (ArithmeticException)
        try {
            int a = 10 / 0;
            
        } catch (ArithmeticException e) {
            System.out.println("Unchecked Exception caught: " + e);
        }

        // Checked Exception Example (FileNotFoundException)
        try (FileReader fr = new FileReader("test.txt")) { // File may not exist
            // Read one character to use the variable
            int data = fr.read();
            System.out.println("First character read (as int): " + data);
        } catch (FileNotFoundException e) {
            System.out.println("Checked Exception caught: " + e);
        } catch (IOException e) {
            System.out.println("IO Exception caught: " + e);
        }

        // Using throw with custom exception
        try {
            checkAge(15);
        } catch (AgeException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
    }

    // throws custom checked exception
    static void checkAge(int age) throws AgeException {
        if(age < 18)
            throw new AgeException("Not eligible to vote");
        else
            System.out.println("Eligible to vote");
    }
}
