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
import javax.swing.border.EmptyBorder;

import cmc.data.business.StudentBUS;
import cmc.data.model.Student;

public class Login extends JFrame {

	static StudentBUS studentBUS;
	private JPanel contentPane;
	private JTextField txtten;
	private JTextField txtmk;
	String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		//set tytle
		setTitle("Form Login");
		// phai khoi tao moi goi dc static stuent b� ben tren
		studentBUS = new StudentBUS();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set chieu dai rong chiieu cao
		setBounds(100, 100, 450, 300);
		//
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Trang Dang Nhap");
		lblNewLabel.setFont(new Font("SansSerif", Font.ITALIC, 16));
		lblNewLabel.setBounds(167, 11, 161, 33);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(42, 67, 74, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setBounds(42, 108, 74, 14);
		contentPane.add(lblNewLabel_2);

		txtten = new JTextField();
		txtten.setBounds(155, 61, 161, 20);
		contentPane.add(txtten);
		txtten.setColumns(10);

		txtmk = new JTextField();
		txtmk.setColumns(10);
		txtmk.setBounds(155, 105, 161, 20);
		contentPane.add(txtmk);

		JButton btnhap = new JButton("Dang Nhap");
		btnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// xu ly dang nhap
				// lay du lieu tu text file cua username va password.
				String username = txtten.getText();
				String password = txtmk.getText();
				// lay ra danh sach student
				List<Student> liststudent = studentBUS.getAllStudent();
				// duyet danh sach kiem tra co user hay khong
				boolean checkDangNhap = false;
				for (Student student : liststudent) {
					if (student.getFullName().equals(username.trim()) && password.equals("123456")) {

						// JOptionPane.showMessageDialog(null, "Dang nhap thanh cong");
						checkDangNhap = true;
						ManageStudentUI frame = new ManageStudentUI("Trang qua ly Student");
						frame.setVisible(true);
						dispose();
						break;
					}
				}
				// neu het list ma ko c� syudent trung
				if (!checkDangNhap) {
					JOptionPane.showMessageDialog(null, "Dang nhap that bai");
				}

			}
		});
		btnhap.setBounds(91, 155, 120, 38);
		contentPane.add(btnhap);

		JButton btdangky = new JButton("Dang Ky");
		btdangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ban vua click Dang ky");
			}
		});
		btdangky.setBounds(264, 155, 89, 38);
		contentPane.add(btdangky);
	}
}
