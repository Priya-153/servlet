
import java.util.Scanner;
public class TurncateString {


    // User-defined function
    public static String truncate(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength) + "...";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.print("Enter max length: ");
        int length = sc.nextInt();

        String result = truncate(input, length);
        System.out.println("Truncated string: " + result);

        sc.close();
    }
}