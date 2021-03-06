package cmc.data.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cmc.data.dao.StudentDAO;
import cmc.data.model.Student;

/**
 * @description:
 * @create_date: Nov 27, 2017
 * @author: Ha Quang Trung CMC RDC-Traniner
 * @modify_date: Nov 27, 2017
 * @modifier: NgQuyet
 * @exception:
 */
public class StudentBUS {

	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<Student>();
		StudentDAO studentDAO = new StudentDAO();
		try {
			list = studentDAO.getList("Select * from Student ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * @description:
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
		try {
			return new StudentDAO().insert(student);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 21, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 21, 2018
	 * @exception:
	 * @param list
	 */
	public void showStudentList(List<Student> list) {
		// hiển thị các student trong list
		for (Student student : list) {
			System.out.print(student.getStudentId() + "/");
			System.out.print(student.getFullName() + "/");
			System.out.print(student.getAddress() + "/");
			System.out.println(student.getAge());
		}
	}
}
