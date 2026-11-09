
import java.util.*;
import java.security.*;

public class MD5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] hash = md.digest(text.getBytes("UTF-8"));

        StringBuilder hex = new StringBuilder();

        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }

        System.out.println("MD5 Hash: " + hex);

        sc.close();
    }
}
