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
import cmc.data.business.NhomSPBUS;
import cmc.data.model.NhomSP;

public class NhomSPUI extends JFrame{
	private JPanel contentPane;
	private JTextField txtMaNSP;
	private JTextField txtTenNSP;
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
					NhomSPUI frame = new NhomSPUI();
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
	public NhomSPUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblMNsp.setBounds(26, 83, 45, 13);
		contentPane.add(lblMNsp);

		JLabel lblTnNsp = new JLabel("Tên NSP");
		lblTnNsp.setBounds(26, 131, 45, 13);
		contentPane.add(lblTnNsp);

		txtMaNSP = new JTextField();
		txtMaNSP.setBounds(81, 79, 289, 19);
		contentPane.add(txtMaNSP);
		txtMaNSP.setColumns(10);

		txtTenNSP = new JTextField();
		txtTenNSP.setColumns(10);
		txtTenNSP.setBounds(81, 127, 289, 19);
		contentPane.add(txtTenNSP);

		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã Nhóm sản phẩm");
		columns.add("Tên Nhóm sản phẩm");


		NhomSPBUS nhomSPBUS = new NhomSPBUS();
		List<NhomSP> nhomSPs = nhomSPBUS.getList(SqlQuerry.SELECT_ALL_NHOM_SP);
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

		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(122, 174, 85, 21);
		contentPane.add(btnInsert);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(217, 174, 85, 21);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(312, 174, 85, 21);
		contentPane.add(btnDelete);

	}
	

}
