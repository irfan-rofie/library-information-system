package e_controller;

import b_entity.mst_anggota;
import f_extends.turunanController;
import java.io.IOException;
import java.util.List;

public class anggotaController extends turunanController {

    public void insertAnggota() throws IOException {
        try {
            System.out.println("--- Insert Anggota ---");
            System.out.print("Nama      : ");
            ma.setNama(br.readLine());
            System.out.print("Alamat    : ");
            ma.setAlamat(br.readLine());
            System.out.print("Pekerjaan : ");
            ma.setPekerjaan(br.readLine());
            System.out.print("Umur      : ");
            ma.setUmur(Integer.parseInt(br.readLine()));
            if ((ma.getUmur() < 8) || (ma.getUmur() > 50)) {
                System.out.println("Umur Minimal 8 Tahun dan Maksimal 50 Tahun");
                insertAnggota();
            } else {
                System.out.print("Password  : ");
                ma.setPassword(br.readLine());
                System.out.println("----------------------");
                System.out.println(ai.insertAnggota(ma));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("-----------------------------");
            System.out.println("| Inputkan Angka Untuk Umur |");
            System.out.println("-----------------------------");
            insertAnggota();
        }
    }

    public void updateAnggota() throws IOException {
        try {
            System.out.println("--- Update Anggota ---");
            System.out.print("ID        : ");
            ma.setId(Integer.parseInt(br.readLine()));
            ma = ai.searchId(ma.getId());
            if (ma.isAda()) {
                System.out.println("------------------");
                System.out.print("Nama      : ");
                ma.setNama(br.readLine());
                System.out.print("Alamat    : ");
                ma.setAlamat(br.readLine());
                System.out.print("Pekerjaan : ");
                ma.setPekerjaan(br.readLine());
                System.out.print("Umur      : ");
                ma.setUmur(Integer.parseInt(br.readLine()));
                if ((ma.getUmur() < 8) || (ma.getUmur() > 50)) {
                    System.out.println("Umur Minimal 8 Tahun dan Maksimal 50 Tahun");
                    insertAnggota();
                } else {
                    System.out.println("------------------");
                    System.out.println(ai.updateAnggota(ma));
                }
            } else {
                System.out.println("----------------------");
                System.out.println("| ID Tidak Ditemukan |");
                System.out.println("----------------------");
                updateAnggota();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("------------------");
            System.out.println("| Inputkan Angka |");
            System.out.println("------------------");
            updateAnggota();
        }
    }

    public void deleteAnggota() throws IOException {
        try {
            System.out.println("--- Delete Anggota ---");
            System.out.print("ID    : ");
            ma.setId(Integer.parseInt(br.readLine()));
            ma = ai.searchId(ma.getId());
            if (ma.isAda()) {
                System.out.println("------------------");
                System.out.println(ai.deleteAnggota(ma));
            } else {
                System.out.println("----------------------");
                System.out.println("| ID Tidak Ditemukan |");
                System.out.println("----------------------");
                deleteAnggota();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("------------------");
            System.out.println("| Inputkan Angka |");
            System.out.println("------------------");
            deleteAnggota();
        }
    }

    public void viewAnggota() throws IOException {
        try {
            System.out.println("--- View Anggota ---");
            List<mst_anggota> maList = ai.viewAnggota();
            for (mst_anggota mag : maList) {
                System.out.println("----------------------------");
                System.out.println("ID          : " + mag.getId());
                System.out.println("Nama        : " + mag.getNama());
                System.out.println("Alamat      : " + mag.getAlamat());
                System.out.println("Pekerjaan   : " + mag.getPekerjaan());
                System.out.println("Umur        : " + mag.getUmur());
            }
            System.out.println("----------------------------");
        } catch (Exception e) {
        }
    }

    public void loginAnggota() throws IOException {
        try {
            System.out.println("----------------");
            System.out.print("Username : ");
            nama = br.readLine();
            System.out.print("Password : ");
            password = br.readLine();
            System.out.println("----------------");
            List<mst_anggota> maList = ai.loginAnggota(nama, password);
            if (maList.isEmpty()) {
                System.out.println("Login Gagal");
                loginAnggota();
            } else {
                ma = maList.get(0);
                simpanId = ma.getId();
                menuAnggota();
            }
        } catch (Exception e) {
        }
    }

    public void updatePassword() throws IOException {
        try {
            System.out.println("--- Update Password ---");
            System.out.print("Password Lama       : ");
            password = br.readLine();
            System.out.println("---------------------");
            hasil = ai.cariPass(simpanId, password);
            if (hasil == 1) {
                System.out.print("Password Baru     : ");
                passBaru = br.readLine();
                System.out.print("password ulang    : ");
                passUlang = br.readLine();
                if (passBaru.equalsIgnoreCase(passUlang)) {
                    ma.setId(simpanId);
                    ma.setPassword(passBaru);
                    System.out.println(ai.updatePassword(ma));
                } else {
                    System.out.println("Password Tidak Sama");
                    updatePassword();
                }
            } else {
                System.out.println("Password Salah");
                updatePassword();
            }
        } catch (Exception e) {
        }
    }
}
