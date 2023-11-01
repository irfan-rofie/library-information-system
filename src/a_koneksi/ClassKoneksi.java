package a_koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ClassKoneksi {

    private Connection con;

    public Connection openCon() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan", "root", "");
            //System.out.println("koneksi sukses");
        } catch (SQLException e) {
            System.out.println("koneksi gagal " + e);
        }
        return con;
    }

    public Connection closeCon() {

        try {
            if (con != null) {
                con.close();
                //System.out.println("koneksi berhasil di tutup");
            }
        } catch (SQLException e) {
            System.out.println("koneksi gagal di tutup " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        ClassKoneksi kon = new ClassKoneksi();
        kon.openCon();
        kon.closeCon();
    }
}
