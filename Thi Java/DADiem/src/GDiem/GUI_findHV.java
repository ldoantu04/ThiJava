/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GDiem;

import GDiem.Hocvien;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI_findHV extends JFrame {
    private JComboBox<String> cboLop;
    private JRadioButton rbNam, rbNu;
    private JButton btnTimKiem;
    private JTable table;
    private XLDiem xlDiem;

    public GUI_findHV() {
        setTitle("Tìm kiếm học viên");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Khởi tạo các thành phần giao diện
        String[] dsLop = {"63PM1", "63PM2", "63TH1", "63TH2"};
        cboLop = new JComboBox<>(dsLop);
        
        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nữ");
        ButtonGroup group = new ButtonGroup();
        group.add(rbNam);
        group.add(rbNu);
        
        btnTimKiem = new JButton("Tìm kiếm học viên");

        // Khởi tạo JTable
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Mã Học viên", "Họ tên", "Giới tính", "Lớp", "Điểm", "Kết quả"}
        ));
        
        JPanel panel = new JPanel();
        panel.add(new JLabel("Lớp:"));
        panel.add(cboLop);
        panel.add(rbNam);
        panel.add(rbNu);
        panel.add(btnTimKiem);

        add(panel, "North");
        add(scrollPane, "Center");

        xlDiem = new XLDiem();

        // Xử lý sự kiện tìm kiếm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lop = cboLop.getSelectedItem().toString();
                String gioiTinh = rbNam.isSelected() ? "Nam" : (rbNu.isSelected() ? "Nữ" : null);
                
                List<Hocvien> dsHocvien = gioiTinh == null ? 
                    xlDiem.getHVbyLop(lop) : 
                    xlDiem.getHVbyLopGT(lop, gioiTinh);

                // Hiển thị kết quả
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Xóa dữ liệu cũ

                for (Hocvien hv : dsHocvien) {
                    model.addRow(new Object[]{
                        hv.getMaHV(),
                        hv.getHoTen(),
                        hv.getGT(),
                        hv.getLop(),
                        hv.getDiem(),
                        hv.Ketqua()
                    });
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI_findHV().setVisible(true);
        });
    }
}
