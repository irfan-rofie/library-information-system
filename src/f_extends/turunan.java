package f_extends;

import a_koneksi.ClassKoneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class turunan {

    protected String sql, hasil;
    protected ClassKoneksi kon = new ClassKoneksi();
    protected int hasill = 0;

    protected Statement aStatement() {
        Statement st = null;
        try {
            Connection con = kon.openCon();
            st = con.createStatement();
        } catch (SQLException e) {
            System.out.println("error get statement " + e);
        }
        return st;
    }
}
