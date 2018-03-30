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
import cmc.data.business.SanPhamBUS;
import cmc.data.model.SanPham;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JList;
import javax.swing.JComboBox;

/**
 * @description:
 * @author: Admin
 * @time: 10:18:13 AM
 * @date: Mar 28, 2018
 */
public class SanPhamUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTable table;
	private TableModel tableModel;
	private JScrollPane scrollPane;
	private JTextField txtMaNSP;
	private JTextField txtDonGia;
	private JTextField txtSoLuongHang;
	private JTextField txtAnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamUI frame = new SanPhamUI();
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
	public SanPhamUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lí sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(279, 0, 357, 58);
		contentPane.add(lblNewLabel);

		JLabel lblMNsp = new JLabel("Mã SP");
		lblMNsp.setBounds(26, 74, 45, 13);
		contentPane.add(lblMNsp);

		JLabel lblTnNsp = new JLabel("Tên SP");
		lblTnNsp.setBounds(26, 108, 45, 13);
		contentPane.add(lblTnNsp);

		JLabel lblMNsp_1 = new JLabel("Mã NSP");
		lblMNsp_1.setBounds(26, 139, 45, 13);
		contentPane.add(lblMNsp_1);

		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setBounds(349, 74, 45, 13);
		contentPane.add(lblnGi);

		JLabel lblSLngHng = new JLabel("Số lượng");
		lblSLngHng.setBounds(349, 108, 59, 13);
		contentPane.add(lblSLngHng);

		JLabel lblLinknh = new JLabel("Link ảnh");
		lblLinknh.setBounds(349, 139, 59, 13);
		contentPane.add(lblLinknh);

		showTableSanPham();
		table = new JTable(tableModel);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				TableModel model = table.getModel();
				txtMaSP.setText(model.getValueAt(row, 0).toString());
				txtTenSP.setText(model.getValueAt(row, 1).toString());
				txtMaNSP.setText(model.getValueAt(row, 2).toString());
				txtDonGia.setText(model.getValueAt(row, 3).toString());
				txtSoLuongHang.setText(model.getValueAt(row, 4).toString());
				txtAnh.setText((String) (model.getValueAt(row, 5)));

			}
		});
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
				// JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(),
				// 0).toString());
			}
		});

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton.getText().equals("New")) {
					btnNewButton.setText("Save");
				
				} else {
					// save
					String maNSP = txtMaSP.getText().trim();
					String tenNSP = txtTenSP.getText().trim();
					// and refresh data in table
				}
			}
		});
		btnNewButton.setBounds(26, 174, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SanPhamBUS sanPhamBus = new SanPhamBUS();
					SanPham obj = new SanPham();
					obj.setMaSP(Integer.parseInt(txtMaSP.getText()));
					obj.setTenSP(txtTenSP.getText());
					obj.setMaNSP(Integer.parseInt(txtMaNSP.getText()));
					obj.setDonGia(Float.parseFloat(txtDonGia.getText()));
					obj.setSoLuong(Integer.parseInt(txtSoLuongHang.getText()));
					obj.setAnh(txtAnh.getText());
					sanPhamBus.update(obj);
					JOptionPane.showMessageDialog(null, "Updated successfully!!!");
					refreshTable();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Lỗi cmnr!!!");
				}
			}
		});
		btnUpdate.setBounds(122, 174, 85, 21);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SanPhamBUS sanPhamBus = new SanPhamBUS();
					SanPham obj = new SanPham();
					obj.setMaSP(Integer.parseInt(txtMaSP.getText()));
					obj.setTenSP(txtTenSP.getText());
					obj.setMaNSP(Integer.parseInt(txtMaNSP.getText()));
					obj.setDonGia(Float.parseFloat(txtDonGia.getText()));
					obj.setSoLuong(Integer.parseInt(txtSoLuongHang.getText()));
					obj.setAnh(txtAnh.getText());
					sanPhamBus.delete(obj);
					JOptionPane.showMessageDialog(null, "Deleted successfully!!!");
					refreshTable();
					clearFieldSanPham();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Lỗi cmnr!!!");
				}
				
			}
		});
		btnDelete.setBounds(217, 174, 85, 21);
		contentPane.add(btnDelete);

		JButton btnReset = new JButton("Clear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFieldSanPham();
			}
		});
		btnReset.setBounds(651, 68, 97, 25);
		contentPane.add(btnReset);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SanPhamBUS sanPhamBus = new SanPhamBUS();
					SanPham obj = new SanPham();
					obj.setMaSP(0);
					obj.setTenSP(txtTenSP.getText());
					obj.setMaNSP(Integer.parseInt(txtMaNSP.getText()));
					obj.setDonGia(Float.parseFloat(txtDonGia.getText()));
					obj.setSoLuong(Integer.parseInt(txtSoLuongHang.getText()));
					obj.setAnh(txtAnh.getText());
					sanPhamBus.insert(obj);
					JOptionPane.showMessageDialog(null, "Inserted successfully!!!");
					refreshTable();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Lỗi cmnr!!!");
				}
			}
		});
		btnInsert.setBounds(314, 174, 97, 21);
		contentPane.add(btnInsert);

		txtMaSP = new JTextField();
		txtMaSP.setEditable(false);
		txtMaSP.setBounds(96, 71, 181, 19);
		contentPane.add(txtMaSP);
		txtMaSP.setColumns(10);

		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(96, 103, 181, 19);
		contentPane.add(txtTenSP);

		txtMaNSP = new JTextField();
		txtMaNSP.setColumns(10);
		txtMaNSP.setBounds(96, 134, 181, 19);
		contentPane.add(txtMaNSP);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(433, 71, 181, 19);
		contentPane.add(txtDonGia);

		txtSoLuongHang = new JTextField();
		txtSoLuongHang.setColumns(10);
		txtSoLuongHang.setBounds(433, 103, 181, 19);
		contentPane.add(txtSoLuongHang);

		txtAnh = new JTextField();
		txtAnh.setColumns(10);
		txtAnh.setBounds(433, 134, 181, 19);
		contentPane.add(txtAnh);
		
		JList list = new JList();
		list.setBounds(750, 296, -89, -101);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(630, 191, 139, 22);
		contentPane.add(comboBox);

	}

	public void showTableSanPham() {
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã sản phẩm");
		columns.add("Tên sản phẩm");
		columns.add("Mã nhóm SP");
		columns.add("Đơn giá");
		columns.add("Số lượng");
		columns.add("Link ảnh SP");

		SanPhamBUS sanPhamBUS = new SanPhamBUS();
		List<SanPham> sanPhams = sanPhamBUS.getList(SqlQuerry.SELECT_ALL_SAN_PHAM);
		for (SanPham sanPham : sanPhams) {
			values.add(new String[] { String.valueOf(sanPham.getMaSP()), sanPham.getTenSP(),
					String.valueOf(sanPham.getMaNSP()), String.valueOf(sanPham.getDonGia()),
					String.valueOf(sanPham.getSoLuong()), sanPham.getAnh() });
		}
		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

	}
	public void clearFieldSanPham() {
		txtMaSP.setText("Auto-generated");
		txtTenSP.setText("");
		txtMaNSP.setText("");
		txtDonGia.setText("");
		txtSoLuongHang.setText("");
		txtAnh.setText("");		
	}

	public void refreshTable() {
		showTableSanPham();
		table.setModel(tableModel);
	}
}
