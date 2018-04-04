/**
 * 
 */
package cmc.data.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cmc.data.SqlQuerry;
import cmc.data.business.KhachHangBUS;
import cmc.data.model.KhachHang;

/**
 * @description:
 * @author: Admin
 * @time: 10:18:13 AM
 * @date: Mar 28, 2018
 */
public class KhachHangUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtmaKH;
	private JTextField txttenKH;
	private JTable table;
	private TableModel tableModel;
	private JScrollPane scrollPane;
	private JTextField txtusername;
	private JTextField txtpassword;
	private JTextField txttencongty;
	private JTextField txtdiachi;
	private JTextField txtthanhpho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangUI frame = new KhachHangUI();
					frame.setLocationRelativeTo(null);
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
	public KhachHangUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Khách Hàng");
		lblNewLabel.setBounds(159, 10, 357, 58);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JLabel lblmaKH = new JLabel("Mã Khach Hang");
		lblmaKH.setBounds(26, 98, 128, 13);
		contentPane.add(lblmaKH);

		JLabel lbltenKH = new JLabel("Tên Khách Hàng");
		lbltenKH.setBounds(26, 132, 128, 13);
		contentPane.add(lbltenKH);

		txtmaKH = new JTextField();
		txtmaKH.setBounds(200, 94, 234, 19);
		contentPane.add(txtmaKH);
		txtmaKH.setColumns(10);

		txttenKH = new JTextField();
		txttenKH.setBounds(200, 128, 234, 19);
		txttenKH.setColumns(10);
		contentPane.add(txttenKH);

		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã KH");
		columns.add("Tên KH");
		columns.add("Tên username");
		columns.add("Tên password");
		columns.add("Tên Công Ty");
		columns.add("Địa Chỉ");
		columns.add("Thành Phố");
		/*
		 * values.add(new String[] { "1", "Đồ gia dụng" }); values.add(new String[] {
		 * "2", "Đồ gia dụng" }); values.add(new String[] { "3", "Đồ gia dụng" });
		 */

		KhachHangBUS khachangBUS = new KhachHangBUS();
		List<KhachHang> khachangs = khachangBUS.getList(SqlQuerry.SELECT_ALL_KhachHang);
		for (KhachHang khachhang : khachangs) {
			values.add(new String[] { String.valueOf(khachhang.getMaKH()), khachhang.getTenKH(),
					khachhang.getUserName(), khachhang.getPassword(), khachhang.getTenCongTy(), khachhang.getDiaChi(),
					khachhang.getThanhPho() });
		}
		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(26, 464, 567, 260);
		contentPane.add(scrollPane);

		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				// System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
				JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});

		JButton btnNewButton = new JButton("New");
		btnNewButton.setBounds(26, 346, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton.getText().equals("New")) {
					btnNewButton.setText("Save");
				} else {
					// save
					String MaKH = txtmaKH.getText().trim();
					String tenKH = txttenKH.getText().trim();
					String username = txtusername.getText().trim();
					String password = txtpassword.getText().trim();
					String tencongty = txttencongty.getText().trim();
					String diachi = txtdiachi.getText().trim();
					String thanhpho = txtthanhpho.getText().trim();

					// and refresh data in table
				}
			}
		});
		contentPane.add(btnNewButton);

		JButton buttonUpdate = new JButton("Update");
		buttonUpdate.setBounds(122, 346, 85, 21);
		contentPane.add(buttonUpdate);

		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(219, 346, 85, 21);
		contentPane.add(buttonDelete);

		JButton buttonInsert = new JButton("Insert");
		buttonInsert.setBounds(313, 346, 85, 21);
		contentPane.add(buttonInsert);

		JLabel lblusername = new JLabel("username");
		lblusername.setBounds(26, 163, 128, 16);
		contentPane.add(lblusername);

		txtusername = new JTextField();
		txtusername.setBounds(200, 160, 234, 22);
		contentPane.add(txtusername);
		txtusername.setColumns(10);

		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(26, 196, 128, 13);
		contentPane.add(lblpassword);

		txtpassword = new JTextField();
		txtpassword.setBounds(200, 195, 234, 22);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);

		JLabel lbltenCongTy = new JLabel("Tên Công Ty");
		lbltenCongTy.setBounds(26, 230, 128, 16);
		contentPane.add(lbltenCongTy);

		txttencongty = new JTextField();
		txttencongty.setBounds(200, 230, 234, 22);
		contentPane.add(txttencongty);
		txttencongty.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(26, 264, 128, 16);
		contentPane.add(lblDiaChi);

		txtdiachi = new JTextField();
		txtdiachi.setBounds(200, 265, 234, 22);
		contentPane.add(txtdiachi);
		txtdiachi.setColumns(10);

		JLabel lblThanhPho = new JLabel("Thành Phố");
		lblThanhPho.setBounds(26, 304, 128, 16);
		contentPane.add(lblThanhPho);

		txtthanhpho = new JTextField();
		txtthanhpho.setBounds(200, 301, 234, 22);
		contentPane.add(txtthanhpho);
		txtthanhpho.setColumns(10);

	}
}
