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
	}


	public String hasilSPL() {
		String hasil = "";
		for (int i = 1; i <= this.nPeubah; i++) {
			hasil += String.format("x%d = %f; ", i, this.hasilSPL[i]);
		}
		return hasil;
	}

}