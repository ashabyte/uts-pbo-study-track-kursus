public abstract class Aktivitas {
    protected String id;
    protected String tanggal;
    protected String tipe; //"Sesi" atau "Kuis"

    public Aktivitas(String id, String tanggal, String tipe) {
        this.id = id;
        this.tanggal = tanggal;
        this.tipe = tipe;
    }

    public abstract void tampilkan();
}