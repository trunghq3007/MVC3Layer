package cmc.data.model;

public class ChiTietHoaDon {
	private int MaHD;
	private int MaSP;
	private float DonGia;
	private int SoLuong;
	private float TongTien;
	public ChiTietHoaDon(int maHD, int maSP, float donGia, int soLuong, float tongTien) {
		super();
		MaHD = maHD;
		MaSP = maSP;
		DonGia = donGia;
		SoLuong = soLuong;
		TongTien = tongTien;
	}
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	public int getMaSP() {
		return MaSP;
	}
	public void setMaSP(int maSP) {
		MaSP = maSP;
	}
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	
}
