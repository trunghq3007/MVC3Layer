package cmc.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cmc.data.model.Classes;
import cmc.data.model.Student;
import cmc.data.sqlserver.ConnectDB;

public class StudentDAO {
	public boolean insert(Student student) throws ClassNotFoundException, SQLException
	{
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
		}
		finally
		{
			connect.close();
		}
		return true;
	}
	
	public List<Student> getList(String sql) throws SQLException
	{
		Connection connect;
		//ConnectDB connectDB = new ConnectDB();
		try {
			connect = ConnectDB.Connect();
			List<Student> list = new ArrayList<Student>();
			//Statement creation
			Statement statement = connect.createStatement();
			//for retrieve data
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
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
	public List<Classes> getListClasses(String sql) throws ClassNotFoundException, SQLException {
		Connection connect;
		connect = ConnectDB.Connect();
		List<Classes> list = new ArrayList<Classes>();
		//Statement creation
		Statement statement = connect.createStatement();
		//for retrieve data
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				Classes class1 = new Classes();
				class1.setClassId(rs.getString("ClassId"));
				class1.setClassName(rs.getString("className"));
				class1.setNote(rs.getString("note"));
				list.add(class1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally
		{
			connect.close();
		}
		return list;
	}
}
