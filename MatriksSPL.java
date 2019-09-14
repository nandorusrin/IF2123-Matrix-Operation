import java.util.ArrayList;

/**
 * Kelas yang berisi implementasi algoritma pencari solusi SPL.
 */
public class MatrixSPL {

    /**
     * Menyelesaikan SPL dengan kaidah Cramer.
     * @param persamaan Objek Matriks yang berisi persamaan SPL.
     */
    public static void kaidahCramer(Matriks persamaan) {

        if (persamaan.getBrs() != persamaan.getKol() - 1) {
            System.out.println("Tidak bisa diselesaikan dengan kaidah Cramer! (Tidak memiliki solusi unik)");
            return;
        }

        // Memisahkan konstanta dan variabel persamaan
        ArrayList<Double> konstantaPersamaan = new ArrayList<Double>();
        Matriks koefisienVariabel = new Matriks(persamaan.getBrs(), persamaan.getKol() - 1);

        for(int i = 0; i < persamaan.getBrs(); i++) {
            for(int j = 0; j < persamaan.getKol(); j++) {
                if (j == persamaan.getKol() - 1) {
                    konstantaPersamaan.add(persamaan.data[i][j]);
                }
                else {
                    koefisienVariabel.data[i][j] = persamaan.data[i][j];
                }
            }
        }

        // Mencari determinan matriks koefisien variabel
        double determinanKoefisienVariabel = CramerHelper.determinan(koefisienVariabel);


        if (determinanKoefisienVariabel == 0) {
            System.out.println("Tidak bisa diselesaikan dengan kaidah Cramer! (Tidak memiliki solusi unik)");
            return;
        }

        ArrayList<Double> result = new ArrayList<Double>();

        // iterasi tiap An pada kaidah Cramer
        for(int kolomTukar = 0; kolomTukar < persamaan.getKol(); kolomTukar++) {
            Matriks tempMatrix = new Matriks(koefisienVariabel.getBrs(), koefisienVariabel.getKol());

            for (int i = 0; i < koefisienVariabel.getBrs(); i++) {
                for (int j = 0; j < koefisienVariabel.getKol(); j++) {
                    if (j == kolomTukar) {
                        tempMatrix.data[i][j] = konstantaPersamaan.get(i);
                    }
                    else {
                        tempMatrix.data[i][j] = koefisienVariabel.data[i][j];
                    }
                }
            }

            // det(An)
            double tempDeterminant = CramerHelper.determinan(tempMatrix);

            result.add(tempDeterminant/determinanKoefisienVariabel);
        }

        tulisJawaban(result);
    }

    /**
     * Menulis solusi SPL.
     * @param answer ArrayList<double> yang berisi solusi SPL.
     */
    private static void tulisJawaban(ArrayList<Double> answer) {

        if (answer = null) {
            System.out.println("Tidak ada solusi!");
        }

        System.out.println("Solusi:");
        
        for(int i = 0; i < answer.size(); i++) {
            System.out.println("X" + (i+1) + " = " + answer.get(i));
        }
    }
}