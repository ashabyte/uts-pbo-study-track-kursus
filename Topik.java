import java.util.ArrayList;

public class Topik {
    private String id;
    private String judul;
    private String keterangan;
    private ArrayList<Kuis> daftarKuis = new ArrayList<>();

    public Topik(String id, String judul, String keterangan) {
        this.id = id;
        this.judul = judul;
        this.keterangan = keterangan;
    }

    public String getId() { return id; }
    public String getJudul() { return judul; }
    public String getKeterangan() { return keterangan; }

    public void tambahKuis(Kuis q) { daftarKuis.add(q); }

    public ArrayList<Kuis> getKuis() { return daftarKuis; }
}