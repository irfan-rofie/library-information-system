package d_implement;

import b_entity.mst_buku;
import c_interface.bukuInterface;
import f_extends.turunan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bukuImplement extends turunan implements bukuInterface {

    @Override
    public String insertBuku(mst_buku mBuku) {
        sql = "insert into mst_buku values('" + mBuku.getId() + "','" + mBuku.getJudul() + "',"
                + "'" + mBuku.getPenulis() + "','" + mBuku.getJumlah() + "')";
        try {
            aStatement().executeUpdate(sql);
            hasil = "\nInsert Sukses\n";
        } catch (SQLException e) {
            hasil = "\nInsert Gagal " + e + "\n";
        }
        return hasil;
    }

    @Override
    public String updateBuku(mst_buku mBuku) {
        sql = "update mst_buku set judul='" + mBuku.getJudul() + "',penulis='" + mBuku.getPenulis() + "',"
                + "jumlah='" + mBuku.getJumlah() + "' where id='" + mBuku.getId() + "'";
        try {
            aStatement().executeUpdate(sql);
            hasil = "\nUpdate Sukses\n";
        } catch (SQLException e) {
            hasil = "\nUpdate Gagal " + e + "\n";
        }
        return hasil;
    }

    @Override
    public String deleteBuku(mst_buku mBuku) {
        sql = "delete from mst_buku where id='" + mBuku.getId() + "'";
        try {
            aStatement().executeUpdate(sql);
            hasil = "\nDelete Sukses\n";
        } catch (SQLException e) {
            hasil = "\nDelete Gagal " + e + "\n";
        }
        return hasil;
    }

    @Override
    public mst_buku searchId(int id) {
        mst_buku mb = new mst_buku();
        mb.setAda(false);
        sql = "select * from mst_buku where id='" + id + "'";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            if (rs.next()) {
                mb.setId(rs.getInt("id"));
                mb.setJudul(rs.getString("judul"));
                mb.setPenulis(rs.getString("penulis"));
                mb.setJumlah(rs.getInt("jumlah"));
                mb.setAda(true);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Cari ID " + e + "\n");
        }
        return mb;
    }

    @Override
    public List<mst_buku> viewBuku() {
        List<mst_buku> mbList = new ArrayList<>();
        sql = "select*from mst_buku";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            while (rs.next()) {
                mst_buku mBuku = new mst_buku();
                mBuku.setId(rs.getInt("id"));
                mBuku.setJudul(rs.getString("judul"));
                mBuku.setPenulis(rs.getString("penulis"));
                mBuku.setJumlah(rs.getInt("jumlah"));
                mbList.add(mBuku);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Tampil Buku " + e + "\n");
        }
        return mbList;
    }
}
