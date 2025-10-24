public class SesiBelajar {
    private String id;
    private Topik topik;
    private Mahasiswa mahasiswa;
    private String tanggal; //YYYY-MM-DD
    private int durasiMenit;
    private String status; //"Scheduled" or "Completed"

    public SesiBelajar(String id, Topik topik, Mahasiswa mahasiswa, String tanggal, int durasiMenit) {
        this.id = id;
        this.topik = topik;
        this.mahasiswa = mahasiswa;
        this.tanggal = tanggal;
        this.durasiMenit = durasiMenit;
        this.status = "Scheduled";
    }

    public String getId() { return id; }
    public Topik getTopik() { return topik; }
    public Mahasiswa getMahasiswa() { return mahasiswa; }
    public String getTanggal() { return tanggal; }
    public int getDurasi() { return durasiMenit; }
    public String getStatus() { return status; }

    public void tandaiSelesai() {
        if (!status.equals("Completed")) {
            status = "Completed";
            mahasiswa.tambahMenit(durasiMenit);
        }
    }

    public void lihat() {
        System.out.println("Sesi: " + id + " Topik:" + topik.getId() + " Mahasiswa:" + mahasiswa.getNama()
            + " Tanggal:" + tanggal + " Durasi:" + durasiMenit + " menit Status:" + status);
    }
}