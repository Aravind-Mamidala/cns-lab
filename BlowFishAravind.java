import java.util.*;
import javax.crypto.*;

public class Blowfish {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text:");
        String s = sc.nextLine();

        // Generate Blowfish key
        KeyGenerator kg = KeyGenerator.getInstance("Blowfish");
        SecretKey key = kg.generateKey();

        // Encryption
        Cipher c = Cipher.getInstance("Blowfish");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = c.doFinal(s.getBytes());
        System.out.println("Encrypted:" + Base64.getEncoder().encodeToString(enc));

        // Decryption
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = c.doFinal(enc);

        System.out.println("Decrypted:" + new String(dec));
        sc.close();
    }
}
