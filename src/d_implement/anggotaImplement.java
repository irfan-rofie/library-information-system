package d_implement;

import b_entity.mst_anggota;
import c_interface.anggotaInterface;
import f_extends.turunan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class anggotaImplement extends turunan implements anggotaInterface {

    @Override
    public String insertAnggota(mst_anggota mAnggota) {
        sql = "insert into mst_anggota values(null,?,?,?,?,?)";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mAnggota.getNama());
            ps.setString(2, mAnggota.getAlamat());
            ps.setString(3, mAnggota.getPekerjaan());
            ps.setInt(4, mAnggota.getUmur());
            ps.setString(5, mAnggota.getPassword());
            ps.executeUpdate();
            hasil = "\nInsert Sukses\n";
        } catch (SQLException e) {
            hasil = "\nInsert Gagal" + e + "\n";
        }
        return hasil;
    }

    @Override
    public String updateAnggota(mst_anggota mAnggota) {
        sql = "update mst_anggota set nama=?, alamat=?, pekerjaan=?, umur=? where id=? ";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(5, mAnggota.getId());
            ps.setString(1, mAnggota.getNama());
            ps.setString(2, mAnggota.getAlamat());
            ps.setString(3, mAnggota.getPekerjaan());
            ps.setInt(4, mAnggota.getUmur());
            ps.executeUpdate();
            hasil = "\nUpdate Sukses\n";
        } catch (SQLException e) {
            hasil = "\nUpdate Gagal" + e + "\n";
        }
        return hasil;
    }

    @Override
    public String deleteAnggota(mst_anggota mAnggota) {
        sql = "delete from mst_anggota where id='" + mAnggota.getId() + "'";
        try {
            aStatement().executeUpdate(sql);
            hasil = "\nDelete Sukses\n";
        } catch (SQLException e) {
            hasil = "\nDelete Gagal " + e + "\n";
        }
        return hasil;
    }

    @Override
    public List<mst_anggota> viewAnggota() {
        List<mst_anggota> maList = new ArrayList<>();
        sql = "select * from mst_anggota";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            while (rs.next()) {
                mst_anggota ma = new mst_anggota();
                ma.setId(rs.getInt("id"));
                ma.setNama(rs.getString("nama"));
                ma.setAlamat(rs.getString("alamat"));
                ma.setPekerjaan(rs.getString("pekerjaan"));
                ma.setUmur(rs.getInt("umur"));
                ma.setPassword(rs.getString("password"));
                maList.add(ma);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Tampil Data" + e + "\n");
        }
        return maList;
    }

    @Override
    public List<mst_anggota> loginAnggota(String nama, String password) {
        List<mst_anggota> mList = new ArrayList<>();
        sql = "select * from mst_anggota where nama=? and password=?";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mst_anggota ma = new mst_anggota();
                ma.setId(rs.getInt("id"));
                ma.setNama(rs.getString("nama"));
                ma.setAlamat(rs.getString("alamat"));
                ma.setPekerjaan(rs.getString("pekerjaan"));
                ma.setUmur(rs.getInt("umur"));
                ma.setPassword(rs.getString("password"));
                mList.add(ma);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal login " + e + "\n");
        }
        return mList;
    }

    @Override
    public mst_anggota searchId(int id) {
        mst_anggota ma = new mst_anggota();
        ma.setAda(false);
        sql = "select * from mst_anggota where id=" + id + "";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            if (rs.next()) {
                ma.setId(rs.getInt("id"));
                ma.setNama(rs.getString("nama"));
                ma.setAlamat(rs.getString("alamat"));
                ma.setPekerjaan(rs.getString("pekerjaan"));
                ma.setPassword(rs.getString("password"));
                ma.setAda(true);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Cari ID " + e + "\n");
        }
        return ma;
    }

    @Override
    public List<mst_anggota> searchName(String nama) {
        List<mst_anggota> maList = new ArrayList<>();
        sql = "select * from mst_anggota where nama like '%" + nama + "%' ";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            while (rs.next()) {
                mst_anggota ma = new mst_anggota();
                ma.setId(rs.getInt("id"));
                ma.setNama(rs.getString("nama"));
                ma.setAlamat(rs.getString("alamat"));
                ma.setPekerjaan(rs.getString("pekerjaan"));
                ma.setUmur(rs.getInt("umur"));
                maList.add(ma);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Cari Nama " + e + "\n");
        }
        return maList;
    }

    @Override
    public int cariPass(int id, String pass) {
        sql = "select * from mst_anggota where id='" + id + "' and password='" + pass + "'";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            if (rs.next()) {
                hasill = 1;
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Cari Password " + e + "\n");
        }
        return hasill;
    }

    @Override
    public String updatePassword(mst_anggota mAgt) {
        sql = "update mst_anggota set password=? where id=?";
        try {
            Connection con = kon.openCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, mAgt.getId());
            ps.setString(1, mAgt.getPassword());
            ps.executeUpdate();
            hasil = "\nUpdate Sukses\n";
        } catch (SQLException e) {
            hasil = "\nUpdate Gagal" + e + "\n";
        }
        return hasil;
    }
}
