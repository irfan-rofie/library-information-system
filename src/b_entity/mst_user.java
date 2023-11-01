package b_entity;

public class mst_user {
    private String nama,pass;
    private int id;
    private boolean ada,passBool;

    public boolean isPassBool() {
        return passBool;
    }

    public void setPassBool(boolean passBool) {
        this.passBool = passBool;
    }

    public boolean isAda() {
        return ada;
    }

    public void setAda(boolean ada) {
        this.ada = ada;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
