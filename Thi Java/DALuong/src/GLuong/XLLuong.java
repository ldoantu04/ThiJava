package GLuong;
import java.sql.*;

public class XLLuong {
    // Phương thức kết nối đến cơ sở dữ liệu DLLuong
    public Connection getCon(){
        Connection cn = null;
        try{
            String url = "jdbc:sqlserver://LAPTOP-EL5JURKA:1433;databaseName=DLLuong;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "12345a";
            cn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to sql server");
            
        }catch (Exception e){
            System.out.println("Connect Failed: " + e.getMessage());
        }
        return cn;
    }

    // Lấy thông tin nhân viên theo MaNV
    public Nhanvien getNVbyMa(String MaNV) {
        try (Connection conn = getCon();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tbNhanvien WHERE MaNV = ?")) {
            stmt.setString(1, MaNV);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String hoten = rs.getString("Hoten");
                String diachi = rs.getString("Diachi");
                int luong = rs.getInt("Luong");
                return new Nhanvien(MaNV, hoten, diachi, luong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin nhân viên theo MaNV
    public boolean updateNVbyMa(Nhanvien nv) {
        try (Connection conn = getCon();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE tbNhanvien SET Hoten = ?, Diachi = ?, Luong = ? WHERE MaNV = ?")) {
            stmt.setString(1, nv.getTenNV());
            stmt.setString(2, nv.getDiaChi());
            stmt.setInt(3, nv.getLuong());
            stmt.setString(4, nv.getMaNV());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}





///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package GLuong;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
///**
// *
// * @author Le doan tu
// */
//public class XLLuong {
//    public Connection getCon(){
//        Connection cn = null;
//        try{
//            String url = "jdbc:sqlserver://LAPTOP-EL5JURKA:1433;databaseName=DLLuong;encrypt=true;trustServerCertificate=true";
//            String username = "sa";
//            String password = "12345a";
//            cn = DriverManager.getConnection(url, username, password);
//            System.out.println("Connected to sql server");
//            
//        }catch (Exception e){
//            System.out.println("Connect Failed: " + e.getMessage());
//        }
//        return cn;
//    }
//    
////    public List<Nhanvien> getNVbyMa(String MaNV){
////        List<Nhanvien> dsNhanviens = new ArrayList<>();
////        String sql = "select * from tbNhanvien where MaNV = ?";
////        try (PreparedStatement ps = getCon().prepareStatement(sql)){
////            ps.setString(1, MaNV);
////            ResultSet rs = ps.executeQuery();
////            
////            while (rs.next()){
////                Nhanvien nv = new Nhanvien(
////                        rs.getString("MaNV"),
////                        rs.getString("Hoten"),
////                        rs.getString("Diachi"),
////                        rs.getInt("Luong")
////                );
////                dsNhanviens.add(nv);
////            }
////        } catch (Exception e){
////            System.out.println("Error: " +e.getMessage());
////        }
////        return dsNhanviens;
////    }
////    
////    public List<Nhanvien> updateNV(Nhanvien nv){
////        List<Nhanvien> updateNhanviens = new ArrayList<>();
////        String sql = "UPDATE tbKH SET Hoten=?, Diachi=?, Luong=? WHERE MaNV=?";
////
////        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
////            ps.setString(1, nv.getTenNV());
////            ps.setString(2, nv.getDiaChi());
////            ps.setInt(3, nv.getLuong());
////            ps.setString(4, nv.getMaNV());
////
////            ps.executeUpdate();
////
////            updateNhanviens.add(nv);
////        } catch (SQLException e) {
////            System.out.println("Error: " + e.getMessage());
////        }
////        return updateNhanviens;
////    }
//    
//    public Nhanvien getNVbyMa(String MaNV){
//        String sql = "select * from tbNhanvien where MaNV = ?";
//        try (PreparedStatement ps = getCon().prepareStatement(sql)){
//            ps.setString(1,MaNV);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()){
//                return new Nhanvien(
//                    rs.getString("MaNV"),
//                    rs.getString("Hoten"),
//                    rs.getString("Diachi"),
//                    rs.getInt("Luong")
//                );
//            }
//        } catch (Exception e){
//            System.out.println("Error: " + e.getMessage());
//        }
//        return null;
//    }
//    public void updateNV (Nhanvien nv){
//        String update = "update tbNhanvien set Hoten=?, Diachi=?, Luong=? where MaNV=?";
//        try (PreparedStatement ps = getCon().prepareStatement(update)){
//            ps.setString(1, nv.getMaNV());
//            ps.setString(2, nv.getTenNV());
//            ps.setString(3, nv.getDiaChi());
//            ps.setInt(4, nv.getLuong());
//            ps.setString(5, nv.getMaNV());
//        } catch (Exception e){
//            System.out.println("Error: " + e.getMessage());
//        }
//
//    }
//}