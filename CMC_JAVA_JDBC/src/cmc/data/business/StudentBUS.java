package cmc.data.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cmc.data.dao.StudentDAO;
import cmc.data.model.Student;

/**
 * @description: business of student table
 * @create_date: Nov 27, 2017
 * @author: Ha Quang Trung CMC RDC-Traniner
 * @modify_date: Nov 27, 2017
 * @modifier: NgQuyet
 * @exception:
 */
public class StudentBUS {

	/**
	 * @description: get all Student in Student table
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 23, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 23, 2018
	 * @exception:
	 * @return: List<Student>
	 */
	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<>();
		StudentDAO studentDAO = new StudentDAO();
		list = studentDAO.getList("Select * from Student ");
		return list;

	}

	/**
	 * @description: insert new student into student table
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
	public boolean insert(Student student) {
		return new StudentDAO().insert(student);
	}

	/**
	 * @description: show list student on screen
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @param list
	 */
	public void showStudentList(List<Student> list) {

		System.out.println("Danh sách sinh viên");
		// hiển thị các student trong list
		for (Student student : list) {
			System.out.print(student.getStudentId() + "/");
			System.out.print(student.getFullName() + "/");
			System.out.print(student.getAddress() + "/");
			System.out.println(student.getAge());
			System.out.println();
		}
	}

	/**
	 * @description: delete student in student table
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @param student
	 * @return
	 */
	public boolean deleteStudent(Student student) {
		StudentDAO studentDAO = new StudentDAO();
		return studentDAO.deleteStudent(student);
	}

	/**
	 * @description: update student in student table
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student) {
		StudentDAO studentDAO = new StudentDAO();
		return studentDAO.updateStudent(student);
	}
}
