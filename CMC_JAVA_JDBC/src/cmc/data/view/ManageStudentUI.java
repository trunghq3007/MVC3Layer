/**
 * 
 */
package cmc.data.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @description: giao diện quản lí student
 * @author: Admin
 * @time: 2:31:15 PM
 * @date: Mar 23, 2018
 */
public class ManageStudentUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ManageStudentUI(String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTrangQunL = new JLabel("Trang quản lí sinh viên");
		lblTrangQunL.setBounds(5, 5, 424, 19);
		lblTrangQunL.setHorizontalAlignment(SwingConstants.CENTER);

		lblTrangQunL.setFont(new Font("Serif", Font.BOLD, 14));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		contentPane.add(lblTrangQunL);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 990);

		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(121, 44, 46, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(177, 41, 130, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("New label");
		label.setBounds(121, 72, 46, 14);
		panel.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 69, 130, 20);
		panel.add(textField_1);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(121, 102, 46, 14);
		panel.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 99, 130, 20);
		panel.add(textField_2);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(121, 130, 46, 14);
		panel.add(label_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(177, 127, 130, 20);
		panel.add(textField_3);
		
		table = new JTable();
		table.setBounds(50, 217, 783, 300);
		panel.add(table);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.setBounds(50, 171, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(153, 171, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(254, 171, 89, 23);
		panel.add(btnDelete);
		
		JButton btnNext = new JButton("First");
		btnNext.setBounds(353, 171, 89, 23);
		panel.add(btnNext);
		
		JButton btnNext_1 = new JButton("Next");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNext_1.setBounds(452, 171, 89, 23);
		panel.add(btnNext_1);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(553, 171, 89, 23);
		panel.add(btnPrevious);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(653, 171, 89, 23);
		panel.add(btnLast);
		setTitle(title);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentUI frame = new ManageStudentUI("Manage Student");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
