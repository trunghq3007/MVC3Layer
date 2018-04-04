/**
 * 
 */
package cmc.data.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

/**
 * @description:
 * @author: Admin
 * @time: 7:42:57 PM
 * @date: Apr 2, 2018
 */
public class MainUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblChngTrnhQun = new JLabel("CHƯƠNG TRÌNH QUẢN LÍ BÁN HÀNG ");
		lblChngTrnhQun.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChngTrnhQun.setBounds(422, 24, 327, 31);
		contentPane.add(lblChngTrnhQun);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(21, 65, 902, 44);
		contentPane.add(toolBar);

		JButton btnNewButton = new JButton("Nhân viên\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// frame = new KhachHangUI();
				// frame.setVisible(true);

			}
		});
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Khách hàng\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangUI frame = new KhachHangUI();
				frame.setVisible(true);
			}
		});
		toolBar.addSeparator();
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Sản phẩm\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPhamUI frame = new SanPhamUI();
				frame.setVisible(true);
			}
		});
		toolBar.addSeparator();
		toolBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Nhóm sản phẩm\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhomSanPhamUI frame = new NhomSanPhamUI();
				frame.setVisible(true);
			}
		});
		toolBar.addSeparator();
		toolBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Hóa đơn\r\n");
		toolBar.addSeparator();
		toolBar.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Chi tiết hóa đơn \r\n");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChitiethoadonUI frame = new ChitiethoadonUI();
				frame.setVisible(true);
			}
		});
		toolBar.addSeparator();
		toolBar.add(btnNewButton_5);

	}
}
