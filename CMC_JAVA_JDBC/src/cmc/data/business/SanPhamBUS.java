package cmc.data.business;

import java.util.List;

import cmc.data.dao.SanPhamDAO;
import cmc.data.model.SanPham;

public class SanPhamBUS implements BaseBusinessInterface<SanPham> {

	@Override
	public boolean insert(SanPham obj) {
		return new SanPhamDAO().insert(obj);
	}

	@Override
	public List<SanPham> getList(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
	public void showSanPhamList(List<SanPham> list) {

		System.out.println("Danh sách san pham");
		// hiển thị các student trong list
		for (SanPham sanPham : list) {
			System.out.print(sanPham.getMaSP()+ "/");
			System.out.print(sanPham.getTenSP() + "/");
			System.out.print(sanPham.getMaNSP() + "/");
			System.out.print(sanPham.getDonGia() + "/");
			System.out.print(sanPham.getSoLuongHang()+ "/");
			System.out.println(sanPham.getAnh());
			System.out.println();
		}
	}

	@Override
	public boolean delete(SanPham obj) {
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		return sanPhamDao.delete(obj);
	}

	@Override
	public boolean update(SanPham obj) {
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		return sanPhamDao.update(obj);
	}

	@Override
	public SanPham getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPham getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPham getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPham getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPham getPrevious() {
		// TODO Auto-generated method stub
		return null;
	}

}
