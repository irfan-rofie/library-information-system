package d_implement;

import b_entity.mst_user;
import c_interface.userInterface;
import f_extends.turunan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userImplement extends turunan implements userInterface {

    @Override
    public String insertAdmin(mst_user mUser) {
        sql = "insert into mst_user values (null,?,?)";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mUser.getNama());
            ps.setString(2, mUser.getPass());
            ps.executeUpdate();
            hasil = "\nInsert Sukses\n";
        } catch (SQLException e) {
            hasil = "\nInsert Gagal" + e + "\n";
        }
        return hasil;
    }

    @Override
    public String updatePass(mst_user mUser) {
        sql = "update mst_user set pass=? where id=?";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, mUser.getId());
            ps.setString(1, mUser.getPass());
            ps.executeUpdate();
            hasil = "\nUpdate Sukses\n";
        } catch (SQLException e) {
            hasil = "\nUpdate Gagal " + e + "\n";
        }
        return hasil;
    }

    @Override
    public List<mst_user> login(String nama, String pass) {
        List<mst_user> mList = new ArrayList<>();
        sql = "select * from mst_user where nama=? and pass=?";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mst_user mu = new mst_user();
                mu.setId(rs.getInt("id"));
                mu.setNama(rs.getString("nama"));
                mu.setPass(rs.getString("pass"));
                mList.add(mu);
            }
        } catch (SQLException e) {
            System.out.println("\nLogin Gagal " + e + "\n");
        }
        return mList;
    }

    @Override
    public int cariPass(int id, String pass) {
        sql = "select * from mst_user where id=? and pass=?";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hasill = 1;
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Cari Password " + e + "\n");
        }
        return hasill;
    }
}
