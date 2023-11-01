package d_implement;

import b_entity.trx_pinjam;
import c_interface.trxInterface;
import f_extends.turunan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class trxImplement extends turunan implements trxInterface {

    String update;

    @Override
    public List<trx_pinjam> viewDataPeminjaman() {
        List<trx_pinjam> tList = new ArrayList<>();
        sql = "SELECT a.id, b.nama, c.judul, "
                + "DATE_FORMAT(tgl_pinjam,'%a,%Y-%m-%d') as tgl_pinjam, "
                + " if(DATE_FORMAT(tgl_kembali,'%a,%Y-%m-%d') is null,'-',"
                + "DATE_FORMAT(tgl_kembali,'%a,%Y-%m-%d')) as tgl_kembali,a.denda "
                + "FROM `trx_pinjam` a left join mst_anggota b on b.id = a.id_anggota "
                + "left join mst_buku c on c.id = a.id_buku ";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            while (rs.next()) {
                trx_pinjam pj = new trx_pinjam();
                pj.setId(rs.getInt("id"));
                pj.setNama(rs.getString("nama"));
                pj.setJudul(rs.getString("judul"));
                pj.setTgl_pinjam(rs.getString("tgl_pinjam"));
                pj.setTgl_kembali(rs.getString("tgl_kembali"));
                pj.setDenda(rs.getInt("denda"));
                tList.add(pj);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Tampil Data " + e + "\n");

        }
        return tList;

    }

    @Override
    public List<trx_pinjam> viewYangMasihMeminjam() {
        List<trx_pinjam> tpList = new ArrayList<>();
        sql = "select p.id,a.nama,b.judul,DATE_FORMAT(tgl_pinjam,'%a,%Y-%m-%d') as tgl_pinjam,p.tgl_kembali "
                + "from mst_buku b,mst_anggota a,trx_pinjam p "
                + "where p.id_anggota=a.id and p.id_buku=b.id and p.tgl_kembali is null";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            while (rs.next()) {
                trx_pinjam tpj = new trx_pinjam();
                tpj.setId(rs.getInt("id"));
                tpj.setNama(rs.getString("nama"));
                tpj.setJudul(rs.getString("judul"));
                tpj.setTgl_pinjam(rs.getString("tgl_pinjam"));
                tpj.setTgl_kembali(rs.getString("tgl_kembali"));
                tpList.add(tpj);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Tampil Data " + e + "\n");

        }
        return tpList;
    }

    @Override
    public List<trx_pinjam> pengembalian(int id) {
        List<trx_pinjam> txList = new ArrayList<>();
        sql = "select tp.id,tp.id_buku, ma.nama, mb.judul, DATE_FORMAT(tgl_pinjam,'%a,%Y-%m-%d') as tgl_pinjam, "
                + " if(DATE_FORMAT(tgl_kembali,'%a,%Y-%m-%d') is null,'-',DATE_FORMAT(tgl_kembali,'%a,%Y-%m-%d')) as tgl_kembali, tp.denda "
                + "from mst_buku mb, mst_anggota ma, trx_pinjam tp "
                + "where tp.id_anggota = ma.id and tp.id_buku = mb.id and tp.id='" + id + "' and tp.tgl_kembali is null";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            while (rs.next()) {
                trx_pinjam tp = new trx_pinjam();
                tp.setId(rs.getInt("id"));
                tp.setId_buku(rs.getInt("id_buku"));
                tp.setNama(rs.getString("nama"));
                tp.setJudul(rs.getString("judul"));
                tp.setTgl_pinjam(rs.getString("tgl_pinjam"));
                tp.setTgl_kembali(rs.getString("tgl_kembali"));
                tp.setDenda(rs.getInt("denda"));
                txList.add(tp);
            }
        } catch (SQLException e) {
            System.out.println("\nGagal Tampil Pengembalian " + e + "\n");
        }
        return txList;
    }

    @Override
    public trx_pinjam searchId(int id) {
        trx_pinjam tp = new trx_pinjam();
        tp.setAda(false);
        sql = "select * from trx_pinjam where id='" + id + "'";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            if (rs.next()) {
                tp.setId(rs.getInt("id"));
                tp.setId_anggota(rs.getInt("id_anggota"));
                tp.setId_buku(rs.getInt("id_buku"));
                tp.setTgl_pinjam(rs.getString("tgl_pinjam"));
                tp.setTgl_kembali(rs.getString("tgl_kembali"));
                tp.setDenda(rs.getInt("denda"));
                tp.setAda(true);
            }
        } catch (Exception e) {
            System.out.println("\nGagal Cari ID " + e + "\n");
        }
        return tp;
    }

    @Override
    public String insertBuku(trx_pinjam pinjam) {
        sql = "insert into trx_pinjam (id_anggota,id_buku,tgl_pinjam) values('" + pinjam.getId_anggota() + "','" + pinjam.getId_buku() + "',CURRENT_DATE) ";
        update = "update mst_buku set jumlah = jumlah - 1 where id='" + pinjam.getId_buku() + "'";
        try {
            aStatement().executeUpdate(sql);
            aStatement().executeUpdate(update);
            hasil = "\nInsert Sukses\n";
        } catch (SQLException e) {
            hasil = "\nInsert Gagal " + e + "\n";
        }
        return hasil;
    }

    @Override
    public void tambahBuku(int id) {
        sql = "update mst_buku set jumlah = jumlah + 1 where id='" + id + "'";
        try {
            aStatement().executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("gagal tambah buku");
        }
    }

    @Override
    public void kembalikanBuku(int id) {
        sql = "update trx_pinjam set tgl_kembali = CURRENT_DATE where id = '" + id + "'";
        update = "update trx_pinjam set denda = (SELECT if (DATEDIFF(tgl_kembali,tgl_pinjam)<=7, 0, DATEDIFF(tgl_kembali,tgl_pinjam)-7)*500)"
                + " WHERE id = " + id + "";
        try {
            aStatement().executeUpdate(sql);
            aStatement().executeUpdate(update);
        } catch (SQLException e) {
            System.out.println("\nGagal Kembalikan Buku\n");
        }
    }

    @Override
    public int denda(int id) {
        hasill = 0;
        sql = "select denda from trx_pinjam where id = '" + id + "'";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            if (rs.next()) {
                hasill = rs.getInt("denda");
            }
        } catch (Exception e) {
            System.out.println("Gagal Denda");
        }
        return hasill;
    }

    @Override
    public int kasDenda() {
        hasill = 0;
        sql = "select sum(denda) as kas_denda from trx_pinjam";
        try {
            ResultSet rs = aStatement().executeQuery(sql);
            if (rs.next()) {
                hasill = rs.getInt("kas_denda");
            }
        } catch (SQLException e) {
            System.out.println("Kas Denda Gagal " + e);
        }
        return hasill;
    }
}
