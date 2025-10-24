public class HasilKuis extends Aktivitas {
    private Kuis kuis;
    private Mahasiswa mahasiswa;
    private int nilai;

    public HasilKuis(String id, String tanggal, Kuis kuis, Mahasiswa mahasiswa, int nilai) {
        super(id, tanggal, "Kuis");
        this.kuis = kuis;
        this.mahasiswa = mahasiswa;
        this.nilai = nilai;
    }

    public int getNilai() { return nilai; }

    @Override
    public void tampilkan() {
        System.out.println("HasilKuis " + id + " Tanggal:" + tanggal + " Mahasiswa:" + mahasiswa.getNama() + " Kuis:" + kuis.getId() + " Nilai:" + nilai);
    }
}