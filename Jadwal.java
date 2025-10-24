import java.util.ArrayList;

public class Jadwal {
    private String id;
    private String nama;
    private String deskripsi;
    private ArrayList<Topik> daftarTopik = new ArrayList<>();

    public Jadwal(String id, String nama, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public ArrayList<Topik> getTopik() { return daftarTopik; }

    public void tambahTopik(Topik t) { daftarTopik.add(t); }

    public void lihatJadwal() {
        System.out.println("Jadwal: " + id + " - " + nama + " : " + deskripsi);
        if (daftarTopik.isEmpty()) System.out.println("  (Belum ada topik)");
        for (Topik t : daftarTopik) System.out.println("  Topik: " + t.getId() + " - " + t.getJudul());
    }
}