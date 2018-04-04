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

import cmc.data.business.NhomSPBUS;
import cmc.data.model.NhomSP;

/**
 * @description:
 * @author: Admin
 * @time: 10:18:13 AM
 * @date: Mar 28, 2018
 */
public class NhomSanPhamUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNSP;
	private JTextField txtTenNSP;
	private JTable table;
	private TableModel tableModel;
	private JScrollPane scrollPane;



	/**
	 * Create the frame.
	 */
	public NhomSanPhamUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lí Nhóm sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 10, 357, 58);
		contentPane.add(lblNewLabel);

		JLabel lblMNsp = new JLabel("Mã NSP");
		lblMNsp.setBounds(26, 98, 45, 13);
		contentPane.add(lblMNsp);

		JLabel lblTnNsp = new JLabel("Tên NSP");
		lblTnNsp.setBounds(26, 132, 45, 13);
		contentPane.add(lblTnNsp);

		txtMaNSP = new JTextField();
		txtMaNSP.setBounds(81, 95, 234, 19);
		contentPane.add(txtMaNSP);
		txtMaNSP.setColumns(10);

		txtTenNSP = new JTextField();
		txtTenNSP.setColumns(10);
		txtTenNSP.setBounds(81, 127, 234, 19);
		contentPane.add(txtTenNSP);

		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã Nhóm sản phẩm");
		columns.add("Tên Nhóm sản phẩm");

		
		NhomSPBUS nhomSPBUS = new NhomSPBUS();
		// List<NhomSP> nhomSPs = nhomSPBUS.getList(SqlQuerry.SELECT_ALL_NHOM_SP);
		List<NhomSP> nhomSPs = nhomSPBUS.getAll();
		for (NhomSP nhomSP : nhomSPs) {
			values.add(new String[] { String.valueOf(nhomSP.getMaNSP()), nhomSP.getTenNSP() });
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
					String maNSP = txtMaNSP.getText().trim();
					String tenNSP = txtTenNSP.getText().trim();
					// and refresh data in table
				}
			}
		});
		btnNewButton.setBounds(26, 174, 85, 21);
		contentPane.add(btnNewButton);

		JButton button = new JButton("New button");
		button.setBounds(122, 174, 85, 21);
		contentPane.add(button);

		JButton button_1 = new JButton("New button");
		button_1.setBounds(217, 174, 85, 21);
		contentPane.add(button_1);

		JButton button_2 = new JButton("New button");
		button_2.setBounds(312, 174, 85, 21);
		contentPane.add(button_2);

		JButton button_3 = new JButton("New button");
		button_3.setBounds(407, 174, 85, 21);
		contentPane.add(button_3);

		JButton button_4 = new JButton("New button");
		button_4.setBounds(502, 174, 85, 21);
		contentPane.add(button_4);

	}
}
