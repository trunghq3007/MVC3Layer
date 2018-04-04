/**
 * 
 */
package cmc.data.model;

import java.sql.Date;

/**
 * @description:
 * @author: Admin
 * @time: 8:54:13 PM
 * @date: Mar 26, 2018
 */
public class NhanVien {
	private int maNV;
	private String hoTen;
	private String gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String dienThoai;
	private String ghiChu;

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 26, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 26, 2018
	 * @exception:
	 * @param maNV
	 * @param hoTen
	 * @param gioiTinh
	 * @param ngaySinh
	 * @param diaChi
	 * @param dienThoai
	 * @param ghiChu
	 */
	public NhanVien() {
		
	}
	
	public NhanVien(int maNV, String hoTen, String gioiTinh, Date ngaySinh, String diaChi, String dienThoai,
			String ghiChu) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.ghiChu = ghiChu;
	}

	/**
	 * @return the maNV
	 */
	public int getMaNV() {
		return maNV;
	}

	/**
	 * @param maNV
	 *            the maNV to set
	 */
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}

	/**
	 * @param hoTen
	 *            the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh
	 *            the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh
	 *            the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi
	 *            the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/**
	 * @return the dienThoai
	 */
	public String getDienThoai() {
		return dienThoai;
	}

	/**
	 * @param dienThoai
	 *            the dienThoai to set
	 */
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	/**
	 * @return the ghiChu
	 */
	public String getGhiChu() {
		return ghiChu;
	}

	/**
	 * @param ghiChu
	 *            the ghiChu to set
	 */
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
