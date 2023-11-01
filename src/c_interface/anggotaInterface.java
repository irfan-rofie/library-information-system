package c_interface;

import b_entity.mst_anggota;
import java.util.List;

public interface anggotaInterface {

    String insertAnggota(mst_anggota mAnggota);

    String updateAnggota(mst_anggota mAnggota);

    String deleteAnggota(mst_anggota mAnggota);

    List<mst_anggota> loginAnggota(String nama, String password);

    mst_anggota searchId(int id);

    List<mst_anggota> searchName(String nama);

    List<mst_anggota> viewAnggota();

    int cariPass(int id, String pass);

    String updatePassword(mst_anggota mAgt);
}
