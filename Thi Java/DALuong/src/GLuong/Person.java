/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

public class Person {
    private String MaNV;
    private String TenNV;
    
    public Person(){};
    
    public Person(String MaNV, String TenNV){
        this.MaNV = MaNV;
        this.TenNV = TenNV;
    }
    
    public String getMaNV(){
        return MaNV;
    }
    public void setMaNV(String MaNV){
        this.MaNV = MaNV;
    }
    
    public String getTenNV(){
        return TenNV;
    }
    public void setTenNV(String TenNV){
        this.MaNV = TenNV;
    }
}
