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
        system.out.printf("y= ");
        system.out.printf("%.1f ", this.data[i][this.kol]);
        for (int i = 2; i < this.brs; i++){
            if (0!= this.data[i][this.kol]);{
                if (this.data[i][this.kol] >=0){
                    system.out.printf("+");
                }
                system.out.printf("%.1fx^%d ", this.data[i][this.kol], i-1);
            }
        }
        system.out.printf("\n");
    }
}


    
