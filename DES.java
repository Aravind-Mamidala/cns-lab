
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class DES {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Generate DES key
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56);
        SecretKey key = kg.generateKey();

        // Read message
        System.out.print("Enter a message: ");
        String msg = sc.nextLine();

        // Encryption
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(msg.getBytes());

        String encryptedText = Base64.getEncoder()
                .encodeToString(encrypted);

        System.out.println("Encrypted text: " + encryptedText);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted text: "
                + new String(decrypted));

        sc.close();
    }
}
