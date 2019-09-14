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
				Matriks M;
				System.out.printf("\nPILIHAN : \n");
				System.out.printf(
					"1. Metode eliminasi Gauss\n" + 
					"2. Metode eliminasi Gauss-Jordan\n" + 
					"3. Metode matriks balikan\n" + 
					"4. Kaidah Cramer\n");
				inputPilihan = input.next().charAt(0);

				switch(inputPilihan) {
					case '1':
						break;
					case '2':
						break;
					case '3':
						break;
					case '4':
						break;
					default:

				}

			} else if (inputMenu == '2') {

			} else if (inputMenu == '3') {

			} else if (inputMenu == '4') {

			} else if (inputMenu == '5') {

			} else if (inputMenu == '6') {

			}

		} while (inputMenu != '7');

		input.close();
	}

	private static Matriks bacaInputMatriks(Scanner input) {
        int rowCount = input.nextInt();

        int columnCount = input.nextInt();

		Matriks matriks = new Matriks(rowCount, columnCount);

		matriks.bacaMatriks(input);

		return matriks;
	}
}
