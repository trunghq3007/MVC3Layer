package cmc.data.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.ChiTietHD;
import cmc.data.model.HoaDon;
import cmc.data.model.NhomSP;
import cmc.data.sqlserver.ConnectDB;

public class ChitietHDDao implements BaseDaoInterface<ChiTietHD> {

	@Override
	public boolean insert(ChiTietHD obj) {
		Connection connect = null;
		String sql = "Insert into HoaDon Values(?,?,?,?,?)";
		PreparedStatement prepare = null;

		try {
			connect = ConnectDB.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);

			prepare.setInt(1, obj.getMaHD());
			prepare.setInt(2, obj.getMaSP());
			prepare.setFloat(3, obj.getDonGia());
			prepare.setInt(3, obj.getSoLuong());
			prepare.setFloat(3, obj.getTongTien());
			

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
	public List<ChiTietHD> getList(String sql) {Connection connect = null;
	Statement statement = null;
	ResultSet rs = null;
	List<ChiTietHD> list = null;
	try {
		connect = ConnectDB.connect();
		list = new ArrayList<>();
		// Statement creation
		statement = connect.createStatement();
		// for retrieve data
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			ChiTietHD ChiTietHD = new ChiTietHD();
			ChiTietHD.setMaHD(rs.getInt("maHD"));
			ChiTietHD.setMaSP(rs.getInt("maSP"));
			ChiTietHD.setDonGia(rs.getFloat("donGia"));
			ChiTietHD.setSoLuong(rs.getInt("soLuong"));
			ChiTietHD.setTongTien(rs.getFloat("donGia"));
			
			list.add(ChiTietHD);
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
	public List<ChiTietHD> getAll() {
		Connection connect = null;
		CallableStatement proc = null;
		ResultSet rs = null;
		List<ChiTietHD> list = null;
		try {
			connect = ConnectDB.connect();
			list = new ArrayList<>();
			// Statement creation

			proc = connect.prepareCall("{call [chitietHDGetAll]}");
			// for retrieve data
			rs = proc.executeQuery();
			while (rs.next()) {
				ChiTietHD chiTietHD = new ChiTietHD();
				chiTietHD.setMaHD(rs.getInt("maHD"));
				chiTietHD.setMaSP(rs.getInt("maSP"));
				chiTietHD.setDonGia(rs.getFloat("dongia"));
				chiTietHD.setSoLuong(rs.getInt("Soluong"));
				chiTietHD.setDonGia(rs.getFloat("tongtien"));
				list.add(chiTietHD);
			}
			rs.close();
			proc.close();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (proc != null) {
				try {
					proc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean delete(ChiTietHD obj) {
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from ChitietHD where maHD = " + obj.getMaHD());
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
	public boolean update(ChiTietHD obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			statement = connect.createStatement();
			String sql = "update chitietHD set maSP = ? , dongia =? , Soluong =?, tongtien=? where maHD = ? ";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setInt(1, obj.getMaSP());
			prepare.setFloat(2, obj.getDonGia());
			prepare.setInt(3, obj.getSoLuong());
			prepare.setFloat(4, obj.getTongTien());
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
	public ChiTietHD getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietHD getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietHD getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrent(ChiTietHD obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChiTietHD getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietHD getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
