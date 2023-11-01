package e_controller;

import b_entity.mst_anggota;
import b_entity.mst_buku;
import b_entity.trx_pinjam;
import f_extends.turunanController;
import java.io.IOException;
import java.util.List;

public class trxController extends turunanController {

    public void dataPeminjaman() {
        System.out.println("----- Data Peminjaman -----\n");
        List<trx_pinjam> tList = ti.viewDataPeminjaman();
        for (trx_pinjam tPinjam : tList) {
            System.out.println("------------------------------------------");
            System.out.println("ID              : " + tPinjam.getId());
            System.out.println("Nama            : " + tPinjam.getNama());
            System.out.println("Judul           : " + tPinjam.getJudul());
            System.out.println("Tanggal Pinjam  : " + formatTanggal(tPinjam.getTgl_pinjam()));
            System.out.println("Tanggal Kembali : " + (tPinjam.getTgl_kembali().equals("-") ? "-" : formatTanggal(tPinjam.getTgl_kembali())));
            System.out.println("Denda           : " + tPinjam.getDenda());
        }
    }

    public void yangMasihMinjam() {
        System.out.println("----- View Data Yang Masih Meminjam -----\n");
        List<trx_pinjam> tpList = ti.viewYangMasihMeminjam();
        System.out.println("-----------------------------------------");
        for (trx_pinjam tPinjam : tpList) {
            System.out.println("ID              : " + tPinjam.getId());
            System.out.println("Nama            : " + tPinjam.getNama());
            System.out.println("Judul           : " + tPinjam.getJudul());
            System.out.println("Tanggal Pinjam  : " + formatTanggal(tPinjam.getTgl_pinjam()));
            System.out.println("-----------------------------------------");
        }
    }

    public void peminjamanBaru() throws IOException {
        try {
            System.out.println("----- Peminjaman Baru -----");
            System.out.print("Cari Nama Anggota : ");
            nama = br.readLine();
            List<mst_anggota> mList = ai.searchName(nama);
            if (mList.isEmpty()) {
                System.out.println("Nama Tidak Ada");
                peminjamanBaru();
            } else {
                for (mst_anggota m : mList) {
                    System.out.println("ID        : " + m.getId());
                    System.out.println("Nama      : " + m.getNama());
                    System.out.println("Alamat    : " + m.getAlamat());
                    System.out.println("Pekerjaan : " + m.getPekerjaan());
                    System.out.println("Umur      : " + m.getUmur());
                    System.out.println("----------------------------");
                }
                inputIdAnggota();
            }
        } catch (Exception e) {
        }
    }

    public void inputIdAnggota() throws IOException {
        try {
            System.out.print("Input ID Anggota : ");
            tp.setId_anggota(Integer.parseInt(br.readLine()));
            ma = ai.searchId(tp.getId_anggota());
            if (ma.isAda()) {
                System.out.println("Cari Judul Buku : ");
                List<mst_buku> mbList = bi.viewBuku();
                for (mst_buku mbuk : mbList) {
                    System.out.println("ID      : " + mbuk.getId());
                    System.out.println("Judul   : " + mbuk.getJudul());
                    System.out.println("Penulis : " + mbuk.getPenulis());
                    System.out.println("Jumlah  : " + mbuk.getJumlah());
                    System.out.println("------------------------------");
                }
                inputIdBuku();
            } else {
                System.out.println("Dia Tidak Pinjam Buku Atau Tidak Masuk Anggota");
                inputIdAnggota();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("ID Berupa Angka");
            inputIdAnggota();
        }
    }

    public void inputIdBuku() throws IOException {
        try {
            System.out.print("Input ID Buku : ");
            tp.setId_buku(Integer.parseInt(br.readLine()));
            mb = bi.searchId(tp.getId_buku());
            if (mb.isAda()) {
                if (mb.getJumlah() == 0) {
                    System.out.println("Buku Habis Dipinjam");
                    inputIdBuku();
                } else {
                    System.out.println(ti.insertBuku(tp));
                }
            } else {
                System.out.println("ID Buku Tidak Ditemukan");
                inputIdBuku();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Berupa Angka");
            inputIdBuku();
        }
    }

    public void pengembalian() throws IOException {
        try {
            yangMasihMinjam();
            System.out.print("Input ID Peminjaman : ");
            tp.setId(Integer.parseInt(br.readLine()));
            List<trx_pinjam> tpList = ti.pengembalian(tp.getId());
            if (tpList.isEmpty()) {
                System.out.println("ID Tidak Ditemukan");
                pengembalian();
            } else {
                for (trx_pinjam tpj : tpList) {
                    System.out.println("------------------------------------------");
                    System.out.println("ID              : " + tpj.getId());
                    System.out.println("Nama            : " + tpj.getNama());
                    System.out.println("Judul           : " + tpj.getJudul());
                    System.out.println("Tanggal Pinjam  : " + formatTanggal(tpj.getTgl_pinjam()));
                    System.out.println("Tanggal Kembali : " + (tpj.getTgl_kembali().equals("-") ? "-" : formatTanggal(tpj.getTgl_kembali())));
                    System.out.println("Denda           : " + (tpj.getDenda() == 0 ? "-" : tpj.getDenda()));
                    System.out.println("------------------------------------------");
                    ti.kembalikanBuku(tp.getId());
                    ti.tambahBuku(tpj.getId_buku());
                    System.out.println("Denda           : " + ti.denda(tp.getId()));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("ID Berupa Angka");
        }
    }

    public void kasDenda() {
        System.out.println("Kas Denda : " + ti.kasDenda());
    }

}
