import java.util.ArrayList;

public class Mahasiswa extends Pengguna {
    private String username;
    private String password;
    private int totalMenitBelajar = 0;
    private ArrayList<Aktivitas> daftarRiwayat = new ArrayList<>();

    public Mahasiswa(String id, String nama, String username, String password) {
        super(id, nama);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void tambahMenit(int menit) { totalMenitBelajar += menit; }

    public int getTotalMenit() { return totalMenitBelajar; }

    public void tambahRiwayat(Aktivitas a) { daftarRiwayat.add(a); }

    public ArrayList<Aktivitas> getRiwayat() { return daftarRiwayat; }

    @Override
    public void lihatProfil() {
        System.out.println("Student: " + id + " - " + nama + " (total menit: " + totalMenitBelajar + ")");
    }
}