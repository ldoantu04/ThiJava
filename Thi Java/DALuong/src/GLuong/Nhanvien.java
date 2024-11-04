/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

/**
 *
 * @author HP
 */
public class Nhanvien extends Person{    
    private String Diachi;
    private int Luong;
    public Nhanvien(){};
    public Nhanvien(String MaNV, String TenNV, String Diachi, int Luong){
        super(MaNV, TenNV);
        this.Diachi = Diachi;
        this.Luong = Luong;
    }
    
    public String getDiaChi(){
        return Diachi;
    }
    public void setDiaChi(String Diachi){
        this.Diachi = Diachi;
    }
    
    public int getLuong(){
        return Luong;
    }
    
    public void setLuong(int Luong){
        this.Luong = Luong;
    }
}
