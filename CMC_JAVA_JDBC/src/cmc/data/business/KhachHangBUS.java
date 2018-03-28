package cmc.data.business;

import java.util.ArrayList;
import java.util.List;

import cmc.data.dao.KhachHangDAO;
import cmc.data.dao.StudentDAO;
import cmc.data.model.KhachHang;
import cmc.data.model.Student;

public class KhachHangBUS implements BaseBusinessInterface<KhachHang>{

	@Override
	public boolean insert(KhachHang obj) {
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.insert(obj);
	}

	@Override
	public List<KhachHang> getList(String sql) {
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.getList(sql);
	}

	@Override
	public boolean delete(KhachHang obj) {
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.delete(obj);
	}

	@Override
	public boolean update(KhachHang obj) {
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.update(obj);
	}

	@Override
	public KhachHang getFirst() {
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.getFirst();
	}

	@Override
	public KhachHang getLast() {
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.getLast();
	}

	@Override
	public KhachHang getCurrent() {
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.getCurrent();
	}

	@Override
	public KhachHang getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
