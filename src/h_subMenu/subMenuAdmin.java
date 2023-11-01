package h_subMenu;

import e_controller.anggotaController;
import e_controller.bukuController;
import e_controller.trxController;
import e_controller.userController;
import f_extends.turunanController;
import java.io.IOException;

public class subMenuAdmin extends turunanController {

    userController uc = new userController();
    anggotaController ac = new anggotaController();
    bukuController bc = new bukuController();
    trxController tc = new trxController();

    public void pengelolaanAdmin() {
        try {
            do {
                System.out.println("----- Pengelolaan Admin -----");
                System.out.println("|   1. Insert Admin         |");
                System.out.println("|   2. Update Password      |");
                System.out.println("|   3. back                 |");
                System.out.println("-----------------------------");
                System.out.print("Pilih : ");
                pil = Integer.parseInt(br.readLine());
                switch (pil) {
                    case 1:
                        uc.insertAdmin();
                        break;
                    case 2:
                        uc.updatePassword();
                        break;
                    case 3:
                        menuAdmin();
                        break;
                    default:
                        System.out.println("Inputkan Angka 1 - 3");
                        pengelolaanAdmin();
                        break;
                }
            } while (a < 1);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Harus Berupa Angka");
            pengelolaanAdmin();
        }
    }

    public void pengelolaanAnggota() {
        try {
            do {
                System.out.println("----- Pengelolaan Anggota -----");
                System.out.println("|   1. Insert Anggota         |");
                System.out.println("|   2. Update Anggota         |");
                System.out.println("|   3. Delete Anggota         |");
                System.out.println("|   4. View Anggota           |");
                System.out.println("|   5. Back                   |");
                System.out.println("-------------------------------");
                System.out.print("pilih : ");
                pil = Integer.parseInt(br.readLine());
                switch (pil) {
                    case 1:
                        ac.insertAnggota();
                        pengelolaanAnggota();
                        break;
                    case 2:
                        ac.updateAnggota();
                        pengelolaanAnggota();
                        break;
                    case 3:
                        ac.deleteAnggota();
                        pengelolaanAnggota();
                        break;
                    case 4:
                        ac.viewAnggota();
                        pengelolaanAnggota();
                        break;
                    case 5:
                        menuAdmin();
                        break;
                    default:
                        System.out.println("Inputkan Angka 1 - 5");
                        pengelolaanAnggota();
                }
            } while (a < 1);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Harus Berupa Angka");
            pengelolaanAnggota();
        }
    }

    public void pengelolaanBuku() {
        try {
            do {
                System.out.println("----- Pengelolaan Buku -----");
                System.out.println("|   1. Insert Buku         |");
                System.out.println("|   2. Update Buku         |");
                System.out.println("|   3. Delete Buku         |");
                System.out.println("|   4. View Buku           |");
                System.out.println("|   5. Back                |");
                System.out.println("----------------------------");
                System.out.print("pilih : ");
                pil = Integer.parseInt(br.readLine());
                switch (pil) {
                    case 1:
                        bc.insertBuku();
                        pengelolaanBuku();
                        break;
                    case 2:
                        bc.updateBuku();
                        pengelolaanBuku();
                        break;
                    case 3:
                        bc.deleteBuku();
                        pengelolaanBuku();
                        break;
                    case 4:
                        bc.viewBuku();
                        pengelolaanBuku();
                        break;
                    case 5:
                        menuAdmin();
                        break;
                    default:
                        System.out.println("Inputkan Angka 1 - 5");
                        pengelolaanBuku();
                }
            } while (a < 1);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Harus Berupa Angka");
            pengelolaanBuku();
        }
    }

    public void pengelolaanTransaksi() {
        try {
            do {
                System.out.println("--------- Pengelolaan Transaksi ---------");
                System.out.println("|   1. Lihat Semua Data Peminjaman      |");
                System.out.println("|   2. Lihat Data Yang Masih Meminjam   |");
                System.out.println("|   3. Peminjaman Baru                  |");
                System.out.println("|   4. Pengembalian                     |");
                System.out.println("|   5. Lihat Kas Denda                  |");
                System.out.println("|   6. Back                             |");
                System.out.println("-----------------------------------------");
                System.out.print("Pilih : ");
                pil = Integer.parseInt(br.readLine());
                switch (pil) {
                    case 1:
                        tc.dataPeminjaman();
                        pengelolaanTransaksi();
                        break;
                    case 2:
                        tc.yangMasihMinjam();
                        pengelolaanTransaksi();
                        break;
                    case 3:
                        tc.peminjamanBaru();
                        pengelolaanTransaksi();
                        break;
                    case 4:
                        tc.pengembalian();
                        pengelolaanTransaksi();
                        break;
                    case 5:
                        tc.kasDenda();
                        pengelolaanTransaksi();
                        break;
                    case 6:
                        menuAdmin();
                        break;
                    default:
                        System.out.println("Inputkan Angka 1 - 6");
                        pengelolaanTransaksi();
                        break;
                }
            } while (a < 1);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Harus Berupa Angka");
            pengelolaanTransaksi();
        }
    }
}
