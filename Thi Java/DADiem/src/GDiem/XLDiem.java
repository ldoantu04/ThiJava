package GDiem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XLDiem implements IHocvien {
    // Phương thức kết nối cơ sở dữ liệu
    @Override
    public Connection getCon() {
        Connection cn = null;
        try {        
            String url = "jdbc:sqlserver://LAPTOP-EL5JURKA:1433;databaseName=DLDiem;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "12345a";
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Microsoft SQL Server");
            
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return cn;
    }

    // Phương thức lấy danh sách học viên theo lớp
    @Override
    public List<Hocvien> getHVbyLop(String Lop) {
        List<Hocvien> dsHocvien = new ArrayList<>();
        String sql = "SELECT * FROM tbHocvien WHERE Lop = ?";
        
        try (PreparedStatement stmt = getCon().prepareStatement(sql)) {
            stmt.setString(1, Lop);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Hocvien hv = new Hocvien(
                    rs.getString("MaHV"),
                    rs.getString("Hoten"),
                    rs.getString("Lop"),
                    rs.getString("GT"),
                    rs.getInt("Diem")
                );
                dsHocvien.add(hv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHocvien;
    }

    // Phương thức lấy danh sách học viên theo lớp và giới tính
    @Override
    public List<Hocvien> getHVbyLopGT(String Lop, String GT) {
        List<Hocvien> dsHocvien = new ArrayList<>();
        String sql = "SELECT * FROM tbHocvien WHERE Lop = ? AND GT = ?";
        
        try (PreparedStatement stmt = getCon().prepareStatement(sql)) {
            stmt.setString(1, Lop);
            stmt.setString(2, GT);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Hocvien hv = new Hocvien(
                    rs.getString("MaHV"),
                    rs.getString("Hoten"),
                    rs.getString("Lop"),
                    rs.getString("GT"),
                    rs.getInt("Diem")
                );
                dsHocvien.add(hv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHocvien;
    }
}
