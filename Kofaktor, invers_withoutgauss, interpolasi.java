import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

// Invers without gauss
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Hasil matriks inversnya adalah: ");
        // proses menghitung invers
        Matriks adjoinMatrix = new Matriks(matrix.getBrs(), matrix.getKol());
        for (int i = 0; i < this.brs; i++) {
            for (int j = 0; j < this.kol; j++) {
                adjoinMatrix.data[i][j] = adjoin(matrix);
                System.out.print(adjoin(matrix)/this.determinant()+"\t");
            }
            System.out.println();
        }
    }
}

// Interpolasi
    public void interpolasi(){
        // proses menghitung interpolasi
        for (int i = 1; i < this.brs; i++) {
            for (int j = 1; j < this.kol; j++) {
                this.data[i][j]= math.pow(this.data[i][j],j-1);
                this.gaussJordan();
            }
        }
    }
*/ 
