package cmc.data.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;
import cmc.data.SqlQuerry;
import cmc.data.business.NhanVienBUS;
import cmc.data.model.NhanVien;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;


public class NhanVienUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_HoTen;
	private JTextField textField_GioiTinh;
	private JTextField textField_DiaChi;
	private JTextField textField_DienThoai;
	private JTextField textField_GhiChu;
	private JScrollPane scrollPane;
	private JTable table;
	private TableModel tableModel;

	private static Logger log;
	private JTextField textField_NgaySinh;

	

	/**
	 * Create the frame.
	 */
	public NhanVienUI() {
		log = Logger.getLogger(NhanVienUI.class);
		log.info("Hello, this is an info message!");
//		log.warn("Warning!");		
//		log.error("Error need fix!");
//		log.debug("Hello, this is a debug message!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 1026);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		NhanVienUI_Update nvUpdateForm = new NhanVienUI_Update();
		
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
			values.add(new String[] { String.valueOf(nv.getMaNV()), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh().toString(), nv.getDiaChi(), nv.getDienThoai(), nv.getGhiChu()});
		}
		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		
		JLabel lblTitle = new JLabel("Quản lý nhân viên");
		lblTitle.setBounds(0, 11, 634, 27);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);
		
		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHoTen.setBounds(32, 72, 100, 27);
		contentPane.add(lblHoTen);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioiTinh.setBounds(32, 119, 100, 27);
		contentPane.add(lblGioiTinh);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgaySinh.setBounds(32, 166, 100, 27);
		contentPane.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiaChi.setBounds(32, 211, 100, 27);
		contentPane.add(lblDiaChi);
		
		JLabel lblDienThoai = new JLabel("Điện thoại");
		lblDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDienThoai.setBounds(32, 261, 100, 27);
		contentPane.add(lblDienThoai);
		
		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGhiChu.setBounds(32, 311, 100, 27);
		contentPane.add(lblGhiChu);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(198, 73, 398, 28);
		contentPane.add(textField_HoTen);
		
		textField_GioiTinh = new JTextField();
		textField_GioiTinh.setColumns(10);
		textField_GioiTinh.setBounds(198, 120, 398, 28);
		contentPane.add(textField_GioiTinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(198, 167, 398, 28);
		contentPane.add(textField_NgaySinh);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(198, 212, 398, 28);
		contentPane.add(textField_DiaChi);
		
		textField_DienThoai = new JTextField();
		textField_DienThoai.setColumns(10);
		textField_DienThoai.setBounds(198, 262, 398, 28);
		contentPane.add(textField_DienThoai);
		
		textField_GhiChu = new JTextField();
		textField_GhiChu.setColumns(10);
		textField_GhiChu.setBounds(198, 312, 398, 28);
		contentPane.add(textField_GhiChu);
		
		JButton btnAddNew = new JButton("AddNew");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<NhanVien> nhanvien = nhanvienBUS.getList(SqlQuerry.SELECT_ALL_NhanVien);
				for (NhanVien nv : nhanvien) {
					values.add(new String[] { String.valueOf(nv.getMaNV()), nv.getHoTen(), nv.getGioiTinh(), nv.getDiaChi(), nv.getNgaySinh().toString(), nv.getDiaChi(), nv.getDienThoai(), nv.getGhiChu()});
				}
				tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			}
		});
		btnAddNew.setBounds(31, 375, 89, 23);
		contentPane.add(btnAddNew);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int MaNV = Integer.parseInt(textField_MaNV.getText().trim());
				String HoTen = textField_HoTen.getText().trim();
				String GioiTinh = textField_GioiTinh.getText().trim();		
				

//				java.util.Date NgaySinh_1 = dateChooser.getDate();
//				Date NgaySinh = Date.valueOf(textField_NgaySinh.getText().trim());
//				
//				String stringDate = "22/01/2016";
//				try {
//					java.util.Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
//				} catch (ParseException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				String DiaChi = textField_DiaChi.getText().trim();
				String DienThoai = textField_DienThoai.getText().trim();
				String GhiChu = textField_GhiChu.getText().trim();
				
				NhanVien nv = new NhanVien(HoTen, GioiTinh, DiaChi, DienThoai, GhiChu);
				nhanvienBUS.insert(nv);
				
			}
		});
		btnInsert.setBounds(185, 375, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nvUpdateForm.setVisible(true);
				nvUpdateForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnUpdate.setBounds(346, 375, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(507, 375, 89, 23);
		contentPane.add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 444, 624, 532);
		contentPane.add(scrollPane);
		
		
		table = new JTable(tableModel);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int rowIndex = table.getSelectedRow();
				TableModel model = table.getModel();
				String id = model.getValueAt(rowIndex, 0).toString();
				String name = model.getValueAt(rowIndex, 1).toString();
				String gender = model.getValueAt(rowIndex, 2).toString();
				String birthday = model.getValueAt(rowIndex, 3).toString();
				String address = model.getValueAt(rowIndex, 4).toString();
				String phone = model.getValueAt(rowIndex, 5).toString();
				String note = model.getValueAt(rowIndex, 6).toString();
				
				nvUpdateForm.id_label.setText(id);
				nvUpdateForm.textField_name.setText(name);
				nvUpdateForm.textField_gender.setText(gender);
				nvUpdateForm.textField_birthday.setText(birthday);
				nvUpdateForm.textField_address.setText(address);
				nvUpdateForm.textField_phone.setText(phone);
				nvUpdateForm.textField_note.setText(note);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
}
