
import java.util.Scanner;

public class SubstitutionCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";

        System.out.print("Enter any string: ");
        String str = sc.nextLine();

        String encrypted = "";
        String decrypted = "";

        // Encryption
        for(int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            int j = a.indexOf(ch);

            encrypted = encrypted + b.charAt(j);
        }

        // Decryption
        for(int i = 0; i < encrypted.length(); i++) {

            char ch = encrypted.charAt(i);

            int j = b.indexOf(ch);

            decrypted = decrypted + a.charAt(j);
        }

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);

        sc.close();
    }
}
