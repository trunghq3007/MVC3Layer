package cmc.data.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cmc.data.business.StudentBUS;
import cmc.data.model.Student;

/**
 * The program to view students
 * 
 * @author nquyet@cmc.com.cn
 *
 */
public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("Danh sách sinh viên");

		StudentBUS studentBUS = new StudentBUS();
		List<Student> list = new ArrayList<Student>();
		list = studentBUS.getAllStudent();
		System.out.println(list.size());
		studentBUS.showStudentList(list);

	}

}
