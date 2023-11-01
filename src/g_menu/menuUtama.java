package g_menu;

import e_controller.anggotaController;
import e_controller.userController;
import f_extends.turunanController;
import java.io.IOException;

public class menuUtama extends turunanController {

    public menuUtama() {
        try {
            do {
                System.out.println("------ Main Menu ------");
                System.out.println("|   1. Admin          |");
                System.out.println("|   2. Anggota        |");
                System.out.println("|   3. Exit           |");
                System.out.println("-----------------------");
                System.out.print("Login Sebagai : ");
                pil = Integer.parseInt(br.readLine());
                switch (pil) {
                    case 1:
                        userController uc = new userController();
                        uc.loginAdmin();
                        break;
                    case 2:
                        anggotaController ac = new anggotaController();
                        ac.loginAnggota();
                        break;
                    case 3:
                        System.out.println("\nTerima Kasih Telah Menggunakan Program Kami\n");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Inputkan Angka 1 -3");
                        menuUtama();
                        break;
                }
            } while (a < 1);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Inputan Harus Berupa Angka");
            menuUtama() ;
        }
    }

    public static void main(String[] args) {
        menuUtama();
    }
}
