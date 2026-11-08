
import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        String encrypted = "";
        String decrypted = "";

        // Encryption
        for(int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + key % 26);

                if(ch > 'Z')
                    ch -= 26;
            }
            else if(ch >= 'a' && ch <= 'z') {
                ch = (char)(ch + key % 26);

                if(ch > 'z')
                    ch -= 26;
            }

            encrypted += ch;
        }

        // Decryption
        for(int i = 0; i < encrypted.length(); i++) {

            char ch = encrypted.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch - key % 26);

                if(ch < 'A')
                    ch += 26;
            }
            else if(ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - key % 26);

                if(ch < 'a')
                    ch += 26;
            }

            decrypted += ch;
        }

        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);

        sc.close();
    }
}
