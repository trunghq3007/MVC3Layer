/**
 * 
 */
package cmc.data.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cmc.data.business.StudentBUS;
import cmc.data.model.KhachHang;
import cmc.data.model.Student;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;

/**
 * @description:
 * @author: Admin
 * @time: 8:05:05 PM
 * @date: Mar 23, 2018
 */
public class LoginUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static StudentBUS studentBUS;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	String s;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					// set size for
					frame.setSize(450, 300);
					// location center of screen
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 */
	public LoginUI() {
		setTitle("Form login");
		studentBUS = new StudentBUS();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("form đăng nhập");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Trang đăng nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(116, 49, 240, 30);
		contentPane.add(lblNewLabel);

		JLabel lbl = new JLabel("Username");
		lbl.setBounds(61, 108, 76, 13);
		contentPane.add(lbl);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(61, 149, 76, 13);
		contentPane.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(126, 105, 230, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(126, 146, 230, 19);
		contentPane.add(txtPassword);

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// xử lí đăng nhập
				// lấy dữ liệu từ texfield username và password
				String userName = txtUsername.getText();
				String password = txtPassword.getText();
				// lấy ra danh sách student
				List<KhachHang> listKhachhang = studentBUS.getAllStudent();
				// duyệt danh sách kiểm tra có user không
				boolean checkDangNhap = false;
				for (Student student : listStudent) {
					if (student.getFullName().equals(userName.trim()) && password.equals("123456")) {
						// JOptionPane.showMessageDialog(null, "đăng nhập thành công");
						checkDangNhap = true;
						// ManageStudentUI
						ManageStudentUI frame = new ManageStudentUI("Trang quản lí Student");
						frame.setVisible(true);
						dispose();
						break;
					}

				}
				// nếu hết list mà không có student thỏa mãn đăng nhập
				if (!checkDangNhap) {
					JOptionPane.showMessageDialog(null, "đăng nhập thất bại");
				}

			}
		});

		btnDangNhap.setBounds(126, 202, 104, 19);
		contentPane.add(btnDangNhap);

		JButton btnDangKi = new JButton("Đăng kí");
		btnDangKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// xử lí đăng kí
			}
		});
		btnDangKi.setBounds(252, 201, 104, 19);
		contentPane.add(btnDangKi);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(37, 10, 290, 30);
		JButton button = new JButton("File");  
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(button);  
		toolBar.addSeparator();  
		toolBar.add(new JButton("Edit"));  
		contentPane.add(toolBar);
	}
}
