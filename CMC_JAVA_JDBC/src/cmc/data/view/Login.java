package cmc.data.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cmc.data.business.StudentBUS;
import cmc.data.model.Student;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField pwfUserPass;
	static StudentBUS studentbus = new StudentBUS();
	

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setBounds(78, 83, 78, 16);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(78, 123, 78, 16);
		contentPane.add(lblPassword);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(191, 80, 116, 22);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		
		pwfUserPass = new JPasswordField();
		pwfUserPass.setBounds(191, 120, 116, 22);
		contentPane.add(pwfUserPass);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				List<Student> liststudent = studentbus.getAllStudent();
				boolean checkLogin = false;
				for(Student student : liststudent)
				{
					if(student.getFullName().equals(tfUserName.getText())&& pwfUserPass.getText().equals("123456"))
					{
						checkLogin = true;
					}
				}
				if(checkLogin == true)
				{
					ManageStudentUI frame = new ManageStudentUI("Trang quan li");
					frame.setVisible(true);
					dispose();
				}
				if(checkLogin == false)
				{
					JOptionPane.showMessageDialog(null, "ko thanh cong");
				}
			}
		});
		btnLogin.setBounds(158, 191, 97, 25);
		contentPane.add(btnLogin);
	}

}
