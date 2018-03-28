/**
 * 
 */
package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import cmc.data.model.NhanVien;
import cmc.data.sqlserver.ConnectDB;

/**
 * @description:
 * @author: Admin
 * @time: 7:48:39 PM
 * @date: Mar 28, 2018
 */
public class NhanVienDAO implements BaseDaoInterface<NhanVien> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(NhanVien obj) {
		Connection connect = null;
		String sql = "Insert into NhanVien Values(?,?,?,?,?,?,?)";
		PreparedStatement prepare = null;

		try {
			connect = ConnectDB.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);

			prepare.setInt(1, obj.getMaNV());
			prepare.setString(2, obj.getHoTen());
			prepare.setString(3, obj.getGioiTinh());
			prepare.setDate(4, obj.getNgaySinh());
			prepare.setString(5, obj.getDiaChi());
			prepare.setString(6, obj.getDienThoai());
			prepare.setString(7, obj.getGhiChu());

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
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(NhanVien obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#update(java.lang.Object)
	 */
	@Override
	public boolean update(NhanVien obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getFirst()
	 */
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
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#setCurrent(java.lang.Object)
	 */
	@Override
	public void setCurrent(NhanVien obj) {
		// TODO Auto-generated method stub

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
