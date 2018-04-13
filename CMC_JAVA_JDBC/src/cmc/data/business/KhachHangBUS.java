package cmc.data.business;

import java.util.List;

import org.apache.log4j.Logger;

import cmc.data.dao.KhachHangDAO;
import cmc.data.model.KhachHang;
import cmc.data.view.KhachHangUI;
import org.apache.log4j.Logger;


public class KhachHangBUS implements BaseBusinessInterface<KhachHang>{

	static Logger log = Logger.getLogger(KhachHangUI.class); 
	@Override
	public boolean insert(KhachHang obj) {
		log.debug("dang o KhacHang BUS thuc hien insert BUS");
		log.info("dang o KhacHang BUS thuc hien insert BUS");
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.insert(obj);
	}

	@Override
	public List<KhachHang> getList(String sql) {
		log.debug("dang o KhacHang BUS thuc hien getlist BUS");
		log.info("dang o KhacHang BUS thuc hien getlist BUS");
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.getList(sql);
	}

	@Override
	public boolean delete(KhachHang obj) {
		log.debug("dang o KhacHang BUS thuc hien delete BUS");
		log.info("dang o KhacHang BUS thuc hien delete BUS");
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.delete(obj);
	}

	@Override
	public boolean update(KhachHang obj) {
		log.debug("dang o KhacHang BUS thuc hien update BUS");
		log.info("dang o KhacHang BUS thuc hien update BUS");
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.update(obj);
	}

	@Override
	public KhachHang getFirst() {
		log.debug("dang o KhacHang BUS thuc hien getfirst BUS");
		log.info("dang o KhacHang BUS thuc hien getfirst BUS");
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.getFirst();
	}

	@Override
	public KhachHang getLast() {
		log.debug("dang o KhacHang BUS thuc hien getLast BUS");
		log.info("dang o KhacHang BUS thuc hien getLast BUS");
		KhachHangDAO khachhangdao = new KhachHangDAO();
		return khachhangdao.getLast();
	}

	@Override
	public KhachHang getCurrent() {
		log.debug("dang o KhacHang BUS thuc hien getCurrent   BUS");
		log.info("dang o KhacHang BUS thuc hien insert BUS");
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
