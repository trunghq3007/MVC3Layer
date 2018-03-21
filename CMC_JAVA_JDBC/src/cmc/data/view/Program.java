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
		StudentBUS studentBUS = new StudentBUS();
		List<Student> list = new ArrayList<Student>();
		list = studentBUS.getAllStudent();

		/*Student student = new Student();
		student.setStudentId(100);
		student.setFullName("abc");
		student.setAge(20);
		student.setAddress("add");*/
		// them moi student
		//studentBUS.insert(student);
		/*list = studentBUS.getAllStudent();
		studentBUS.showStudentList(list);*/
		// studentBUS.deleteStudent(list.get(0));

		// list = studentBUS.getAllStudent();
		// studentBUS.showStudentList(list);
		Student student2 = list.get(0);
		student2.setAddress("sssssssssssssssssssssss");
		studentBUS.updateStudent(student2);
		
		
		list = studentBUS.getAllStudent();
		//studentBUS.showStudentList(list);
	}

}
