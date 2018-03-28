/**
 * 
 */
package cmc.data.model;

/**
 * @description:
 * @author: Admin
 * @time: 9:04:45 PM
 * @date: Mar 26, 2018
 */
public class SanPham {
	private int maSP;
	private String tenSP;
	private int maNSP;
	private float donGia;
	private int soLuongHang;
	private String anh;

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 26, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 26, 2018
	 * @exception:
	 * @param maSP
	 * @param tenSP
	 * @param maNSP
	 * @param donGia
	 * @param soLuongHang
	 * @param anh
	 */
	public SanPham(int maSP, String tenSP, int maNSP, float donGia, int soLuongHang, String anh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.maNSP = maNSP;
		this.donGia = donGia;
		this.soLuongHang = soLuongHang;
		this.anh = anh;
	}

	/**
	 * @return the maSP
	 */
	public int getMaSP() {
		return maSP;
	}

	/**
	 * 
	 */
	public SanPham() {
	
	}

	/**
	 * @param maSP
	 *            the maSP to set
	 */
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	/**
	 * @return the tenSP
	 */
	public String getTenSP() {
		return tenSP;
	}

	/**
	 * @param tenSP
	 *            the tenSP to set
	 */
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	/**
	 * @return the maNSP
	 */
	public int getMaNSP() {
		return maNSP;
	}

	/**
	 * @param maNSP
	 *            the maNSP to set
	 */
	public void setMaNSP(int maNSP) {
		this.maNSP = maNSP;
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
	 * @return the soLuongHang
	 */
	public int getSoLuongHang() {
		return soLuongHang;
	}

	/**
	 * @param soLuongHang
	 *            the soLuongHang to set
	 */
	public void setSoLuongHang(int soLuongHang) {
		this.soLuongHang = soLuongHang;
	}

	/**
	 * @return the anh
	 */
	public String getAnh() {
		return anh;
	}

	/**
	 * @param anh
	 *            the anh to set
	 */
	public void setAnh(String anh) {
		this.anh = anh;
	}

}
