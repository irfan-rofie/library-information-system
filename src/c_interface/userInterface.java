package c_interface;

import b_entity.mst_user;
import java.util.List;

public interface userInterface {

    String insertAdmin(mst_user mUser);

    String updatePass(mst_user mUser);

    List<mst_user> login(String nama, String pass);

    int cariPass(int id, String pass);
}
