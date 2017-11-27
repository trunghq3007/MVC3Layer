package cmc.data.sqlserver;

import java.sql.*;

/**
 * @description: 
 * @create_date: Nov 27, 2017
 * @author: Ha Quang Trung CMC RDC-Traniner
 * @modify_date: Nov 27, 2017
 * @modifier: Ha Quang Trung
 * @exception: 
 */
public class ConnectDB {
	static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String ConnectionURL = "jdbc:sqlserver://localhost:1433"
	       + ";instance=SQLEXPRESS;databaseName=University;";
	static String userName = "sa";
	static String passWord = "1234567";
	static String URL ="jdbc:sqlserver://localhost:1433"
	       + ";instance=SQLEXPRESS;databaseName=University;integratedSecurity=true;";
	
	
	static String ConnectionURLOther = "jdbc:sqlserver://localhost:1433"
		       + ";instance=SQLEXPRESS;databaseName=FEEDBACK_PROJ;";
	/**
	 * Method return connection database
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection Connect() throws ClassNotFoundException, SQLException
	{
		//load driver
		Class.forName(Driver);
		//get connection
		Connection cn = DriverManager.getConnection(ConnectionURL,userName,passWord);
		return cn;
	}
	

	/**
	 * @description: handle connect to FeedbackProj
	 * @create_date: Nov 27, 2017
	 * @author: Ha Quang Trung CMC RDC-Traniner
	 * @modify_date: Nov 27, 2017
	 * @modifier: Ha Quang Trung
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @exception: 
	 */
	public static Connection ConnectOther() throws ClassNotFoundException, SQLException
	{
		//load driver
		Class.forName(Driver);
		//get connection
		Connection cn = DriverManager.getConnection(ConnectionURLOther,userName,passWord);
		return cn;
	}
}
