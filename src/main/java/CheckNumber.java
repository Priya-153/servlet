import java.util.Scanner;
public class CheckNumber {
    // User-defined function
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isNumeric(input)) {
            System.out.println("The string contains only numeric characters.");
        } else {
            System.out.println("The string does NOT contain only numeric characters.");
        }

        sc.close();
    }
}