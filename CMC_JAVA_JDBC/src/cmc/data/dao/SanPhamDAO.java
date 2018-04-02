package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.SanPham;
import cmc.data.sqlserver.ConnectDB;

public class SanPhamDAO implements BaseDaoInterface<SanPham> {
	SanPham currentObj;

	@Override
	public boolean insert(SanPham obj) {
		Connection connect = null;
		String sql = "Insert INTO dbo.SanPham (tenSP,maNSP,donGia,  soLuong, anh)VALUES (?, ?,?,?, ?)";
		PreparedStatement prepare = null;

		try {
			connect = ConnectDB.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			prepare.setString(1, obj.getTenSP());
			prepare.setInt(2,obj.getMaNSP());
			prepare.setFloat(3, obj.getDonGia());
			prepare.setInt(4, obj.getSoLuong());
			prepare.setString(5, obj.getAnh());
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
	public List<SanPham> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<SanPham> list = null;
		try {
			connect = ConnectDB.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				SanPham sanPham = new SanPham();
				sanPham.setMaSP(rs.getInt("maSP"));
				sanPham.setTenSP(rs.getString("tenSP"));
				sanPham.setMaNSP(rs.getInt("maNSP"));
				sanPham.setDonGia(rs.getFloat("donGia"));
				sanPham.setSoLuong(rs.getInt("soLuong"));
				sanPham.setAnh(rs.getString("anh"));
				list.add(sanPham);
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
	public boolean delete(SanPham obj) {
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from SanPham where maSP = " + obj.getMaSP());
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
	public boolean update(SanPham obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			statement = connect.createStatement();
			String sql = "update SanPham set  tenSP = ?,maNSP=?,donGia=?,soLuong=?,anh=? where maSP = ?";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setString(1, obj.getTenSP());
			prepare.setInt(2, obj.getMaNSP());
			prepare.setFloat(3, obj.getDonGia());
			prepare.setInt(4, obj.getSoLuong());
			prepare.setString(5, obj.getAnh());
			prepare.setInt(6, obj.getMaSP());
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
	public SanPham getFirst() {
		List<SanPham> list = getList("select * from SanPham");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public SanPham getLast() {
		List<SanPham> list = getList("select * from SanPham");
		int size = list.size();
		if (size > 0) {
			return list.get(size - 1);
		}
		return null;
	}

	@Override
	public SanPham getCurrent() {
		return currentObj;
	}

	@Override
	public void setCurrent(SanPham obj) {
		this.currentObj = obj;
	}

	@Override
	public SanPham getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPham getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
