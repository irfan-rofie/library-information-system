package c_interface;

import b_entity.trx_pinjam;
import java.util.List;

public interface trxInterface {

    List<trx_pinjam> viewDataPeminjaman();

    List<trx_pinjam> viewYangMasihMeminjam();

    List<trx_pinjam> pengembalian(int id);

    trx_pinjam searchId(int id);

    String insertBuku(trx_pinjam pinjam);

    void kembalikanBuku(int id);

    int denda(int id);

    int kasDenda();

    void tambahBuku(int id);
}
