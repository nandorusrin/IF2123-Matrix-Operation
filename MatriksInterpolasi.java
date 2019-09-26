import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class MatriksInterpolasi extends Matriks {
    public MatriksInterpolasi(int _brs, int _kol) {
        super(_brs,_kol);
    }

    // Interpolasi
    public void interpolasi(){
        // proses menghitung interpolasi
        for (int i = 1; i < this.brs; i++) {
            for (int j = 1; j < this.kol; j++) {
                this.data[i][j]= java.lang.Math.pow(this.data[i][j],j-1);
                this.gaussJordan();
            }
        }
    }
}


    