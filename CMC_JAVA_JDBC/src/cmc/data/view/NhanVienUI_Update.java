package cmc.data.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cmc.data.business.NhanVienBUS;
import cmc.data.model.NhanVien;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhanVienUI_Update extends JFrame {

	public JPanel contentPane;
	public JTextField textField_name;
	public JTextField textField_gender;
	public JTextField textField_birthday;
	public JTextField textField_address;
	public JTextField textField_phone;
	public JTextField textField_note;
	public JLabel id_label = new JLabel("MaNV");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienUI_Update frame = new NhanVienUI_Update();
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
	public NhanVienUI_Update() {
		NhanVienBUS nhanvienBUS = new NhanVienBUS();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id_label.setBounds(109, 90, 103, 31);
		contentPane.add(id_label);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int MaNV = Integer.parseInt(id_label.getText());
				String HoTen = textField_name.getText().trim();
				String GioiTinh = textField_gender.getText().trim();
//				String NgaySinh = textField_birthday.getText().trim();
				String DiaChi = textField_address.getText().trim();
				String DienThoai = textField_phone.getText().trim();
				String GhiChu = textField_note.getText().trim();
				
				NhanVien nv = new NhanVien(MaNV, HoTen, GioiTinh, DiaChi, DienThoai, GhiChu);
				nhanvienBUS.update(nv);
			}
		});
		btnUpdate.setBounds(323, 88, 119, 31);
		contentPane.add(btnUpdate);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(109, 139, 333, 28);
		contentPane.add(textField_name);
		
		textField_gender = new JTextField();
		textField_gender.setColumns(10);
		textField_gender.setBounds(109, 181, 333, 28);
		contentPane.add(textField_gender);
		
		textField_birthday = new JTextField();
		textField_birthday.setColumns(10);
		textField_birthday.setBounds(109, 223, 333, 28);
		contentPane.add(textField_birthday);
		
		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(109, 265, 333, 28);
		contentPane.add(textField_address);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(109, 307, 333, 28);
		contentPane.add(textField_phone);
		
		textField_note = new JTextField();
		textField_note.setColumns(10);
		textField_note.setBounds(109, 346, 333, 28);
		contentPane.add(textField_note);
		
		JLabel lblCpNhtNhn = new JLabel("Cập nhật nhân viên");
		lblCpNhtNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpNhtNhn.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCpNhtNhn.setBounds(0, 11, 485, 27);
		contentPane.add(lblCpNhtNhn);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 90, 103, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblHoTn = new JLabel("Họ tên");
		lblHoTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoTn.setBounds(10, 136, 103, 31);
		contentPane.add(lblHoTn);
		
		JLabel lblGiiTinh = new JLabel("Giới tính");
		lblGiiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiiTinh.setBounds(10, 178, 103, 31);
		contentPane.add(lblGiiTinh);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgaySinh.setBounds(10, 220, 103, 31);
		contentPane.add(lblNgaySinh);
		
		JLabel lbliaChi = new JLabel("Địa chỉ");
		lbliaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbliaChi.setBounds(10, 262, 103, 31);
		contentPane.add(lbliaChi);
		
		JLabel lbliaChi_1 = new JLabel("Điện thoại");
		lbliaChi_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbliaChi_1.setBounds(10, 304, 103, 31);
		contentPane.add(lbliaChi_1);
		
		JLabel lblGhiChu = new JLabel("Ghi chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGhiChu.setBounds(10, 342, 103, 31);
		contentPane.add(lblGhiChu);
	}
}
