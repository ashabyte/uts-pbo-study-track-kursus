import java.util.ArrayList;

public class Soal {
    private String pertanyaan;
    private ArrayList<String> pilihan;
    private int jawabanBenar; //disimpan dalam bentuk angka (1–4)

    public Soal(String pertanyaan, ArrayList<String> pilihan, int jawabanBenar) {
        this.pertanyaan = pertanyaan;
        this.pilihan = pilihan;
        this.jawabanBenar = jawabanBenar;
    }

    public String getPertanyaan() { return pertanyaan; }
    public ArrayList<String> getPilihan() { return pilihan; }
    public int getJawabanBenar() { return jawabanBenar; }

    //Konversi angka ke huruf (A, B, C, D)
    public String getHurufJawabanBenar() {
        switch (jawabanBenar) {
            case 1: return "A";
            case 2: return "B";
            case 3: return "C";
            case 4: return "D";
            default: return "";
        }
    }
}