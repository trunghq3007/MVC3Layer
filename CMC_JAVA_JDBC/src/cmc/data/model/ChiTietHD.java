/**
 * 
 */
package cmc.data.model;

/**
 * @description:
 * @author: Admin
 * @time: 9:11:25 PM
 * @date: Mar 26, 2018
 */
public class ChiTietHD {
	private int maHD;
	private int maSP;
	private float donGia;
	private int soLuong;
	private float tongTien;

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 26, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 26, 2018
	 * @exception:
	 * @param maHD
	 * @param maSP
	 * @param donGia
	 * @param soLuong
	 * @param tongTien
	 */
	public ChiTietHD(int maHD, int maSP, float donGia, int soLuong, float tongTien) {
		super();
		this.maHD = maHD;
		this.maSP = maSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}

	/**
	 * @return the maHD
	 */
	public int getMaHD() {
		return maHD;
	}

	/**
	 * @param maHD
	 *            the maHD to set
	 */
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	/**
	 * @return the maSP
	 */
	public int getMaSP() {
		return maSP;
	}

	/**
	 * @param maSP
	 *            the maSP to set
	 */
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	/**
	 * @return the donGia
	 */
	public float getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia
	 *            the donGia to set
	 */
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}

	/**
	 * @param soLuong
	 *            the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	/**
	 * @return the tongTien
	 */
	public float getTongTien() {
		return tongTien;
	}

	/**
	 * @param tongTien
	 *            the tongTien to set
	 */
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

}
