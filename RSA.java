
// import java.math.BigInteger;
// import java.util.Scanner;

// public class RSA {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         // Read two prime numbers
//         System.out.print("Enter first prime number: ");
//         BigInteger p = sc.nextBigInteger();

//         System.out.print("Enter second prime number: ");
//         BigInteger q = sc.nextBigInteger();

//         // Calculate n
//         BigInteger n = p.multiply(q);

//         // Calculate Euler's Totient
//         BigInteger phi = p.subtract(BigInteger.ONE)
//                 .multiply(q.subtract(BigInteger.ONE));

//         // Generate public key e
//         BigInteger e = BigInteger.valueOf(3);

//         while(!e.gcd(phi).equals(BigInteger.ONE)) {
//             e = e.add(BigInteger.ONE);
//         }

//         // Generate private key d
//         BigInteger d = e.modInverse(phi);

//         // Display keys
//         System.out.println("Encryption key: " + e + ", " + n);
//         System.out.println("Decryption key: " + d + ", " + n);

//         sc.close();
//     }
// }

import javax.crypto.Cipher;
import java.security.*;
import java.util.*;

public class RSA {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        // Generate public and private keys
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
        KeyPair key = keygen.generateKeyPair();

        Cipher cipher = Cipher.getInstance("RSA");

        // Encryption using public key
        cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());
        byte[] encrypted = cipher.doFinal(text.getBytes());

        String en = Base64.getEncoder().encodeToString(encrypted);

        // Decryption using private key
        cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());
        byte[] decrypted = cipher.doFinal(encrypted);

        String de = new String(decrypted);

        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + en);
        System.out.println("Decrypted text: " + de);

        sc.close();
    }
}
