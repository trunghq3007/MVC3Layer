/**
 * 
 */
package cmc.data.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.KhachHang;
import cmc.data.model.NhanVien;
import cmc.data.sqlserver.ConnectDB;

/**
 * @description:
 * @author: Admin
 * @time: 7:48:39 PM
 * @date: Mar 28, 2018
 */
public class NhanVienDAO implements BaseDaoInterface<NhanVien> {

	NhanVien currentObj;
	@Override
	public boolean insert(NhanVien obj) {
		Connection connect = null;
		String sql = "Insert into NhanVien Values(?,?,?,?,?,?)";
		PreparedStatement prepare = null;

		try {
			connect = ConnectDB.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);

//			prepare.setInt(1, obj.getMaNV());
			prepare.setString(1, obj.getHoTen());
			prepare.setString(2, obj.getGioiTinh());
			prepare.setDate(3, obj.getNgaySinh());
			prepare.setString(4, obj.getDiaChi());
			prepare.setString(5, obj.getDienThoai());
			prepare.setString(6, obj.getGhiChu());

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getList(java.lang.String)
	 */
	@Override
	public List<NhanVien> getList(String sql) {
		// TODO Auto-generated method stub
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<NhanVien> list = null;
		try {
			connect = ConnectDB.connect();
			list = new ArrayList<>();
			statement = connect.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getInt("MaNV"));
				nv.setHoTen(rs.getString("HoTen"));
				nv.setGioiTinh(rs.getString("gioitinh"));
				nv.setNgaySinh(rs.getDate("NgaySinh"));
				nv.setDiaChi(rs.getString("diachi"));
				nv.setDienThoai(rs.getString("dienthoai"));
				nv.setGhiChu(rs.getString("ghichu"));
				list.add(nv);
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
			if (connect != null) {
				try {
					connect.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(NhanVien nv) {
		// TODO Auto-generated method stub
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			String sql = "delete from NhanVien where MaNV = " + nv.getMaNV();
			check = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (check >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(NhanVien nv) {
		// TODO Auto-generated method stub
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			String sql = "update NhanVien set HoTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?, DienThoai=?, GhiChu=? where MaNV=?";
			PreparedStatement prepared = connect.prepareStatement(sql);
			prepared.setString(1, nv.getHoTen());
			prepared.setString(2, nv.getGioiTinh());
			prepared.setDate(3, nv.getNgaySinh());
			prepared.setString(4, nv.getDiaChi());
			prepared.setString(5, nv.getDienThoai());
			prepared.setString(6, nv.getGhiChu());
			prepared.setInt(7, nv.getMaNV());
			check = prepared.executeUpdate();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(check > 0) {
			return true;
		}
		return false;
	}

	@Override
	public NhanVien getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getLast()
	 */
	@Override
	public NhanVien getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getCurrent()
	 */
	@Override
	public NhanVien getCurrent() {
		// TODO Auto-generated method stub
		return currentObj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#setCurrent(java.lang.Object)
	 */
	@Override
	public void setCurrent(NhanVien obj) {
		// TODO Auto-generated method stub
		this.currentObj = obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getNext()
	 */
	@Override
	public NhanVien getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getPrevious()
	 */
	@Override
	public NhanVien getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
