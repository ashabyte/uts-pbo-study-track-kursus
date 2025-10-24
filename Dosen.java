public class Dosen extends Pengguna {
    private String username;
    private String password;

    public Dosen(String id, String nama, String username, String password) {
        super(id, nama);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void lihatProfil() {
        System.out.println("Dosen: " + id + " - " + nama + " (username: " + username + ")");
    }
}