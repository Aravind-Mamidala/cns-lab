
import java.util.Scanner;

public class HillCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] key = new int[3][3];
        int[][] inverse = new int[3][3];
        int[][] msg = new int[3][1];
        int[][] result = new int[3][1];
        int[][] decrypt = new int[3][1];

        // Read key matrix
        System.out.println("Enter 3x3 key matrix:");

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                key[i][j] = sc.nextInt();
            }
        }

        // Read message
        System.out.print("Enter 3 letter message: ");
        String str = sc.next();

        for(int i = 0; i < 3; i++) {
            msg[i][0] = str.charAt(i) - 'a';
        }

        // Encryption
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                result[i][0] += key[i][j] * msg[j][0];
            }
            result[i][0] %= 26;
        }

        System.out.print("Encrypted text: ");

        for(int i = 0; i < 3; i++) {
            System.out.print((char)(result[i][0] + 'a'));
        }

        // Find determinant and inverse modulo 26
        int det =
            key[0][0] * (key[1][1]*key[2][2] - key[1][2]*key[2][1])
          - key[0][1] * (key[1][0]*key[2][2] - key[1][2]*key[2][0])
          + key[0][2] * (key[1][0]*key[2][1] - key[1][1]*key[2][0]);

        det = ((det % 26) + 26) % 26;

        int detInv = -1;

        for(int i = 0; i < 26; i++) {
            if((det * i) % 26 == 1) {
                detInv = i;
                break;
            }
        }

        if(detInv == -1) {
            System.out.println("\nKey matrix has no inverse modulo 26.");
            sc.close();
            return;
        }

        // Calculate inverse matrix using cofactors
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                int r1 = (j + 1) % 3;
                int r2 = (j + 2) % 3;
                int c1 = (i + 1) % 3;
                int c2 = (i + 2) % 3;

                int minor = key[r1][c1] * key[r2][c2]
                          - key[r1][c2] * key[r2][c1];

                inverse[i][j] = (detInv * minor) % 26;
                inverse[i][j] = (inverse[i][j] + 26) % 26;
            }
        }

        // Decryption
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                decrypt[i][0] += inverse[i][j] * result[j][0];
            }
            decrypt[i][0] %= 26;
        }

        System.out.print("\nDecrypted text: ");

        for(int i = 0; i < 3; i++) {
            System.out.print((char)(decrypt[i][0] + 'a'));
        }

        sc.close();
    }
}
