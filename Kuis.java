import java.util.ArrayList;

public class Kuis {
    private String id;
    private Topik topik;
    private ArrayList<Soal> soalList = new ArrayList<>();

    public Kuis(String id, Topik topik) {
        this.id = id;
        this.topik = topik;
    }

    public String getId() { return id; }
    public Topik getTopik() { return topik; }

    public void tambahSoal(Soal s) { soalList.add(s); }

    public ArrayList<Soal> getSoalList() { return soalList; }
}
