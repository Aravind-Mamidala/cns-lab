
import java.security.MessageDigest;

public class SHA1 {

    public static void main(String[] args) throws Exception {

        // Create SHA-1 object
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        // Input message
        String input = "Hello World";

        // Generate message digest
        byte[] digest = md.digest(input.getBytes());

        // Convert digest into hexadecimal
        String result = "";

        for(int i = 0; i < digest.length; i++) {
            result += String.format("%02X", digest[i] & 0xff);
        }

        System.out.println("Original Text: " + input);
        System.out.println("SHA-1 Digest: " + result);
    }
}
