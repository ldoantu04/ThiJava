package GDiem;

import java.sql.Connection;
import java.util.List;

public interface IHocvien {
    Connection getCon();
    List<Hocvien> getHVbyLop(String Lop);
    List<Hocvien> getHVbyLopGT(String Lop, String GT);
}
