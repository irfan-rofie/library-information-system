package g_menu;

import f_extends.turunanController;
import h_subMenu.subMenuAdmin;
import java.io.IOException;

public class menuAdmin extends turunanController {

    subMenuAdmin subAdm = new subMenuAdmin();

    public menuAdmin() throws IOException {
        try {
            do {
                System.out.println("---------- Menu Admin ----------");
                System.out.println("|   1. Pengelolaan Admin        |");
                System.out.println("|   2. Pengelolaan Anggota      |");
                System.out.println("|   3. Pengelolaan Buku         |");
                System.out.println("|   4. Pengelolaan Transaksi    |");
                System.out.println("|   5. Logout                   |");
                System.out.println("---------------------------------");
                System.out.print("Pilih : ");
                pil = Integer.parseInt(br.readLine());
                switch (pil) {
                    case 1:
                        subAdm.pengelolaanAdmin();
                        break;
                    case 2:
                        subAdm.pengelolaanAnggota();
                        break;
                    case 3:
                        subAdm.pengelolaanBuku();
                        break;
                    case 4:
                        subAdm.pengelolaanTransaksi();
                        break;
                    case 5:
                        menuUtama();
                        break;
                    default:
                        System.out.println("Inputkan Angka 1 - 5");
                        menuAdmin();
                        break;
                }
            } while (a < 1);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Harus Berupa Angka !!!");
            menuAdmin();
        }
    }
}