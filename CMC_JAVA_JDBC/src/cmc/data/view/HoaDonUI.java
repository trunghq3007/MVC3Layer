package cmc.data.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
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
import cmc.data.business.HoaDonBUS;
import cmc.data.model.HoaDon;

public class HoaDonUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMahd;
	private JTextField txtMakh;
	private JTable table;
	private TableModel tableModel;
	private JScrollPane scrollPane;
	private JTextField txtManv;
	private JTextField txtTongtien;
	private JTextField txtngay;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public HoaDonUI() {
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

		JLabel lblMNsp = new JLabel("Mã HD");
		lblMNsp.setBounds(26, 74, 45, 13);
		contentPane.add(lblMNsp);

		JLabel lblTnNsp = new JLabel("Mã KH");
		lblTnNsp.setBounds(26, 108, 45, 13);
		contentPane.add(lblTnNsp);

		JLabel lblMNsp_1 = new JLabel("Mã NV");
		lblMNsp_1.setBounds(26, 139, 45, 13);
		contentPane.add(lblMNsp_1);

		JLabel lblnGi = new JLabel("Tổng Tiền");
		lblnGi.setBounds(349, 74, 45, 13);
		contentPane.add(lblnGi);

		JLabel lblSLngHng = new JLabel("Ngày");
		lblSLngHng.setBounds(349, 108, 59, 13);
		contentPane.add(lblSLngHng);

		showTableHoaDon();
		table = new JTable(tableModel);

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				TableModel model = table.getModel();
				txtMahd.setText(model.getValueAt(row, 0).toString());
				txtMakh.setText(model.getValueAt(row, 1).toString());
				txtManv.setText(model.getValueAt(row, 2).toString());
				txtTongtien.setText(model.getValueAt(row, 3).toString());
				txtngay.setText(model.getValueAt(row, 4).toString());
				
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
					// String maNSP = txtMaSP.getText().trim();
					// String tenNSP = txtTenSP.getText().trim();
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
					HoaDonBUS hoaDonBUS = new HoaDonBUS();
					HoaDon obj = new HoaDon();
					obj.setMaHD(Integer.parseInt(txtMahd.getText()));
					obj.setMaKH(Integer.parseInt(txtMakh.getText()));
					obj.setMaNV(Integer.parseInt(txtManv.getText()));
					obj.setTongTien(Float.parseFloat(txtTongtien.getText()));
					obj.setNgayLHD(Date.valueOf(txtngay.getText()));
					
					hoaDonBUS.update(obj);
					JOptionPane.showMessageDialog(null, "Updated successfully!!!");
					refreshTable();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Update failed!!!");
				}
			}
		});
		btnUpdate.setBounds(122, 174, 85, 21);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HoaDonBUS hoaDonBUS = new HoaDonBUS();
					HoaDon obj = new HoaDon();
					obj.setMaHD(Integer.parseInt(txtMahd.getText()));
					obj.setMaKH(Integer.parseInt(txtMakh.getText()));
					obj.setMaNV(Integer.parseInt(txtManv.getText()));
					obj.setTongTien(Float.parseFloat(txtTongtien.getText()));
					obj.setNgayLHD(Date.valueOf(txtngay.getText()));
					
					hoaDonBUS.delete(obj);
					JOptionPane.showMessageDialog(null, "Deleted successfully!!!");
					clearFieldSanPham();
					refreshTable();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Delete failed!!!");
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
					HoaDonBUS hoaDonBUS = new HoaDonBUS();
					HoaDon obj = new HoaDon();
					obj.setMaHD(0);
					obj.setMaKH(Integer.parseInt(txtMakh.getText()));
					obj.setMaNV(Integer.parseInt(txtManv.getText()));
					obj.setTongTien(Float.parseFloat(txtTongtien.getText()));
					obj.setNgayLHD(Date.valueOf(txtngay.getText()));
					
					
					hoaDonBUS.insert(obj);
					JOptionPane.showMessageDialog(null, "Inserted successfully!!!");
					refreshTable();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Insert failed!!!");
				}
			}
		});
		btnInsert.setBounds(314, 174, 97, 21);
		contentPane.add(btnInsert);

		txtMahd = new JTextField();
		txtMahd.setEditable(false);
		txtMahd.setBounds(96, 71, 181, 19);
		contentPane.add(txtMahd);
		txtMahd.setColumns(10);

		txtMakh = new JTextField();
		txtMakh.setColumns(10);
		txtMakh.setBounds(96, 103, 181, 19);
		contentPane.add(txtMakh);

		txtManv = new JTextField();
		txtManv.setColumns(10);
		txtManv.setBounds(96, 134, 181, 19);
		contentPane.add(txtManv);

		txtTongtien = new JTextField();
		txtTongtien.setColumns(10);
		txtTongtien.setBounds(433, 71, 181, 19);
		contentPane.add(txtTongtien);

		txtngay = new JTextField();
		txtngay.setColumns(10);
		txtngay.setBounds(433, 103, 181, 19);
		contentPane.add(txtngay);

	}

	public void showTableHoaDon() {
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã Hóa Đơn");
		columns.add("Mã Khách Hàng");
		columns.add("Mã Nhân Viên");
		columns.add("Tổng Tiền ");
		columns.add("Ngày Lập Hóa Đơn");

		HoaDonBUS hoaDonBUS = new HoaDonBUS();
		List<HoaDon> hoaDons = hoaDonBUS.getList(SqlQuerry.SELECT_ALL_HoaDon);
		for (HoaDon hoaDon : hoaDons) {
			values.add(new String[] { String.valueOf(hoaDon.getMaHD()), String.valueOf(hoaDon.getMaKH()),
					String.valueOf(hoaDon.getMaNV()), String.valueOf(hoaDon.getTongTien()),
					String.valueOf(hoaDon.getNgayLHD()) });
		}
		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

	}

	public void clearFieldSanPham() {
		txtMahd.setText("Auto-generated");
		txtMakh.setText("");
		txtManv.setText("");
		txtTongtien.setText("");
		txtngay.setText("");
		
	}

	public void refreshTable() {
		showTableHoaDon();
		table.setModel(tableModel);
	}
}

