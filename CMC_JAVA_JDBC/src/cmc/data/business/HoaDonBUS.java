package cmc.data.business;

import java.util.List;

import cmc.data.dao.HoaDonDAO;

import cmc.data.model.HoaDon;

public class HoaDonBUS  implements BaseBusinessInterface<HoaDon>{

	@Override
	public boolean insert(HoaDon hoadon) {
		return new HoaDonDAO().insert(hoadon);
	}

	@Override
	public List<HoaDon> getList(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(HoaDon hoadon) {
		HoaDonDAO hoaDonDAO = new HoaDonDAO();
		return hoaDonDAO.delete(hoadon);
	}

	@Override
	public boolean update(HoaDon hoadon) {
		HoaDonDAO hoaDonDAO = new HoaDonDAO();
		return hoaDonDAO.update(hoadon);
	}

	@Override
	public HoaDon getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoaDon getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
