package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cmc.data.model.KhachHang;
import cmc.data.sqlserver.ConnectDB;

public class KhachHangDAO implements BaseDaoInterface<KhachHang>{
	static Logger log = Logger.getLogger(KhachHangDAO.class);
	KhachHang currentObj;
	@Override
	public boolean insert(KhachHang obj) {
		log.debug("dang o KhacHang DAO thuc hien insert DAO");
		log.info("dang o KhacHang DAO thuc hien insert DAO");
		Connection connect = null;
		String sql = "Insert into KhachHang Values(?,?,?,?,?,?,?)";
		PreparedStatement prepare = null;

		try {
			connect = ConnectDB.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);

			prepare.setInt(1, obj.getMaKH());
			prepare.setString(2, obj.getTenKH());
			prepare.setString(3, obj.getUserName());
			prepare.setString(4, obj.getPassword());
			prepare.setString(5, obj.getTenCongTy());
			prepare.setString(6, obj.getDiaChi());
			prepare.setString(7, obj.getThanhPho());

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
	public List<KhachHang> getList(String sql) {
		log.debug("dang o KhacHang DAO thuc hien getlist DAO");
		log.info("dang o KhacHang DAO thuc hien getlist DAO");
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<KhachHang> list = null;
		try {
			connect = ConnectDB.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				KhachHang khachhang = new KhachHang();
				khachhang.setMaKH(rs.getInt("maKH"));
				khachhang.setTenKH(rs.getString("tenKH"));
				khachhang.setUserName(rs.getString("userName"));
				khachhang.setPassword(rs.getString("password"));
				khachhang.setTenCongTy("tenCongTy");
				khachhang.setDiaChi(rs.getString("diaChi"));
				khachhang.setThanhPho(rs.getString("thanhPho"));
				list.add(khachhang);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
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
	public boolean delete(KhachHang khachhang) {
		log.debug("dang o KhacHang DAO thuc hien delete DAO");
		log.info("dang o KhacHang DAO thuc hien delete DAO");
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from KhachHang where maKH = " + khachhang.getMaKH());
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
	public boolean update(KhachHang obj) {
		log.debug("dang o KhacHang DAO thuc hien update DAO");
		log.info("dang o KhacHang DAO thuc hien update DAO");
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			String sql = "update NhomSP set diaChi = ? where maKH = ?";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setString(1, obj.getDiaChi());
			prepare.setInt(2, obj.getMaKH());
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
	public KhachHang getFirst() {
		log.debug("dang o KhacHang DAO thuc hien getfirst DAO");
		log.info("dang o KhacHang DAO thuc hien getfirst DAO");
		List<KhachHang> list = getList("select * from NhomSP");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public KhachHang getLast() {
		log.debug("dang o KhacHang DAO thuc hien insert getLast");
		log.info("dang o KhacHang DAO thuc hien insert getLast");
		List<KhachHang> list = getList("select * from NhomSP");
		int size = list.size();
		if (size > 0) {
			return list.get(size - 1);
		}
		return null;
	}

	@Override
	public KhachHang getCurrent() {
		log.debug("dang o KhacHang DAO thuc hien getCurrent");
		log.info("dang o KhacHang BUS thuc hien getCurrent");
		return currentObj;
	}

	@Override
	public void setCurrent(KhachHang obj) {
		this.currentObj = obj;
	}

	@Override
	public KhachHang getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
