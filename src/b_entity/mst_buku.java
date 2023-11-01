package b_entity;

public class mst_buku {
    private String judul,penulis;
    private int id,jumlah;
    private boolean ada;

    public boolean isAda() {
        return ada;
    }

    public void setAda(boolean ada) {
        this.ada = ada;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
}
