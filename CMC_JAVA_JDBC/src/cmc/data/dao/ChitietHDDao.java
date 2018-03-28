package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import cmc.data.model.ChiTietHD;
import cmc.data.model.HoaDon;
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
	public List<ChiTietHD> getList(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ChiTietHD obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ChiTietHD obj) {
		// TODO Auto-generated method stub
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
