package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.Student;
import cmc.data.sqlserver.ConnectDB;

public class StudentDAO {
	/**
	 * @description: handle insert to db
	 * @create_date: Nov 27, 2017
	 * @author: Ha Quang Trung CMC RDC-Traniner
	 * @modify_date: Nov 27, 2017
	 * @modifier: Ha Quang Trung
	 * @param student
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @exception:
	 */
	public boolean insert(Student student) throws ClassNotFoundException, SQLException {
		Connection connect = ConnectDB.connect();
		String sql = "Insert into Student Values(?,?,?,?)";
		PreparedStatement prepare = null;

		try {
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);

			prepare.setInt(1, student.getStudentId());
			prepare.setString(2, student.getFullName());
			prepare.setString(3, student.getAddress());
			prepare.setInt(4, student.getAge());

			connect.setAutoCommit(true);
			prepare.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (prepare != null) {
				prepare.close();
			}
			connect.close();
		}
		return true;
	}

	/**
	 * @description: get all student from tbl student
	 * @create_date: Nov 27, 2017
	 * @author: Ha Quang Trung CMC RDC-Traniner
	 * @modify_date: Nov 27, 2017
	 * @modifier: Ha Quang Trung
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @exception:
	 */
	public List<Student> getList(String sql) throws SQLException {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Student> list = null;
		try {
			connect = ConnectDB.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setFullName(rs.getString("fullName"));
				student.setAddress(rs.getString("address"));
				student.setAge(rs.getInt("age"));
				list.add(student);
			}
			rs.close();
			statement.close();
			connect.close();
			return list;
		} catch (ClassNotFoundException e) {
			return list;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		}
	}

	/**
	 * @description:delete student in csdl
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @param student
	 * @return
	 */
	public boolean deleteStudent(Student student) {
		Connection connect;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from Student where studentId = " + student.getStudentId());
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

	public boolean updateStudent(Student student) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = ConnectDB.connect();
			statement = connect.createStatement();
			String sql = "update Student set  fullName = ?,address =?, age= ? where studentId = ?";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setString(1, student.getFullName());
			prepare.setString(2, student.getAddress());
			prepare.setInt(3, student.getAge());
			prepare.setInt(4, student.getStudentId());
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

}
