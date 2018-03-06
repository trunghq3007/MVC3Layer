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
		Connection connect = ConnectDB.Connect();
		String sql = "Insert into Student Values(?,?,?,?)";
		PreparedStatement prepare = connect.prepareStatement(sql);
		connect.setAutoCommit(false);
		prepare.setInt(1, student.getStudentId());
		prepare.setString(2, student.getFullName());
		prepare.setString(3, student.getAddress());
		prepare.setInt(4, student.getAge());
		connect.setAutoCommit(true);
		try {
			prepare.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
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
		Connection connect;
		// ConnectDB connectDB = new ConnectDB();
		try {
			connect = ConnectDB.Connect();
			List<Student> list = new ArrayList<Student>();
			// Statement creation
			Statement statement = connect.createStatement();
			// for retrieve data
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setFullName(rs.getString("fullName"));
				student.setAddress(rs.getString("address"));
				student.setAge(rs.getInt("Age"));
				list.add(student);
			}
			connect.close();
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
