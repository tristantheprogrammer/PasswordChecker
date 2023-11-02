import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        int categoryCount = 0;

        if (password.matches(".*[a-z].*")) {
            categoryCount++;
        }

        if (password.matches(".*[A-Z].*")) {
            categoryCount++;
        }

        if (password.matches(".*[0-9].*")) {
            categoryCount++;
        }

        Pattern pattern = Pattern.compile(".*[~!@#$%^&*()\\-=+_].*");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            categoryCount++;
        }

        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        boolean isValid = isValidPassword(password);
        if (isValid) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }

        scanner.close();
    }
}
