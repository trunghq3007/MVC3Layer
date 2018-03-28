/**
 * 
 */
package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.NhomSP;
import cmc.data.sqlserver.ConnectDB;

/**
 * @description:
 * @author: Admin
 * @time: 3:35:37 PM
 * @date: Mar 28, 2018
 */
public class NhomSanPhamDAO implements BaseDaoInterface<NhomSP> {

	NhomSP currentObj;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(NhomSP obj) {
		Connection connect = null;
		String sql = "Insert into NhomSP Values(?,?)";
		PreparedStatement prepare = null;

		try {
			connect = ConnectDB.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);

			prepare.setInt(1, obj.getMaNSP());
			prepare.setString(2, obj.getTenNSP());

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
	public List<NhomSP> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<NhomSP> list = null;
		try {
			connect = ConnectDB.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				NhomSP nhomSP = new NhomSP();
				nhomSP.setMaNSP(rs.getInt("maNSP"));
				nhomSP.setTenNSP(rs.getString("tenNSP"));
				list.add(nhomSP);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(NhomSP obj) {
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from NhomSP where maNSP = " + obj.getMaNSP());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#update(java.lang.Object)
	 */
	@Override
	public boolean update(NhomSP obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			statement = connect.createStatement();
			String sql = "update NhomSP set  tenNSP = ? where maNSP = ?";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setString(1, obj.getTenNSP());
			prepare.setInt(2, obj.getMaNSP());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getFirst()
	 */
	@Override
	public NhomSP getFirst() {
		List<NhomSP> list = getList("select * from NhomSP");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getLast()
	 */
	@Override
	public NhomSP getLast() {
		List<NhomSP> list = getList("select * from NhomSP");
		int size = list.size();
		if (size > 0) {
			return list.get(size - 1);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getCurrent()
	 */
	@Override
	public NhomSP getCurrent() {
		return currentObj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#setCurrent(java.lang.Object)
	 */
	@Override
	public void setCurrent(NhomSP obj) {
		this.currentObj = obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getNext()
	 */
	@Override
	public NhomSP getNext() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cmc.data.dao.BaseDaoInterface#getPrevious()
	 */
	@Override
	public NhomSP getPrevious() {
		return null;
	}

}
