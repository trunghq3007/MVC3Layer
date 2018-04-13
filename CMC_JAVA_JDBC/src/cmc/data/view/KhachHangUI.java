/**
 * 
 */
package cmc.data.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import org.apache.log4j.Logger;

import cmc.data.SqlQuerry;
import cmc.data.business.KhachHangBUS;
import cmc.data.model.KhachHang;
import org.apache.log4j.Logger;

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
	private JTextField txtTenCongTy;
	private JTextField txtDiaChi;
	private JTextField txtThanhPho;
	static Logger log = Logger.getLogger(KhachHangUI.class);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhomSanPhamUI frame = new NhomSanPhamUI();
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
		log.debug("dang o class khachhangUI");
		log.info("dang o class KhachHangUI");
		log.error("loi van de gi do o class KhachHangUI");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		txtmaKH.setEnabled(false);
		txtmaKH.setBounds(200, 94, 234, 19);
		contentPane.add(txtmaKH);
		txtmaKH.setColumns(10);

		txttenKH = new JTextField();
		txttenKH.setBounds(200, 128, 234, 19);
		txttenKH.setColumns(10);
		contentPane.add(txttenKH);

		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã Nhóm sản phẩm");
		columns.add("Tên Nhóm sản phẩm");

		/*
		 * values.add(new String[] { "1", "Đồ gia dụng" }); values.add(new String[] {
		 * "2", "Đồ gia dụng" }); values.add(new String[] { "3", "Đồ gia dụng" });
		 */

		KhachHangBUS khachangBUS = new KhachHangBUS();
		List<KhachHang> khachangs = khachangBUS.getList(SqlQuerry.SELECT_ALL_NHOM_SP);
		for (KhachHang khachhang : khachangs) {
			values.add(new String[] { String.valueOf(khachhang.getMaKH()), khachhang.getTenKH(), khachhang.getTenKH(),khachhang.getUserName(), khachhang.getPassword(), khachhang.getTenCongTy(), khachhang.getDiaChi(),khachhang.getThanhPho()});
		}
		tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());

		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 464, 567, 260);
		contentPane.add(scrollPane);
		
				table = new JTable(tableModel);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						log.info("Dang o EventTable Click trong TABLE");
						log.debug("Dang o EventTable Click trong TABLE");
						
						int row = table.getSelectedRow();
						TableModel model = table.getModel();
						txtmaKH.setText(model.getValueAt(row, 0).toString());
						txttenKH.setText(model.getValueAt(row, 1).toString());
						txtusername.setText(model.getValueAt(row, 2).toString());
						txtpassword.setText(model.getValueAt(row, 3).toString());
						txtTenCongTy.setText(model.getValueAt(row, 4).toString());
						txtDiaChi.setText((model.getValueAt(row, 5).toString()));
						txtThanhPho.setText((model.getValueAt(row, 6).toString()));
					}
				});
				scrollPane.setColumnHeaderView(table);
				table.setFillsViewportHeight(true);
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						// do some actions here, for example
						// print first column value from selected row
						// System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
						JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0).toString());
					}
				});

		JButton btninsert = new JButton("insert");
		btninsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				log.info("Dang o EventMouse Click cua button insert");
				log.debug("Dang o EventMouse Click cua button insert");
				try {
					KhachHang khachhang = new KhachHang();
					khachhang.setTenKH(txttenKH.getText());
					khachhang.setUserName(txtusername.getText());
					khachhang.setTenCongTy(txtTenCongTy.getText());
					khachhang.setDiaChi(txtDiaChi.getText());
					khachhang.setThanhPho(txtThanhPho.getText());
					KhachHangBUS khachhangBUS = new KhachHangBUS();
					khachhangBUS.insert(khachhang);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"loi");
				}
			}
		});
		btninsert.setBounds(26, 346, 85, 21);
		btninsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btninsert.getText().equals("New")) {
					btninsert.setText("Save");
				} else {
					// save
					String maNSP = txtmaKH.getText().trim();
					String tenNSP = txttenKH.getText().trim();
					// and refresh data in table
				}
			}
		});
		contentPane.add(btninsert);

		JButton btnupdate = new JButton("update");
		btnupdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.info("Dang o EventMouse Click button update");
				log.debug("Dang o EventMouse Click button update");
				try {
					KhachHang khachhang = new KhachHang();
					khachhang.setMaKH(Integer.parseInt(txtmaKH.getText()));
					khachhang.setTenKH(txttenKH.getText());
					khachhang.setUserName(txtusername.getText());
					khachhang.setTenCongTy(txtTenCongTy.getText());
					khachhang.setDiaChi(txtDiaChi.getText());
					khachhang.setThanhPho(txtThanhPho.getText());
					KhachHangBUS khachhangBUS = new KhachHangBUS();
					khachhangBUS.update(khachhang);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"loi");
				}
				
			}
		});
		btnupdate.setBounds(122, 346, 85, 21);
		contentPane.add(btnupdate);

		JButton btnDelete = new JButton("delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				log.info("Dang o EventMouse Click button delete");
				log.debug("Dang o EventMouse Click button update");
				try {
					KhachHangBUS khachhangbus = new KhachHangBUS();
					KhachHang khachhang = new KhachHang();
					khachhang.setMaKH(Integer.parseInt(txtmaKH.getText()));
					khachhang.setTenKH(txttenKH.getText());
					khachhang.setUserName(txtusername.getText());
					khachhang.setPassword(txtpassword.getText());
					khachhang.setTenCongTy(txtTenCongTy.getText());
					khachhang.setDiaChi(txtDiaChi.getText());
					khachhang.setThanhPho(txtThanhPho.getText());
					khachhangbus.delete(khachhang);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "loi");
				}
			}
		});
		btnDelete.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDelete.setBounds(219, 346, 85, 21);
		contentPane.add(btnDelete);

		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(495, 94, 85, 21);
		contentPane.add(btnClear);

		JButton btnSearch = new JButton("search");
		btnSearch.setBounds(316, 346, 85, 21);
		contentPane.add(btnSearch);
		
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
		
		txtTenCongTy = new JTextField();
		txtTenCongTy.setBounds(200, 230, 234, 22);
		contentPane.add(txtTenCongTy);
		txtTenCongTy.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(26, 264, 128, 16);
		contentPane.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(200, 265, 234, 22);
		contentPane.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblThanhPho = new JLabel("Thành Phố");
		lblThanhPho.setBounds(26, 304, 128, 16);
		contentPane.add(lblThanhPho);
		
		txtThanhPho = new JTextField();
		txtThanhPho.setBounds(200, 301, 234, 22);
		contentPane.add(txtThanhPho);
		txtThanhPho.setColumns(10);

	}
}
