package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.HoaDon;
import cmc.data.model.NhanVien;
import cmc.data.model.NhomSP;
import cmc.data.sqlserver.ConnectDB;

public class HoaDonDAO implements BaseDaoInterface<HoaDon> {
	HoaDon currentObj;

	@Override
	public boolean insert(HoaDon obj) {
		Connection connect = null;
		String sql = "Insert into HoaDon Values(?,?,?,?,?,)";
		PreparedStatement prepare = null;

		try {
			connect = ConnectDB.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);

			prepare.setInt(1, obj.getMaHD());
			prepare.setInt(2, obj.getMaKH());
			prepare.setInt(3, obj.getMaNV());
			prepare.setFloat(4, obj.getTongTien());
			prepare.setDate(5, obj.getNgayLHD());
			

			connect.setAutoCommit(true);
			prepare.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	@Override
	public List<HoaDon> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<HoaDon> list = null;
		try {
			connect = ConnectDB.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				HoaDon hoadon = new HoaDon();
				hoadon.setMaHD(rs.getInt("maHD"));
				hoadon.setMaKH(rs.getInt("maKH"));
				hoadon.setMaNV(rs.getInt("maNV"));
				hoadon.setTongTien(rs.getFloat("tongTien"));
				hoadon.setNgayLHD(rs.getDate("ngayLHD"));
				
				list.add(hoadon);
			}
			rs.close();
			statement.close();
			connect.close();
			return list;
		} catch (ClassNotFoundException e) {
			return list;
		} catch (SQLException e) {
			return list;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean delete(HoaDon obj) {
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from HoaDon where maHD = " + obj.getMaHD());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if (check >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(HoaDon obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			statement = connect.createStatement();
			String sql = "update HoaDon set  maKH =?, maNV = ? , tongTien =? , ngayLHD =? where maHD = ?   ";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setInt(1, obj.getMaKH());
			prepare.setInt(2, obj.getMaNV());
			prepare.setFloat(3, obj.getTongTien());
			prepare.setDate(4, obj.getNgayLHD());
			prepare.setInt(5, obj.getMaHD());
			check = prepare.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (check > 0) {
			return true;
		}
		return false;
	}

	@Override
	public HoaDon getFirst() {
		List<HoaDon> list = getList("select * from HoaDon");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public HoaDon getLast() {
		List<HoaDon> list = getList("select * from HoaDon");
		int size = list.size();
		if (size > 0) {
			return list.get(size - 1);
		}
		return null;
	}

	@Override
	public HoaDon getCurrent() {
		
		return currentObj;
	}

	@Override
	public void setCurrent(HoaDon obj) {
		this.currentObj = obj;
		
	}

	@Override
	public HoaDon getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
