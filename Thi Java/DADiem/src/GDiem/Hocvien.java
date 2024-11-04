package GDiem;

public class Hocvien {
    private String MaHV;
    private String Hoten;
    private String Lop;
    private String GT;
    private int Diem;
    
    public Hocvien(){};
    public Hocvien(String MaHV, String Hoten, String Lop, String GT, int Diem){
        this.MaHV = MaHV;
        this.Hoten = Hoten;
        this.Lop = Lop;
        this.GT = GT;
        this.Diem = Diem;
    }
       
    public String getMaHV(){
        return MaHV;
    }
    public void setMaHV(String MaHV){
        this.MaHV = MaHV;
    }
    
    public String getHoTen(){
        return Hoten;
    }
    public void setHoTen(String Hoten){
        this.Hoten = Hoten;
    }
    
    public String getGT(){
        return GT;
    }
    public void setGT(String GT){
        this.GT = GT;
    }
    
    public String getLop(){
        return Lop;
    }
    public void setLop(String Lop){
        this.Lop = Lop;
    }
    
    public int getDiem(){
        return Diem;
    }
    public void setDiem(int Diem){
        this.Diem = Diem;
    }
    
    public String Ketqua(){
        return Diem >= 20 ? "Đỗ" : "Trượt";
    }

}
