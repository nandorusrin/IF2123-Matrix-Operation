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
		for (int i = 1; i < this.brs; i++) {
			for (int j = 1; i < this.kol; i++) {
				data[i][j] = 0;
			}
		}
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

	public int getFirstIndeks(int nBrs) {
		//return indeks kolom tidak nol pertama
		boolean found = false;
		int i = 1;
		while ((i <= this.kol) && !found) {
			if (this.data[nBrs][i] != 0) {
				found = true;
			} else {
				i++;
			}
		}
		if (found) {
			return i;
		} else {
			return this.kol;
		}
	}

	public void sortMatriks() {
		int i, j;
		if (this.brs > 1) {
			for (i = 1; i < this.brs; i++) {
				int brsMax = i;
				for (j = i + 1; j <= this.brs; j++) {
					int tempMax = this.getFirstIndeks(j);
					if (tempMax < this.getFirstIndeks(brsMax)) {
						brsMax = j;
					}
				}
				this.tukarBaris(i, brsMax);
			}
		}
	}

	public boolean isBrsKosong(int nBrs) {
		int i = 1;
		while ((this.data[nBrs][i] == 0) && i < this.kol) {
			i++;
		}
		if (this.data[nBrs][i] == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void gaussForm() {
		this.sortMatriks();
		for (int i = 1; i <= this.brs; i++) {
			if (!this.isBrsKosong(i)) {
				int idxFirst = this.getFirstIndeks(i);
				double firstCoef = this.data[i][idxFirst];
				for (int j = i + 1; j <= this.brs; j++) {
					if (!this.isBrsKosong(j)) {
						double k = (-1) * this.data[j][idxFirst] / firstCoef;
						this.tambahBaris(j, i, k);
					}
					this.data[j][idxFirst] = 0;
				}
			}
		}
		for (int i = 1; i <= this.brs; i++) {
			if (!this.isBrsKosong(i)) {
				int idxBrs = this.getFirstIndeks(i);
				double firstCoef = this.data[i][idxBrs];
				this.kaliBaris(i, (1 / firstCoef));
			}
		}
	}

	public void gaussJordan() {
		this.gaussForm();
		for (int i = this.brs; i > 1; i--) {
			if(!this.isBrsKosong(i)) {
				int idxFirst = this.getFirstIndeks(i);
				for (int j = i - 1; j >= 1; j--) {
					if (!this.isBrsKosong(j)) {
						double k = (-1) * this.data[j][idxFirst];
						this.tambahBaris(j, i, k);
					}
				}
			}
		}
	}

	public void inversOBE() {
		Matriks Inv;
		Inv = new Matriks(this.brs, this.kol);
		for (int i = 1; i <= this.brs; i++) {
			Inv.data[i][i] = 1;
		}
		Inv.printMatriks();
		//sort
		if (this.brs > 1) {
			for (int i = 1; i < this.brs; i++) {
				int brsMax = i;
				for (int j = i + 1; j <= this.brs; j++) {
					int tempMax = this.getFirstIndeks(j);
					if (tempMax < this.getFirstIndeks(brsMax)) {
						brsMax = j;
					}
				}
				this.tukarBaris(i, brsMax);
				Inv.tukarBaris(i, brsMax);
			}
		}
		//gauss
		for (int i = 1; i <= this.brs; i++) {
			if (!this.isBrsKosong(i)) {
				int idxFirst = this.getFirstIndeks(i);
				double firstCoef = this.data[i][idxFirst];
				for (int j = i + 1; j <= this.brs; j++) {
					if (!this.isBrsKosong(j)) {
						double k = (-1) * this.data[j][idxFirst] / firstCoef;
						System.out.println(k);
						this.tambahBaris(j, i, k);
						Inv.tambahBaris(j, i, k);
					}
					this.data[j][idxFirst] = 0;
				}
			}
			System.out.println("step gauss");
			this.printMatriks();
			System.out.println("invers");
			Inv.printMatriks();
		}
		for (int i = 1; i <= this.brs; i++) {
			if (!this.isBrsKosong(i)) {
				int idxBrs = this.getFirstIndeks(i);
				double firstCoef = this.data[i][idxBrs];
				this.kaliBaris(i, (1 / firstCoef));
				Inv.kaliBaris(i, (1 / firstCoef));
			}
			System.out.println("step gauss2");
			this.printMatriks();
			System.out.println("invers");
			Inv.printMatriks();
		}
		//gaussjordan
		for (int i = this.brs; i > 1; i--) {
			if(!this.isBrsKosong(i)) {
				int idxFirst = this.getFirstIndeks(i);
				for (int j = i - 1; j >= 1; j--) {
					if (!this.isBrsKosong(j)) {
						double k = (-1) * this.data[j][idxFirst];
						this.tambahBaris(j, i, k);
						Inv.tambahBaris(j, i, k);
					}
				}
			}
		}
		System.out.println("step gaussJordan");
		this.printMatriks();
		System.out.println("invers");
		Inv.printMatriks();
		this.data = Inv.data;
	}

	public double determinant() {
		double hasil = 1;
		this.gaussJordan();
		for (int i = 1; i <= this.brs; i++) {
				hasil *= this.data[i][i];
			}
		return hasil;
	}

    /**
     * Mencari determinan dari sebuah matriks dengan metode Laplace Expansion.
     * 
     * @return Mengembalikan nilai determinan.
     *         Jika matriks bukan matriks persegi (NxN) maka mengembalikan Double.NaN.
     */
    public double determinantLaplaceExpansion() {
        if (this.getKol() != this.getBrs()) {
            return Double.NaN;
        }

        if (this.getKol() == 1 && this.getBrs() == 1) {
            return this.data[1][1];
        }

        double result = 0;

        // menggunakan kolom 1
        for (int i = 1; i <= this.getBrs(); i++) {
            if (this.data[i][1] == 0) {
                continue;
            } else {
                result += kofaktor(i, 1);
            }
        }

        return result;
    }

    /**
     * Mencari kofaktor dari sebuah entri matriks.
     * 
     * @param blockedRow baris entri yang ingin dicari kofaktor-nya.
     * @param blockedColumn kolom entri yang ingin dicari kofaktor-nya.
     * @return Kofaktor dari entri matriks masukan.
     *         Jika matriks bukan matriks persegi (NxN) maka mengembalikan null.
     */
    public double kofaktor(int blockedRow, int blockedColumn) {
		// Tanda positif jika (blockedRow + blockedColumn) genap dan negatif jika ganjil
        int sign = (((blockedRow + blockedColumn) % 2) == 0) ? 1 : -1;

        return sign * this.minor(blockedRow, blockedColumn);
    }

    /**
     * Mencari minor dari sebuah entri matriks.
     * 
     * @param blockedRow baris entri yang ingin dicari minor-nya.
     * @param blockedColumn kolom  entri yang ingin dicari minor-nya.
     * @return 
     */
    private double minor(int blockedRow, int blockedColumn) {
        if (blockedRow < 1 || blockedRow > this.getBrs() || blockedColumn < 1
                || blockedColumn > this.getKol()) {
            return Double.NaN;
        }

        Matriks subMatrix = new Matriks(this.getBrs() - 1, this.getKol() - 1);

        int currentRow = 1;
        int currentColumn = 1;

        for (int i = 1; i <= this.getBrs(); i++) {
            if (i == blockedRow) {
                continue;
            } else {
                for (int j = 1; j <= this.getKol(); j++) {
                    if (j == blockedColumn) {
                        continue;
                    } else {
                        subMatrix.data[currentRow][currentColumn] = this.data[i][j];
                        currentColumn++;
                    }
                }
                currentRow++;
            }
        }

        return subMatrix.determinantLaplaceExpansion();
    }
}