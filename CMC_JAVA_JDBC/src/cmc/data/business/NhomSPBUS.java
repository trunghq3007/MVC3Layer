package cmc.data.business;

import java.util.ArrayList;
import java.util.List;

import cmc.data.dao.NhomSPDAO;
import cmc.data.dao.StudentDAO;
import cmc.data.model.NhomSP;
import cmc.data.model.Student;

public class NhomSPBUS implements BaseBusinessInterface<NhomSP>{

	@Override
	public boolean insert(NhomSP nhomSP) {
		return new NhomSPDAO().insert(nhomSP);
	}

	@Override
	public List<NhomSP> getList(String sql) {
		List<NhomSP> list = new ArrayList<>();
		NhomSPDAO nhomSPDAO = new NhomSPDAO();
		list = nhomSPDAO.getList("Select * from NhomSP ");
		return list;
	}

	@Override
	public boolean delete(NhomSP nhomSP) {
		NhomSPDAO nhomSPDAO = new NhomSPDAO();
		return nhomSPDAO.delete(nhomSP);
	}

	@Override
	public boolean update(NhomSP nhomSP) {
		NhomSPDAO nhomSPDAO = new NhomSPDAO();
		return nhomSPDAO.update(nhomSP);
	}

	@Override
	public NhomSP getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhomSP getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhomSP getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhomSP getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhomSP getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
