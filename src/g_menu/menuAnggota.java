package g_menu;

import e_controller.anggotaController;
import e_controller.bukuController;
import f_extends.turunanController;
import java.io.IOException;

public class menuAnggota extends turunanController {
    
    anggotaController ac = new anggotaController();
    bukuController bc = new bukuController();

    public menuAnggota() {
        try {
            do {
                System.out.println("----- Menu Anggota -----");
                System.out.println("|   1. Lihat Buku      |");
                System.out.println("|   2. Cari Buku       |");
                System.out.println("|   3. Ubah Password   |");
                System.out.println("|   4. Logout          |");
                System.out.println("------------------------");
                System.out.print("pilih : ");
                pil = Integer.parseInt(br.readLine());
                switch (pil) {
                    case 1:
                        bc.viewBuku();
                        menuAnggota();
                        break;
                    case 2:
                        bc.cariBuku();
                        menuAnggota();
                        break;
                    case 3:
                        ac.updatePassword();
                        menuAnggota();
                        break;
                    case 4:
                        menuUtama();
                        break;
                    default:
                        System.out.println("Inputkan Angka 1 - 4");
                        menuAnggota();
                }
            } while (a < 1);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Harus Berupa Angka");
            menuAnggota();
        }
    }
}
