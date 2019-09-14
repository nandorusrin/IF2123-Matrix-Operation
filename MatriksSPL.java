public class MatriksSPL extends Matriks {
	private double[] hasilSPL;
	private int nPeubah;
	private boolean solution;
	private int[] status; //0 = tidak ada, 1 = solusi tunggal, 2 = solusi banyak

	public MatriksSPL(int _brs, int _kol) {
		super(_brs,_kol);
		this.nPeubah = this.kol - 1;
		this.hasilSPL = new double[nPeubah+2];
		this.solution = true;
	}

	public boolean getSolution() {
		return this.solution;
	}

	public void cekStatus() {
		for (int i = this.brs; i > 0; i--) {
			if(!this.isBrsKosong(i)) {
				int idxFirst = this.getFirstIndeks(i);
				if (idxFirst == this.kol) {
					this.solution = false;
				} else {
					
				}
			}
		}
	}

	public void solveGaussForm() {
		this.cekStatus();
		if (this.solution) {

		}	
	}

	public void solveGaussJordan() {
		this.cekStatus();
		if (this.solution) {

		}	
	}

	public void solveMatriksBalikan() {
		// [A|I] => [I|A^-1] USING OBE
		// [x = A^-1.b]
	}

	public void solveCramerRule() {
		// Ax = b
		// x1 = det(A1)/det(A), x2 = det(A2)/det(A), ...
        if (this.getBrs() != this.getKol() - 1) {
            System.out.println("Tidak bisa diselesaikan dengan kaidah Cramer!");
            this.solution = false;
            return;
        }

        // Memisahkan konstanta (b) dan koefisien variabel (A) persamaan
        double[] konstantaPersamaan = new double[this.nPeubah+2];
        Matriks koefisienVariabel = new Matriks(this.getBrs(), this.getKol() - 1);

        for(int i = 1; i <= this.getBrs(); i++) {
            for(int j = 1; j <= this.getKol(); j++) {
                if (j == this.getKol()) {
                    konstantaPersamaan[i] = this.data[i][j];
                }
                else {
                    koefisienVariabel.data[i][j] = this.data[i][j];
                }
            }
        }

        // Mencari determinan matriks koefisien variabel
        double determinanKoefisienVariabel = koefisienVariabel.determinantLaplaceExpansion();

        if (determinanKoefisienVariabel == 0) {
            System.out.println("Tidak bisa diselesaikan dengan kaidah Cramer! (Tidak memiliki solusi unik)");
            this.solution = false;
            return;
        }

        // iterasi tiap Ai pada kaidah Cramer
        for(int kolomTukar = 1; kolomTukar <= this.getKol(); kolomTukar++) {
            Matriks tempMatrix = new Matriks(koefisienVariabel.getBrs(), koefisienVariabel.getKol());

            for (int i = 1; i <= koefisienVariabel.getBrs(); i++) {
                for (int j = 1; j <= koefisienVariabel.getKol(); j++) {
                    if (j == kolomTukar) {
                        // Tukar kolom dengan konstanta persamaan (b)
                        tempMatrix.data[i][j] = konstantaPersamaan[i];
                    }
                    else {
                        tempMatrix.data[i][j] = koefisienVariabel.data[i][j];
                    }
                }
            }

            // det(Ai)
            double tempDeterminant = tempMatrix.determinantLaplaceExpansion();

            this.hasilSPL[kolomTukar] = tempDeterminant/determinanKoefisienVariabel;
        }

        this.solution = true;
	}


	public String hasilSPL() {
		String hasil = "";
		for (int i = 1; i <= this.nPeubah; i++) {
			hasil += String.format("x%d = %f; ", i, this.hasilSPL[i]);
		}
		return hasil;
	}
}