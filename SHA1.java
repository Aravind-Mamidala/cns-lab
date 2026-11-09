
import java.util.*;
import java.security.*;

public class SHA {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] hash = md.digest(text.getBytes("UTF-8"));

        StringBuilder hex = new StringBuilder();

        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }

        System.out.println("SHA-1 Hash: " + hex);

        sc.close();
    }
}
