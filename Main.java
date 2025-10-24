import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudyTrackApp app = new StudyTrackApp();
        app.inisialisasiData();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelamat datang di aplikasi StudyTrack!");
            System.out.print("Login sebagai (1)Mahasiswa (2)Dosen (3)Logout: ");
            int role = Integer.parseInt(sc.nextLine());
            if (role == 3) break;

            if (role == 1) {
                System.out.print("Username: "); String u = sc.nextLine();
                System.out.print("Password: "); String p = sc.nextLine();
                Mahasiswa s = app.loginMahasiswa(u,p);
                if (s == null) { System.out.println("Login gagal! Silahkan coba lagi."); continue; }
                System.out.println("Login berhasil. Halo, " + s.getNama() + " (Mahasiswa)");
                boolean keluar = false;
                while (!keluar) {
                    System.out.println("\nMenu Mahasiswa:");
                    System.out.println("1. Jadwalkan Sesi");
                    System.out.println("2. Lihat Jadwal");
                    System.out.println("3. Tandai Selesai");
                    System.out.println("4. Ambil Kuis");
                    System.out.println("5. Lihat Progress");
                    System.out.println("6. Lihat Riwayat");
                    System.out.println("7. Logout");
                    System.out.print("Pilih menu: ");
                    int p1 = Integer.parseInt(sc.nextLine());
                    switch (p1) {
                        case 1: app.jadwalkanSesi(s, sc); break;
                        case 2: app.lihatJadwal(s); break;
                        case 3: app.tandaiSelesai(s, sc); break;
                        case 4: app.ambilKuis(s, sc); break;
                        case 5: app.lihatProgress(s); break;
                        case 6: app.lihatRiwayat(s); break;
                        case 7: keluar = true; break;
                        default: System.out.println("Pilihan tidak valid."); break;
                    }
                }

            } else if (role == 2) {
                System.out.print("Username: "); String u = sc.nextLine();
                System.out.print("Password: "); String p = sc.nextLine();
                Dosen ins = app.loginDosen(u,p);
                if (ins == null) { System.out.println("Login gagal! Silahkan coba lagi."); continue; }
                System.out.println("Login berhasil. Halo, " + ins.getNama() + " (Dosen)");
                boolean keluar = false;
                while (!keluar) {
                    System.out.println("\nMenu Dosen:");
                    System.out.println("1. Tambah Jadwal");
                    System.out.println("2. Tambah Topik");
                    System.out.println("3. Buat Kuis");
                    System.out.println("4. Lihat Semua Jadwal");
                    System.out.println("5. Logout");
                    System.out.print("Pilih menu: ");
                    int p2 = Integer.parseInt(sc.nextLine());
                    switch (p2) {
                        case 1: app.tambahJadwal(sc); break;
                        case 2: app.tambahTopik(sc); break;
                        case 3: app.buatKuis(sc); break;
                        case 4: app.lihatSemuaJadwal(); break;
                        case 5: keluar = true; break;
                        default: System.out.println("Pilihan tidak valid."); break;
                    }
                }
            }
        }

        sc.close();
        System.out.println("Terima kasih telah menggunakan aplikasi StudyTrack. Sampai jumpa!");
    }
}