
// import java.util.Scanner;

// public class CaesarCipher {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter a string: ");
//         String str = sc.nextLine();

//         System.out.print("Enter the key: ");
//         int key = sc.nextInt();

//         String encrypted = "";
//         String decrypted = "";

//         // Encryption
//         for(int i = 0; i < str.length(); i++) {

//             char ch = str.charAt(i);

//             if(ch >= 'A' && ch <= 'Z') {
//                 ch = (char)(ch + key % 26);

//                 if(ch > 'Z')
//                     ch -= 26;
//             }
//             else if(ch >= 'a' && ch <= 'z') {
//                 ch = (char)(ch + key % 26);

//                 if(ch > 'z')
//                     ch -= 26;
//             }

//             encrypted += ch;
//         }

//         // Decryption
//         for(int i = 0; i < encrypted.length(); i++) {

//             char ch = encrypted.charAt(i);

//             if(ch >= 'A' && ch <= 'Z') {
//                 ch = (char)(ch - key % 26);

//                 if(ch < 'A')
//                     ch += 26;
//             }
//             else if(ch >= 'a' && ch <= 'z') {
//                 ch = (char)(ch - key % 26);

//                 if(ch < 'a')
//                     ch += 26;
//             }

//             decrypted += ch;
//         }

//         System.out.println("Encrypted text: " + encrypted);
//         System.out.println("Decrypted text: " + decrypted);

//         sc.close();
//     }
// }



import java.util.*;

public class Caesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = sc.nextLine();

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        String enc = "";

        // Encryption
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z')
                enc += (char)((ch - 'a' + key) % 26 + 'a');
            else if (ch >= 'A' && ch <= 'Z')
                enc += (char)((ch - 'A' + key) % 26 + 'A');
            else
                enc += ch;
        }

        System.out.println("Encrypted: " + enc);

        String dec = "";

        // Decryption
        for (int i = 0; i < enc.length(); i++) {
            char ch = enc.charAt(i);

            if (ch >= 'a' && ch <= 'z')
                dec += (char)((ch - 'a' - key + 26) % 26 + 'a');
            else if (ch >= 'A' && ch <= 'Z')
                dec += (char)((ch - 'A' - key + 26) % 26 + 'A');
            else
                dec += ch;
        }

        System.out.println("Decrypted: " + dec);

        sc.close();
    }
}
