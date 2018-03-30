package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.NhomSP;
import cmc.data.model.Student;
import cmc.data.sqlserver.ConnectDB;

public class NhomSPDAO implements BaseDaoInterface<NhomSP> {

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
	public boolean delete(NhomSP nhomSP) {
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from NhomSP where maNSP = " + nhomSP.getMaNSP());
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
	public boolean update(NhomSP nhomSP) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			statement = connect.createStatement();
			String sql = "update NhomSP set  maNSP = ?,tenNSP =?";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setInt(1, nhomSP.getMaNSP());
			prepare.setString(2, nhomSP.getTenNSP());

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
	public NhomSP getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhomSP getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhomSP getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrent(NhomSP obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public NhomSP getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhomSP getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
