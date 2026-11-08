
import java.util.Scanner;

public class DiffieHellman {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Public values
        int p = 23;
        int g = 5;

        // Private keys
        System.out.print("Enter Alice's private key: ");
        int a = sc.nextInt();

        System.out.print("Enter Bob's private key: ");
        int b = sc.nextInt();

        // Alice's public key
        int A = (int)Math.pow(g, a) % p;

        // Bob's public key
        int B = (int)Math.pow(g, b) % p;

        // Generate shared secret keys
        int keyA = (int)Math.pow(B, a) % p;

        int keyB = (int)Math.pow(A, b) % p;

        System.out.println("Alice's public key: " + A);
        System.out.println("Bob's public key: " + B);

        System.out.println("Alice's shared key: " + keyA);
        System.out.println("Bob's shared key: " + keyB);

        sc.close();
    }
}
