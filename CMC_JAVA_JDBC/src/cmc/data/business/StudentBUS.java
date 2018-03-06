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
			list = studentDAO.getList("Select * from Student");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public boolean insert(Student student) throws ClassNotFoundException, SQLException {
		return new StudentDAO().insert(student);
	}

}
