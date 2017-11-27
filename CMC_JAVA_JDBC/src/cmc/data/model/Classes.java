package cmc.data.model;
/**
 *author nquyet@cmc.com.vn
 *version 1.0 Aug 14, 2017
 */

public class Classes {
	String classId;
	String className;
	String note;
	
	public Classes(String classId, String className, String note) {
		super();
		this.classId = classId;
		this.className = className;
		this.note = note;
	}
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

}

