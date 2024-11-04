
package GLuong;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_updateNV extends JFrame {
    private JTextField txtMaNV, txtHoten, txtLuong;
    private JComboBox<String> cbDiachi;
    private JButton btnTimKiem, btnCapNhat;
    private XLLuong xlLuong;

    public GUI_updateNV() {
        xlLuong = new XLLuong();

        setTitle("Cập nhật nhân viên");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Thêm JLabel mô tả cho các JTextField
        JLabel lblMaNV = new JLabel("Mã NV:");
        JLabel lblHoten = new JLabel("Họ tên:");
        JLabel lblLuong = new JLabel("Lương:");
        JLabel lblDiachi = new JLabel("Địa chỉ:");

        // Các thành phần giao diện
        txtMaNV = new JTextField();
        txtHoten = new JTextField();
        txtLuong = new JTextField();
        cbDiachi = new JComboBox<>(new String[]{"Hải Phòng", "Hà Nội", "Nam Định"});
        btnTimKiem = new JButton("Tìm kiếm nhân viên");
        btnCapNhat = new JButton("Cập nhật nhân viên");

        // Đặt vị trí các JLabel
        lblMaNV.setBounds(30, 30, 50, 25);
        lblHoten.setBounds(30, 70, 50, 25);
        lblLuong.setBounds(30, 110, 50, 25);
        lblDiachi.setBounds(30, 150, 50, 25);

        // Đặt vị trí các thành phần
        txtMaNV.setBounds(100, 30, 150, 25);
        txtHoten.setBounds(100, 70, 150, 25);
        txtLuong.setBounds(100, 110, 150, 25);
        cbDiachi.setBounds(100, 150, 150, 25);
        btnTimKiem.setBounds(270, 30, 150, 25);
        btnCapNhat.setBounds(270, 70, 150, 25);

        // Thêm các JLabel và thành phần vào JFrame
        add(lblMaNV);
        add(lblHoten);
        add(lblLuong);
        add(lblDiachi);
        add(txtMaNV);
        add(txtHoten);
        add(txtLuong);
        add(cbDiachi);
        add(btnTimKiem);
        add(btnCapNhat);

        // Sự kiện tìm kiếm nhân viên
        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String MaNV = txtMaNV.getText();
                Nhanvien nv = xlLuong.getNVbyMa(MaNV);
                if (nv != null) {
                    txtHoten.setText(nv.getTenNV());
                    txtLuong.setText(String.valueOf(nv.getLuong()));
                    cbDiachi.setSelectedItem(nv.getDiaChi());
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên");
                }
            }
        });

        // Sự kiện cập nhật nhân viên
        btnCapNhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String MaNV = txtMaNV.getText();
                String Hoten = txtHoten.getText();
                String Diachi = cbDiachi.getSelectedItem().toString();
                int Luong = Integer.parseInt(txtLuong.getText());

                Nhanvien nv = new Nhanvien(MaNV, Hoten, Diachi, Luong);
                if (xlLuong.updateNVbyMa(nv)) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                }
            }
        });
    }

    public static void main(String[] args) {
        new GUI_updateNV().setVisible(true);
    }
}
