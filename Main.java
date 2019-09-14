import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char inputMenu, inputPilihan;
		int brs, kol;
		do {
			System.out.printf("\nMENU\n");
			System.out.printf(
				"1. Sistem Persamaaan Linier\n" + 
				"2. Determinan\n" + 
				"3. Matriks balikan\n" + 
				"4. Matriks kofaktor\n" + 
				"5. Adjoin\n" + 
				"6. Interpolasi Polinom\n" + 
				"7. Keluar\n");
			inputMenu = input.next().charAt(0);
			if (inputMenu == '1') {
				MatriksSPL M;
				System.out.printf("\nPILIHAN : \n");
				System.out.printf(
					"1. Metode eliminasi Gauss\n" + 
					"2. Metode eliminasi Gauss-Jordan\n" + 
					"3. Metode matriks balikan\n" + 
					"4. Kaidah Cramer\n");
				inputPilihan = input.next().charAt(0);
				//  input manual
				brs = input.nextInt();
				kol = input.nextInt();
				M = new MatriksSPL(brs, kol);
				M.bacaMatriks();
				if (inputPilihan == '1') {
					M.gaussForm();
					M.printMatriks();
					M.solveGaussForm();
				} else if (inputPilihan == '2') {
					M.gaussJordan();
					M.printMatriks();
					M.solveGaussJordan();
				} else if (inputPilihan == '3') {
					M.solveMatriksBalikan();
				} else if (inputPilihan == '4') {
					M.solveCramerRule();
				}
				System.out.println("Solusi SPL");
				if (!M.getSolution()) {
					System.out.println("No solution");
				} else {
					String hasil = M.hasilSPL();
					System.out.println(hasil);
				}
			} else if (inputMenu == '2') {
				MatriksSPL M;
				System.out.printf("\nPILIHAN : \n");
				System.out.printf(
					"1. Metode row reduction a.k.a OBE \n" + 
					"2. Metode ekspansi kofaktor a.k.a. Laplace-Expansion\n");
				inputPilihan = input.next().charAt(0);
				System.out.println("Masukkan jumlah baris dan kolom:");
				brs = input.nextInt();
				kol = input.nextInt();
				M = new MatriksSPL(brs, kol);
				M.bacaMatriks();
				if (inputPilihan == '1') {
					double hasil = M.determinantOBE();
					System.out.println("Hasil determinant = " + hasil);
				} else if (inputPilihan == '2') {
					double hasil = M.determinantLaplaceExpansion();
					System.out.println("Hasil determinant = " + hasil);
				}
			} else if (inputMenu == '3') {
				MatriksSPL M;
				System.out.printf("\nPILIHAN : \n");
				System.out.printf(
					"1. Metode row reduction a.k.a OBE \n" + 
					"2. Metode adjoint\n");
				inputPilihan = input.next().charAt(0);
				System.out.println("Masukkan jumlah baris dan kolom:");
				brs = input.nextInt();
				kol = input.nextInt();
				M = new MatriksSPL(brs, kol);
				M.bacaMatriks();
				if (inputPilihan == '1') {
					M.inversOBE();
					M.printMatriks();
				} else if (inputPilihan == '2') {
					//M.inversAdjoin();
					M.printMatriks();
				}
			} else if (inputMenu == '4') {
				System.out.println("Masukkan jumlah baris dan kolom:");
				int baris = input.nextInt();
				int kolom = input.nextInt();
				Matriks mat = new MatriksSPL(baris, kolom);
				mat.bacaMatriks();

				SolveMatriksKofaktor solver = new SolveMatriksKofaktor(mat);
				solver.solve();
				solver.printResult();
			} else if (inputMenu == '5') {
				System.out.println("Masukkan jumlah baris dan kolom:");
				int baris = input.nextInt();
				int kolom = input.nextInt();
				Matriks mat = new MatriksSPL(baris, kolom);
				mat.bacaMatriks();

				SolveAdjoin solver = new SolveAdjoin(mat);
				solver.solve();
				solver.printResult();
			} else if (inputMenu == '6') {
				System.out.println("on progress");
			}

		} while (inputMenu != '7');


	}
}
