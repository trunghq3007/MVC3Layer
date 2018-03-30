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
	static String userName = "";
	static String passWord = "";
	/*static String URL = "jdbc:sqlserver://localhost:1433"
			+ ";instance=SQLEXPRESS;databaseName=CSD-RDC;integratedSecurity=true;";
*/
	static String URL = "jdbc:sqlserver://localhost:1433"
			+ ";instance=SQLEXPRESS;databaseName=CSD-RDC ;integratedSecurity=true;";
	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection connect() throws ClassNotFoundException, SQLException {
		// load driver
		Class.forName(Driver);
		// get connection
		Connection cn = DriverManager.getConnection(URL, userName, passWord);
		return cn;
	}

}
