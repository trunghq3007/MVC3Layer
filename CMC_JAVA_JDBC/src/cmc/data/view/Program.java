package cmc.data.view;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import cmc.data.sqlserver.ConnectDB;

/**
 * The program to view students
 * 
 * @author nquyet@cmc.com.cn
 *
 */
public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// // TODO Auto-generated method stub
		/*
		 * System.out.println("Danh sách lớp"); //StudentBUS studentBUS = new
		 * StudentBUS(); //List<Classes> list = new ArrayList<Classes>(); List<Classes>
		 * list = new StudentBUS().getAllClasses(); //System.out.println(list.size());
		 * for (Classes class1 : list) { System.out.print(class1.getClassId() + "/");
		 * System.out.print(class1.getClassName() + "/");
		 * System.out.println(class1.getNote()); }
		 */

		// System.out.println("Danh sách sinh viên");
		// StudentBUS studentBUS = new StudentBUS();
		// List<Student> list = new ArrayList<Student>();
		// list = studentBUS.getAllStudent();
		// //System.out.println(list.size());
		// for (Student student : list) {
		// System.out.print(student.getStudentId() + "/");
		// System.out.print(student.getFullName() + "/");
		// System.out.print(student.getAddress() + "/");
		// System.out.println(student.getAge());
		// }

		// StudentBUS studentBUS = new StudentBUS();
		// Student student = new Student(6, "Bui Quang Huy", "Hai Phong", 18);
		// studentBUS.insert(student);

		Connection connect;
		try {
			
			connect = ConnectDB.ConnectOther();
			if (connect != null) {
				System.out.println("successfully");

				CallableStatement objCmst;
				ResultSet objRs;
				objCmst = connect.prepareCall("{call SP_Get_WB_ofArea(?)}");

				objCmst.setString(1, "5572827A-B5DF-4244-A8AA-37EEACA9B67C");
				// objCmst.setInt(2, 1);
				objRs = objCmst.executeQuery();

				String english;
				String wbId;
				String vietnamese;
				byte[] img;
				// WBModel wbObj;
				try {
					while (objRs.next()) {
						english = objRs.getString("WEnglish");
						System.out.println(english);

						wbId = objRs.getString("WBId");
						System.out.println(wbId);

						vietnamese = objRs.getString("WVietnamese");
						System.out.println(vietnamese);

						// wbObj = new WBModel(wbId, english, vietnamese, img, null);
						// arrayListWB.add(wbObj);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
