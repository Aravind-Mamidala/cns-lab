// import java.util.*;
// import javax.crypto.*;
// import javax.crypto.spec.*;

// public class RC4 {
//     public static void main(String[] args) throws Exception {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter text:");
//         String s = sc.nextLine();
//         System.out.print("Enter Key:");
//         String key = sc.nextLine();

//         // Create RC4 key
//         SecretKeySpec sk = new SecretKeySpec(key.getBytes(), "RC4");

//         // Encryption
//         Cipher c = Cipher.getInstance("RC4");
//         c.init(Cipher.ENCRYPT_MODE, sk);
//         byte[] enc = c.doFinal(s.getBytes());
//         System.out.println("Encrypted:" + Base64.getEncoder().encodeToString(enc));

//         // Decryption
//         c.init(Cipher.DECRYPT_MODE, sk);
//         byte[] dec = c.doFinal(enc);
//         System.out.println("Decrypted:" + new String(dec));
//         sc.close();
//     }
// }




import java.util.*;
import javax.crypto.*;

public class RC4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = sc.nextLine();

        KeyGenerator kg = KeyGenerator.getInstance("RC4");
        SecretKey key = kg.generateKey();

        Cipher c = Cipher.getInstance("RC4");

        // Encryption
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = c.doFinal(s.getBytes());

        System.out.println("Encrypted: " +
            Base64.getEncoder().encodeToString(enc));

        // Decryption
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = c.doFinal(enc);

        System.out.println("Decrypted: " + new String(dec));

        sc.close();
    }
}
