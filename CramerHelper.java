/**
 * Implementasi dari algoritma-algoritma yang dibutuhkan untuk pencarian solusi
 * SPL dengan Kaidah Cramer.
 */
public class CramerHelper {
    /**
     * Mencari determinan dari sebuah matriks.
     * 
     * @param matrix sebuah matriks persegi (NxN).
     * @return Mengembalikan nilai determinan.
     *         Jika matriks bukan matriks persegi (NxN) maka mengembalikan null.
     */
    public static double determinan(Matriks matrix) {
        if (matrix.getKol() != matrix.getBrs()) {
            return null;
        }

        if (matrix.getKol() == 1 && matrix.getBrs() == 1) {
            return matrix.data[0][0];
        }

        float result = 0;

        // menggunakan kolom 0 dengan asumsi kolom 0 memiliki paling banyak angka 0
        for (int i = 0; i < matrix.getBrs(); i++) {
            if (matrix.data[i][0] == 0) {
                continue;
            } else {
                result += kofaktor(matrix, i, 0);
            }
        }

        return result;
    }

    /**
     * Mencari kofaktor dari sebuah entri matriks.
     * 
     * @param matrix sebuah matriks persegi (NxN).
     * @param blockedRow baris entri yang ingin dicari kofaktor-nya.
     * @param blockedColumn kolom  entri yang ingin dicari kofaktor-nya.
     * @return Kofaktor dari entri matriks masukan.
     *         Jika matriks bukan matriks persegi (NxN) maka mengembalikan null.
     */
    public static double kofaktor(Matriks matrix, int blockedRow, int blockedColumn) {
        int sign = ((blockedRow + blockedColumn) % 2) * -1;

        return sign * minor(matrix, blockedRow, blockedColumn);
    }

    /**
     * Mencari matriks adjoin dari sebuah matriks persegi (NxN).
     * 
     * @param matrix Sebuah matriks persegi (NxN).
     * @return Matriks adjoin dari matriks masukan.
     *         Jika matriks bukan matriks persegi (NxN) maka mengembalikan null.
     */
    public static Matriks adjoin(Matriks matrix) {
        Matriks kofaktorMatrix = new Matriks(matrix.getBrs(), matrix.getKol());

        for (int i = 0; i < matrix.getBrs(); i++) {
            for (int j = 0; j < matrix.getKol(); j++) {
                kofaktorMatrix.data[i][j] = kofaktor(matrix, i, j);
            }
        }

        return transpos(kofaktorMatrix);
    }

    /**
     * Mencari minor dari sebuah entri matriks.
     * 
     * @param matrix sebuah matriks persegi (NxN).
     * @param blockedRow baris entri yang ingin dicari minor-nya.
     * @param blockedColumn kolom  entri yang ingin dicari minor-nya.
     * @return 
     */
    private static double minor(Matriks matrix, int blockedRow, int blockedColumn) {
        if (blockedRow < 0 || blockedRow > matrix.getBrs() - 1 || blockedColumn < 0
                || blockedColumn > matrix.getKol() - 1) {
            return null;
        }

        Matriks subMatrix = new Matriks(matrix.getBrs() - 1, matrix.getKol() - 1);

        int currentRow = 0;
        int currentColumn = 0;

        for (int i = 0; i < matrix.getBrs(); i++) {
            if (i == blockedRow) {
                continue;
            } else {
                for (int j = 0; j < matrix.getKol(); j++) {
                    if (j == blockedColumn) {
                        continue;
                    } else {
                        subMatrix.data[currentRow][currentColumn] = matrix.data[i][j];
                        currentColumn++;
                    }
                }
                currentRow++;
            }
        }

        return Cramer.determinan(subMatrix);
    }

    /**
     * Melakukan transpos dari suatu matriks.
     * 
     * @param matrix sebuah matriks terinisialisasi.
     * @return transpos dari matriks masukan.
     */
    private static Matriks transpos(Matriks matrix) {
        Matriks newMatrix = new Matriks(matrix.getBrs(), matrix.getKol());

        for (int i = 0; i < matrix.getBrs(); i++) {
            for (int j = 0; j < matrix.getKol(); j++) {
                newMatrix.data[j][i] = matrix.data[i][j];
            }
        }

        return newMatrix;
    }
}
