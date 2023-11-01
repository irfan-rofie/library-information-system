package e_controller;

import b_entity.mst_user;
import f_extends.turunanController;
import h_subMenu.subMenuAdmin;
import java.io.IOException;
import java.util.List;

public class userController extends turunanController {

    public void insertAdmin() throws IOException {
        System.out.println("----- Insert Admin -----");
        System.out.print("Nama : ");
        mu.setNama(br.readLine());
        System.out.print("Pass : ");
        mu.setPass(br.readLine());
        System.out.println("------------------------");
        System.out.println(u.insertAdmin(mu));
        subMenuAdmin sma = new subMenuAdmin();
        sma.pengelolaanAdmin();
    }

    public void updatePassword() throws IOException {
        System.out.println("----- Update Password -----");
        System.out.print("Password Lama : ");
        password = br.readLine();
        System.out.println("---------------------------");
        hasil = u.cariPass(simpanId, password);
        if (hasil == 1) {
            System.out.println("---------------------------");
            System.out.print("Password Baru     : ");
            passBaru = br.readLine();
            System.out.print("Password Ulang    : ");
            passUlang = br.readLine();
            System.out.println("---------------------------");
            if (passBaru.equalsIgnoreCase(passUlang)) {
                mu.setId(simpanId);
                mu.setPass(passBaru);
                System.out.println(u.updatePass(mu));
                subMenuAdmin sma = new subMenuAdmin();
                sma.pengelolaanAdmin();
            } else {
                System.out.println("---------------------------");
                System.out.println("|   Password Tidak Sama   |");
                System.out.println("---------------------------");
                updatePassword();
            }
        } else {
            System.out.println("---------------------------");
            System.out.println("|      Password Salah     |");
            System.out.println("---------------------------");
            updatePassword();
        }
    }

    public void loginAdmin() throws IOException {
        System.out.println("-----------------------");
        System.out.print("Username : ");
        nama = br.readLine();
        System.out.print("Password : ");
        password = br.readLine();
        System.out.println("-----------------------");
        List<mst_user> mList = u.login(nama, password);
        if (mList.isEmpty()) {
            System.out.println("Username atau Password Salah");
            loginAdmin();
        } else {
            mu = mList.get(0);
            simpanId = mu.getId();
            menuAdmin();
        }
    }
}
