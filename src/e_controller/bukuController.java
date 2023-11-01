package e_controller;

import b_entity.mst_buku;
import f_extends.turunanController;
import java.io.IOException;
import java.util.List;

public class bukuController extends turunanController {

    public void insertBuku() throws IOException {
        try {
            System.out.println("----- Insert Buku -----");
            System.out.print("judul : ");
            mb.setJudul(br.readLine());
            System.out.print("penulis : ");
            mb.setPenulis(br.readLine());
            System.out.print("jumlah : ");
            mb.setJumlah(Integer.parseInt(br.readLine()));
            if (mb.getJumlah() <= 0) {
                System.out.println("Jumlah Buku Minimal 1");
                insertBuku();
            } else {
                System.out.println("-----------------------");
                System.out.println(bi.insertBuku(mb));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("-----------------------------");
            System.out.println("| Jumlah Harus Berupa Angka |");
            System.out.println("-----------------------------");
            insertBuku();
        }
    }

    public void updateBuku() throws IOException {
        try {
            System.out.println("----- Update Buku -----");
            System.out.print("ID : ");
            mb.setId(Integer.parseInt(br.readLine()));
            System.out.println("-----------------------");
            mb = bi.searchId(mb.getId());
            if (mb.isAda()) {
                System.out.print("Judul : ");
                mb.setJudul(br.readLine());
                System.out.print("Penulis : ");
                mb.setPenulis(br.readLine());
                System.out.print("Jumlah : ");
                mb.setJumlah(Integer.parseInt(br.readLine()));
                if (mb.getJumlah() <= 0) {
                    System.out.println("Jumlah Buku Minimal 1");
                    updateBuku();
                } else {
                    System.out.println(bi.updateBuku(mb));
                }
            } else {
                System.out.println("----------------------");
                System.out.println("| ID Tidak Ditemukan |");
                System.out.println("----------------------");
                updateBuku();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("-----------------------------");
            System.out.println("| Jumlah Harus Berupa Angka |");
            System.out.println("-----------------------------");
            updateBuku();
        }
    }

    public void deleteBuku() throws IOException {
        try {
            System.out.println("----- Delete Buku -----");
            System.out.print("ID : ");
            mb.setId(Integer.parseInt(br.readLine()));
            System.out.println("-----------------------");
            mb = bi.searchId(mb.getId());
            if (mb.isAda()) {
                System.out.println(bi.deleteBuku(mb));
            } else {
                System.out.println("----------------------");
                System.out.println("| ID Tidak Ditemukan |");
                System.out.println("----------------------");
                deleteBuku();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputkan Angka");
            deleteBuku();
        }
    }

    public void viewBuku() {
        System.out.println("----- View Buku -----");
        List<mst_buku> mbList = bi.viewBuku();
        for (mst_buku mbuk : mbList) {
            System.out.println("-----------------------------");
            System.out.println("ID      : " + mbuk.getId());
            System.out.println("Judul   : " + mbuk.getJudul());
            System.out.println("Penulis : " + mbuk.getPenulis());
            System.out.println("Jumlah  : " + mbuk.getJumlah());
        }
    }

    public void cariBuku() throws IOException {
        try {
            System.out.println("----- Cari Buku -----");
            System.out.print("ID : ");
            mb.setId(Integer.parseInt(br.readLine()));
            System.out.println("---------------------");
            mb = bi.searchId(mb.getId());
            if (mb.isAda()) {
                System.out.println("----------------------------");
                System.out.println("ID      : " + mb.getId());
                System.out.println("Judul   : " + mb.getJudul());
                System.out.println("Penulis : " + mb.getPenulis());
                System.out.println("Jumlah  : " + mb.getJumlah());
                System.out.println("----------------------------");
            } else {
                System.out.println("----------------------");
                System.out.println("| ID Tidak Ditemukan |");
                System.out.println("----------------------");
                cariBuku();
            }
        }catch(IOException | NumberFormatException e){
            System.out.println("Inputkan Angka");
            cariBuku();
        }
    }
}
