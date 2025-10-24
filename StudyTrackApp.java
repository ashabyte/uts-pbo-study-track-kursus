import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class StudyTrackApp {
    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private ArrayList<Jadwal> daftarJadwal = new ArrayList<>();
    private ArrayList<SesiBelajar> daftarSesi = new ArrayList<>();
    private ArrayList<HasilKuis> daftarHasil = new ArrayList<>();

    public void inisialisasiData() {
        Dosen ins = new Dosen("D1","Fachrul Pralienka Bani Muhamad, S.ST., M.Kom.","dosen","dosen1234");
        daftarDosen.add(ins);
        Mahasiswa s = new Mahasiswa("M1","Alfath Shafira","alshfra","mhs1910");
        daftarMahasiswa.add(s);

        Jadwal k = new Jadwal("PBO1","Pemrograman Berorientasi Objek","Jadwal belajar dasar Java");
        Topik t1 = new Topik("1","Konsep Dasar","class, object, atribut, method");
        Topik t2 = new Topik("2","Empat Pilar OOP","Encapsulation, Inheritance, Polymorphism, Abstraction");
        k.tambahTopik(t1); k.tambahTopik(t2);
        daftarJadwal.add(k);

        //kuis
        Kuis q = new Kuis("Q1", t1);
        Soal s1 = new Soal("Kapan method overriding terjadi?", new java.util.ArrayList<String>(java.util.Arrays.asList("Saat dua kelas tidak berhubungan","Saat subclass mendefinisikan metode dengan nama dan parameter sama seperti di superclass","Saat superclass memiliki lebih dari satu konstruktor","Saat metode dibuat dengan kata kunci static")), 2);
        q.tambahSoal(s1);
        t1.tambahKuis(q);

        //kuis
        Kuis q2 = new Kuis("Q2", t1);
        Soal s2 = new Soal("Apa fungsi utama dari framework web seperti Laravel?", new java.util.ArrayList<String>(java.util.Arrays.asList("Mengganti HTML dengan bahasa baru","Mempermudah pengembangan dengan struktur dan fitur siap pakai","Menghapus kebutuhan akan database","Menjalankan program tanpa server")), 2);
        q2.tambahSoal(s2);
        t1.tambahKuis(q2);
    }

    //Login
    public Dosen loginDosen(String username, String password) {
        for (Dosen i : daftarDosen) if (i.login(username,password)) return i;
        return null;
    }
    public Mahasiswa loginMahasiswa(String username, String password) {
        for (Mahasiswa s : daftarMahasiswa) if (s.login(username,password)) return s;
        return null;
    }

    //Dosen functions
    public void tambahJadwal(Scanner sc) {
        System.out.print("ID Jadwal: "); String id = sc.nextLine();
        System.out.print("Nama Jadwal: "); String nama = sc.nextLine();
        System.out.print("Deskripsi: "); String desc = sc.nextLine();
        Jadwal k = new Jadwal(id,nama,desc);
        daftarJadwal.add(k);
        System.out.println("Jadwal " + id + " ditambahkan.");
    }

    public void tambahTopik(Scanner sc) {
        System.out.print("ID Jadwal tujuan: "); String idk = sc.nextLine();
        Jadwal k = null; for (Jadwal x : daftarJadwal) if (x.getId().equals(idk)) { k = x; break; }
        if (k==null) { System.out.println("Jadwal tidak ditemukan."); return; }
        System.out.print("ID Topik: "); String idt = sc.nextLine();
        System.out.print("Judul Topik: "); String jud = sc.nextLine();
        System.out.print("Keterangan: "); String ket = sc.nextLine();
        Topik t = new Topik(idt,jud,ket);
        k.tambahTopik(t);
        System.out.println("Topik " + idt + " ditambahkan ke jadwal " + idk);
    }

    public void buatKuis(Scanner sc) {
        System.out.print("ID Topik: "); String idt = sc.nextLine();
        Topik t = null;
        for (Jadwal k : daftarJadwal) for (Topik tp : k.getTopik()) if (tp.getId().equals(idt)) t = tp;
        if (t==null) { System.out.println("Topik tidak ditemukan."); return; }
        System.out.print("ID Kuis: "); String idq = sc.nextLine();
        Kuis q = new Kuis(idq,t);
        System.out.print("Berapa banyak soal? "); int n = Integer.parseInt(sc.nextLine());
        for (int i=0;i<n;i++) {
            System.out.print("Soal " + (i+1) + ": "); String pert = sc.nextLine();
            ArrayList<String> pilihan = new ArrayList<>();
            for (int j=1;j<=4;j++) {
                System.out.print("Pilihan " + j + ": "); pilihan.add(sc.nextLine());
            }
            System.out.print("Jawaban benar (1-4): "); int benar = Integer.parseInt(sc.nextLine());
            Soal s = new Soal(pert, pilihan, benar);
            q.tambahSoal(s);
        }
        t.tambahKuis(q);
        System.out.println("Kuis " + idq + " dibuat untuk topik " + idt);
    }

    //Mahasiswa functions
    public void jadwalkanSesi(Mahasiswa st, Scanner sc) {
        System.out.print("ID Jadwal: "); String idk = sc.nextLine();
        System.out.print("ID Topik: "); String idt = sc.nextLine();
        Topik t = null;
        for (Jadwal k : daftarJadwal) if (k.getId().equals(idk)) {
            for (Topik tp : k.getTopik()) if (tp.getId().equals(idt)) t = tp;
        }
        if (t==null) { System.out.println("Topik tidak ditemukan."); return; }
        System.out.print("Tanggal (YYYY-MM-DD): "); String tgl = sc.nextLine();
        System.out.print("Durasi (menit): "); int d = Integer.parseInt(sc.nextLine());
        String idS = "M" + (daftarSesi.size()+1);
        SesiBelajar s = new SesiBelajar(idS, t, st, tgl, d);
        daftarSesi.add(s);
        System.out.println("Sesi " + idS + " ditambahkan.");
    }

    public void lihatJadwal(Mahasiswa st) {
        System.out.println("Jadwal untuk " + st.getNama() + ":");
        for (SesiBelajar s : daftarSesi) if (s.getMahasiswa().getId().equals(st.getId())) s.lihat();
    }

    public void tandaiSelesai(Mahasiswa st, Scanner sc) {
        System.out.print("ID Sesi yang diselesaikan: "); String ids = sc.nextLine();
        for (SesiBelajar s : daftarSesi) if (s.getId().equals(ids) && s.getMahasiswa().getId().equals(st.getId())) {
            if (s.getStatus().equals("Completed")) { System.out.println("Sesi sudah ditandai selesai."); return; }
            s.tandaiSelesai();
            // tambahkan aktivitas sesi ke riwayat (simple output)
            Aktivitas a = new Aktivitas("A"+(st.getRiwayat().size()+1), LocalDate.now().toString(), "Sesi") {
                @Override public void tampilkan() {
                    System.out.println("Aktivitas Sesi: " + ids + " Tanggal:" + this.tanggal);
                }
            };
            st.tambahRiwayat(a);
            System.out.println("Sesi " + ids + " ditandai selesai. Total menit: " + st.getTotalMenit());
            return;
        }
        System.out.println("Sesi tidak ditemukan untuk Anda.");
    }

    public void ambilKuis(Mahasiswa st, Scanner sc) {
    System.out.print("ID Kuis: ");
    String idq = sc.nextLine();
    Kuis q = null;

    // Cari kuis berdasarkan ID
    for (Jadwal k : daftarJadwal)
        for (Topik t : k.getTopik())
            for (Kuis ku : t.getKuis())
                if (ku.getId().equals(idq))
                    q = ku;

    if (q == null) {
        System.out.println("Kuis tidak ditemukan.");
        return;
    }

    int benar = 0;
    System.out.println("\n    Mulai Kuis " + q.getId() + "    ");

    //Tampilkan soal satu per satu
    for (Soal s : q.getSoalList()) {
        System.out.println("\nSoal: " + s.getPertanyaan());
        char opsi = 'A';
        for (String p : s.getPilihan()) {
            System.out.println(opsi + ") " + p);
            opsi++;
        }

        //Input jawaban dalam huruf
        System.out.print("Jawab (A-D): ");
        char jawChar = sc.nextLine().toUpperCase().charAt(0);

        //Konversi huruf ke angka (A=1, B=2, dst)
        int jaw = jawChar - 'A' + 1;

        if (jaw == s.getJawabanBenar()) {
            benar++;
        } else {
            System.out.println("Jawaban salah. Jawaban yang benar adalah: " + s.getHurufJawabanBenar());
        }
    }

    int nilai = (int) ((double) benar / q.getSoalList().size() * 100);
    String idH = "H" + (daftarHasil.size() + 1);

    HasilKuis hk = new HasilKuis(idH, java.time.LocalDate.now().toString(), q, st, nilai);
    daftarHasil.add(hk);
    st.tambahRiwayat(hk);

    System.out.println("\nKuis selesai. Terima kasih telah berpartisipasi dalam mengerjakan kuis ini!");
System.out.println("Nilai Anda: " + nilai);
}

    public void lihatProgress(Mahasiswa st) {
        int menit = st.getTotalMenit();
        int jam = menit / 60;
        int sisaMenit = menit % 60;
        // hitung topik selesai = ambil jumlah topik dan cek ada sesi completed untuk topik itu oleh student
        int totalTopik = 0;
        int selesai = 0;
        for (Jadwal k : daftarJadwal) {
            for (Topik t : k.getTopik()) {
                totalTopik++;
                // cek apakah ada sesi completed untuk topik t
                boolean comp = false;
                for (SesiBelajar s : daftarSesi) {
                    if (s.getMahasiswa().getId().equals(st.getId()) && s.getTopik().getId().equals(t.getId()) && s.getStatus().equals("Completed")) { comp = true; break; }
                }
                if (comp) selesai++;
            }
        }
        //rata2 kuis
        int sum = 0; int count = 0;
        for (Aktivitas a : st.getRiwayat()) {
            if (a instanceof HasilKuis) { sum += ((HasilKuis)a).getNilai(); count++; }
        }
        double rata = count==0 ? 0.0 : (double)sum / count;
        System.out.println("Progress " + st.getNama() + ":");
        System.out.println("Total jam belajar: " + jam + " jam " + sisaMenit + " menit");
        System.out.println("Topik selesai: " + selesai + " / " + totalTopik + " (" + (totalTopik==0?0:(selesai*100/totalTopik)) + "%)");
        System.out.println("Rata-rata nilai kuis: " + String.format("%.1f", rata));
    }

    public void lihatRiwayat(Mahasiswa st) {
        System.out.println("Riwayat aktivitas " + st.getNama() + ":");
        if (st.getRiwayat().isEmpty()) { System.out.println("  (Belum ada aktivitas)"); return; }
        for (Aktivitas a : st.getRiwayat()) a.tampilkan();
    }

    // Utility: list jadwal
    public void lihatSemuaJadwal() {
        for (Jadwal k : daftarJadwal) k.lihatJadwal();
    }
}