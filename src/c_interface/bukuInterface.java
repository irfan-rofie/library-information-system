package c_interface;

import b_entity.mst_buku;
import java.util.List;

public interface bukuInterface {

    String insertBuku(mst_buku mBuku);

    String updateBuku(mst_buku mBuku);

    String deleteBuku(mst_buku mBuku);

    mst_buku searchId(int id);

    List<mst_buku> viewBuku();

//    List<mst_buku> viewBukuTrx(int id);
}
