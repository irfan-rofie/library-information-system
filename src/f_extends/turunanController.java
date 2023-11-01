package f_extends;

import b_entity.mst_anggota;
import b_entity.mst_buku;
import b_entity.mst_user;
import b_entity.trx_pinjam;
import c_interface.anggotaInterface;
import c_interface.bukuInterface;
import c_interface.trxInterface;
import c_interface.userInterface;
import d_implement.anggotaImplement;
import d_implement.bukuImplement;
import d_implement.trxImplement;
import d_implement.userImplement;
import g_menu.menuAdmin;
import g_menu.menuAnggota;
import g_menu.menuUtama;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class turunanController {

    protected trx_pinjam tp = new trx_pinjam();
    protected mst_user mu = new mst_user();
    protected mst_buku mb = new mst_buku();
    protected mst_anggota ma = new mst_anggota();
    protected static int simpanId;
    protected String nama, password, passUlang, passBaru;
    protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    protected final int a = 1;
    protected int pil, id, hasil;
    protected trxInterface ti = new trxImplement();
    protected anggotaInterface ai = new anggotaImplement();
    protected bukuInterface bi = new bukuImplement();
    protected userInterface u = new userImplement();

    protected void menuAdmin() throws IOException {
        menuAdmin mAdm = new menuAdmin();
    }

    protected static void menuUtama() {
        menuUtama mU = new menuUtama();
    }

    protected void menuAnggota() {
        menuAnggota mAgt = new menuAnggota();
    }

    protected String formatTanggal(String s) {

        String Hasil;
        Hasil = "";
        String hari = s.substring(0, 3);
        if (hari.equalsIgnoreCase("Sun")) {
            Hasil += "Minggu, ";
        } else if (hari.equalsIgnoreCase("Mon")) {
            Hasil += "Senin, ";
        } else if (hari.equalsIgnoreCase("Tue")) {
            Hasil += "Selasa, ";
        } else if (hari.equalsIgnoreCase("Wed")) {
            Hasil += "Rabu, ";
        } else if (hari.equalsIgnoreCase("Thu")) {
            Hasil += "Kamis, ";
        } else if (hari.equalsIgnoreCase("Fri")) {
            Hasil += "Jum'at, ";
        } else if (hari.equalsIgnoreCase("Sat")) {
            Hasil += "Sabtu, ";
        }
        Hasil += s.substring(12, 14);

        String bulan = s.substring(9, 11);
        if (bulan.equalsIgnoreCase("01")) {
            Hasil += " Januari ";
        } else if (bulan.equalsIgnoreCase("02")) {
            Hasil += " Februari ";
        } else if (bulan.equalsIgnoreCase("03")) {
            Hasil += " Maret ";
        } else if (bulan.equalsIgnoreCase("04")) {
            Hasil += " April ";
        } else if (bulan.equalsIgnoreCase("05")) {
            Hasil += " Mei ";
        } else if (bulan.equalsIgnoreCase("06")) {
            Hasil += " Junni ";
        } else if (bulan.equalsIgnoreCase("07")) {
            Hasil += " Juli ";
        } else if (bulan.equalsIgnoreCase("08")) {
            Hasil += " Agustus ";
        } else if (bulan.equalsIgnoreCase("09")) {
            Hasil += " September ";
        } else if (bulan.equalsIgnoreCase("10")) {
            Hasil += " Oktober ";
        } else if (bulan.equalsIgnoreCase("11")) {
            Hasil += " November ";
        } else if (bulan.equalsIgnoreCase("12")) {
            Hasil += " Desemmber ";
        }
        Hasil += s.substring(4, 8);

        return Hasil;
    }
}
