package cmc.data.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cmc.data.SqlQuerry;
import cmc.data.business.KhachHangBUS;
import cmc.data.business.NhanVienBUS;
import cmc.data.model.KhachHang;
import cmc.data.model.NhanVien;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class NhanVienUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaNV;
	private JTextField textField_HoTen;
	private JTextField textField_GioiTinh;
	private JTextField textField_NgaySinh;
	private JTextField textField_DiaChi;
	private JTextField textField_DienThoai;
	private JTextField textField_GhiChu;
	private JScrollPane scrollPane;
	private JTable table;
	private TableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienUI frame = new NhanVienUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVienUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 1026);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã Nhân Viên");
		columns.add("Họ và tên");
		columns.add("Giới tính");
		columns.add("Ngày sinh");
		columns.add("Địa Chỉ");
		columns.add("Điện Thoại");
		columns.add("Ghi Chú");

		/*
		 * values.add(new String[] { "1", "Đồ gia dụng" }); values.add(new String[] {
		 * "2", "Đồ gia dụng" }); values.add(new String[] { "3", "Đồ gia dụng" });
		 */

		NhanVienBUS nhanvienBUS = new NhanVienBUS();
		List<NhanVien> nhanvien = nhanvienBUS.getList(SqlQuerry.SELECT_ALL_NhanVien);
		for (NhanVien nv : nhanvien) {
			values.add(new String[] { String.valueOf(nv.getMaNV()), nv.getHoTen(), nv.getGioiTinh(), nv.getDiaChi(), nv.getNgaySinh().toString(), nv.getDiaChi(), nv.getDienThoai(), nv.getGhiChu()});
		}
		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		
		JLabel lblTitle = new JLabel("Quản lý nhân viên");
		lblTitle.setBounds(0, 11, 634, 27);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);
		
		JLabel lblNhanVien = new JLabel("Mã nhân viên");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhanVien.setBounds(32, 85, 100, 28);
		contentPane.add(lblNhanVien);
		
		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHoTen.setBounds(32, 132, 100, 27);
		contentPane.add(lblHoTen);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioiTinh.setBounds(32, 179, 100, 27);
		contentPane.add(lblGioiTinh);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgaySinh.setBounds(32, 226, 100, 27);
		contentPane.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiaChi.setBounds(32, 271, 100, 27);
		contentPane.add(lblDiaChi);
		
		JLabel lblDienThoai = new JLabel("Điện thoại");
		lblDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDienThoai.setBounds(32, 321, 100, 27);
		contentPane.add(lblDienThoai);
		
		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGhiChu.setBounds(32, 371, 100, 27);
		contentPane.add(lblGhiChu);
		
		textField_MaNV = new JTextField();
		textField_MaNV.setBounds(198, 85, 398, 28);
		contentPane.add(textField_MaNV);
		textField_MaNV.setColumns(10);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(198, 133, 398, 28);
		contentPane.add(textField_HoTen);
		
		textField_GioiTinh = new JTextField();
		textField_GioiTinh.setColumns(10);
		textField_GioiTinh.setBounds(198, 180, 398, 28);
		contentPane.add(textField_GioiTinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(198, 227, 398, 28);
		contentPane.add(textField_NgaySinh);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(198, 272, 398, 28);
		contentPane.add(textField_DiaChi);
		
		textField_DienThoai = new JTextField();
		textField_DienThoai.setColumns(10);
		textField_DienThoai.setBounds(198, 322, 398, 28);
		contentPane.add(textField_DienThoai);
		
		textField_GhiChu = new JTextField();
		textField_GhiChu.setColumns(10);
		textField_GhiChu.setBounds(198, 372, 398, 28);
		contentPane.add(textField_GhiChu);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAddNew.getText().equals("Add New")) {
					btnAddNew.setText("Save");
				}else {
					//save
					String MaNV = textField_MaNV.getText().trim();
					String HoTen = textField_HoTen.getText().trim();
					String GioiTinh = textField_GioiTinh.getText().trim();
					String NgaySinh = textField_NgaySinh.getText().trim();
					String DiaChi = textField_DiaChi.getText().trim();
					String DienThoai = textField_DienThoai.getText().trim();
					String GhiChu = textField_GhiChu.getText().trim();
				}
			}
		});
		btnAddNew.setBounds(31, 462, 89, 23);
		contentPane.add(btnAddNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(184, 462, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(349, 462, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(507, 462, 89, 23);
		contentPane.add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 552, 624, 424);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
}
