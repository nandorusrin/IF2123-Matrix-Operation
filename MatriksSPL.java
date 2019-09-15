public class MatriksSPL extends Matriks {
	private double[][] hasilSPL;
	private int nPeubah;
	private int[] cek;
	private boolean solution;

	public MatriksSPL(int _brs, int _kol) {
		super(_brs,_kol);
		this.nPeubah = this.kol - 1;
		this.hasilSPL = new double[nPeubah+2][nPeubah+2];
		this.cek = new int[nPeubah+2];
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

	}

	public String printHasilSPL() {
        String hasil = "";
       
        return hasil;
    }

}