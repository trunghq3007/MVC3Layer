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
import cmc.data.business.ChitietHDBUS;
import cmc.data.business.NhomSPBUS;
import cmc.data.model.ChiTietHD;
import cmc.data.model.NhomSP;

public class ChitiethoadonUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHD;
	private JTextField txtMaSP;
	private JTextField txtdongia;
	private JTextField txtsoLuong;
	private JTextField txttongTien;
	private JTable table;
	private TableModel tableModel;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChitiethoadonUI frame = new ChitiethoadonUI();
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
	public ChitiethoadonUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lí chi tiết hóa đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 10, 357, 58);
		contentPane.add(lblNewLabel);

		JLabel lblMHD = new JLabel("Mã HĐ");
		lblMHD.setBounds(26, 74, 45, 13);
		contentPane.add(lblMHD);

		JLabel lblTSP = new JLabel("Mã SP");
		lblTSP.setBounds(332, 74, 45, 13);
		contentPane.add(lblTSP);
		
		JLabel lbLDG = new JLabel("Đơn giá");
		lbLDG.setBounds(26, 98, 45, 13);
		contentPane.add(lbLDG);

		JLabel lbLSL = new JLabel("Số Lượng");
		lbLSL.setBounds(332, 98, 45, 13);
		contentPane.add(lbLSL);
		
		JLabel lbLTT = new JLabel("Tổng tiền");
		lbLTT.setBounds(143, 132, 45, 13);
		contentPane.add(lbLTT);
		

		txtMaHD = new JTextField();
		txtMaHD.setBounds(81, 70, 202, 19);
		contentPane.add(txtMaHD);
		txtMaHD.setColumns(10);

		txtMaSP = new JTextField();
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(400, 70, 202, 19);
		contentPane.add(txtMaSP);
		
		txtdongia = new JTextField();
		txtdongia.setColumns(10);
		txtdongia.setBounds(81, 94, 202, 19);
		contentPane.add(txtdongia);
		
		txtsoLuong = new JTextField();
		txtsoLuong.setColumns(10);
		txtsoLuong.setBounds(400, 94, 202, 19);
		contentPane.add(txtsoLuong);
		
		txttongTien = new JTextField();
		txttongTien.setColumns(10);
		txttongTien.setBounds(236, 128, 234, 19);
		contentPane.add(txttongTien);

		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã Hóa Đơn");
		columns.add("Tên Sản Phẩm");
		columns.add("Đơn Giá");
		columns.add("Số Lượng");
		columns.add("Tổng Tiền");

		/*
		 * values.add(new String[] { "1", "Đồ gia dụng" }); values.add(new String[] {
		 * "2", "Đồ gia dụng" }); values.add(new String[] { "3", "Đồ gia dụng" });
		 */

		ChitietHDBUS chitietHDBUS = new ChitietHDBUS();
		//Thay bang getall
		List<ChiTietHD> chiTietHDs = chitietHDBUS.getAll();
		for (ChiTietHD chiTietHD : chiTietHDs) {
			values.add(new String[] { String.valueOf(chiTietHD.getMaHD()), String.valueOf(chiTietHD.getMaSP()),String.valueOf(chiTietHD.getDonGia()) , 
					 String.valueOf(chiTietHD.getSoLuong()),String.valueOf(chiTietHD.getTongTien())});
			}
		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		table.setBounds(26, 166, 574, 274);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 226, 567, 260);
		contentPane.add(scrollPane);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				// System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
				JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton.getText().equals("New")) {
					btnNewButton.setText("Save");
				} else {
					// save
					String maHD = txtMaHD.getText().trim();
					String maSP = txtMaSP.getText().trim();
					String donGia = txtdongia.getText().trim();
					String soLuong = txtsoLuong.getText().trim();
					String tongTien = txttongTien.getText().trim();
					// and refresh data in table
				}
			}
		});
		btnNewButton.setBounds(26, 194, 85, 21);
		contentPane.add(btnNewButton);

		JButton button = new JButton("New button");
		button.setBounds(122, 194, 85, 21);
		contentPane.add(button);

		JButton button_1 = new JButton("New button");
		button_1.setBounds(217, 194, 85, 21);
		contentPane.add(button_1);

		JButton button_2 = new JButton("New button");
		button_2.setBounds(312, 194, 85, 21);
		contentPane.add(button_2);

		JButton button_3 = new JButton("New button");
		button_3.setBounds(407, 194, 85, 21);
		contentPane.add(button_3);

		JButton button_4 = new JButton("New button");
		button_4.setBounds(508, 194, 85, 21);
		contentPane.add(button_4);

	}

}
