import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Matriks {
	public double[][] data;
	protected int brs, kol;

	public Matriks(int _brs, int _kol) {
		this.brs = _brs;
		this.kol = _kol;
		data = new double[_brs+2][_kol+2];
	}

	public Matriks(double[][] n_data, int _brs, int _kol) {
		this.data = n_data;
		this.brs = _brs;
		this.kol = _kol;
	}

	public int getBrs() {
		return this.brs;
	}

	public int getKol(){
		return this.kol;
	}

	public void bacaMatriks() {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= this.brs; i++) {
			for (int j = 1; j <= this.kol; j++) {
				this.data[i][j] = scan.nextDouble();
			}
		}
	}

	public void printMatriks() {
		for (int i = 1; i <= this.brs; i++) {
			for (int j = 1; j <= this.kol; j++) {
				System.out.printf("%f ", this.data[i][j]);
			}
			System.out.println();
		}
	}

	public void kaliBaris(int nBrs, double k) {
		if (nBrs < 1 || nBrs > this.brs) {
			System.out.println("Masukan baris tidak valid");
		} else {
			if (k == 0){
				System.out.println("Masukan constant tidak valid");
			} else {
				for (int i = 1; i <= this.kol; i++) {
					this.data[nBrs][i] *= k;
				}
			}
		}
	}

	public void tukarBaris(int nBrs1, int nBrs2) {
		if (nBrs1 < 1 || nBrs1 > this.brs) {
			System.out.println("Masukan baris1 tidak valid");
		} else if (nBrs2 < 1 || nBrs2 > this.brs) {
			System.out.println("Masukan baris2 tidak valid");
		} else {
			for (int i = 1; i <= this.kol; i++) {
				double temp = this.data[nBrs1][i];
				this.data[nBrs1][i] = this.data[nBrs2][i];
				this.data[nBrs2][i] = temp;
			}
		}
	}

	public void tambahBaris(int nBrs1, int nBrs2, double k) {
		if (nBrs1 < 1 || nBrs1 > this.brs) {
			System.out.println("Masukan baris1 tidak valid");
		} else if (nBrs2 < 1 || nBrs2 > this.brs) {
			System.out.println("Masukan baris2 tidak valid");
		} else {
			for (int i = 1; i <= this.kol; i++) {
				this.data[nBrs1][i] += (this.data[nBrs2][i] * k);
			}
		}
	}

}