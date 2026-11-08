
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read two prime numbers
        System.out.print("Enter first prime number: ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter second prime number: ");
        BigInteger q = sc.nextBigInteger();

        // Calculate n
        BigInteger n = p.multiply(q);

        // Calculate Euler's Totient
        BigInteger phi = p.subtract(BigInteger.ONE)
                .multiply(q.subtract(BigInteger.ONE));

        // Generate public key e
        BigInteger e = BigInteger.valueOf(3);

        while(!e.gcd(phi).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }

        // Generate private key d
        BigInteger d = e.modInverse(phi);

        // Display keys
        System.out.println("Encryption key: " + e + ", " + n);
        System.out.println("Decryption key: " + d + ", " + n);

        sc.close();
    }
}
