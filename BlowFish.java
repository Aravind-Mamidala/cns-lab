
import java.io.*;
import java.security.Key;
import javax.crypto.*;
import java.util.Base64;

public class BlowFish {

    public static void main(String[] args) throws Exception {

        // Generate secret key
        KeyGenerator kg = KeyGenerator.getInstance("Blowfish");
        kg.init(128);
        Key key = kg.generateKey();

        // Create cipher
        Cipher cipher = Cipher.getInstance("Blowfish/CFB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Display input file contents
        System.out.println("Input File Contents:");

        FileInputStream fin = new FileInputStream("inputFile.txt");

        int data;

        while ((data = fin.read()) != -1) {
            System.out.print((char)data);
        }

        fin.close();

        // Encrypt input file
        fin = new FileInputStream("inputFile.txt");
        

        FileOutputStream fout = new FileOutputStream("outputFile.txt");
        CipherOutputStream cout = new CipherOutputStream(fout, cipher);

        while ((data = fin.read()) != -1) {
            cout.write(data);
        }

        fin.close();
        cout.close();

        // Display IV
        System.out.println("\n\nInitialization Vector: "
                + Base64.getEncoder().encodeToString(cipher.getIV()));

        // Display output file contents
        System.out.println("\nOutput File Contents:");

        FileInputStream result = new FileInputStream("outputFile.txt");

        while ((data = result.read()) != -1) {
            System.out.print((char)data);
        }

        result.close();
    }
}
