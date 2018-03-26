/**
 * 
 */
package cmc.data.model;

import java.sql.Date;

/**
 * @description:
 * @author: Admin
 * @time: 9:01:10 PM
 * @date: Mar 26, 2018
 */
public class HoaDon {
	private int maHD;
	private int maKH;
	private String maNV;
	private float tongTien;
	private Date ngayLHD;

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 26, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 26, 2018
	 * @exception:
	 * @param maHD
	 * @param maKH
	 * @param maNV
	 * @param tongTien
	 * @param ngayLHD
	 */
	public HoaDon(int maHD, int maKH, String maNV, float tongTien, Date ngayLHD) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.tongTien = tongTien;
		this.ngayLHD = ngayLHD;
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
	 * @return the maKH
	 */
	public int getMaKH() {
		return maKH;
	}

	/**
	 * @param maKH
	 *            the maKH to set
	 */
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	/**
	 * @return the maNV
	 */
	public String getMaNV() {
		return maNV;
	}

	/**
	 * @param maNV
	 *            the maNV to set
	 */
	public void setMaNV(String maNV) {
		this.maNV = maNV;
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

	/**
	 * @return the ngayLHD
	 */
	public Date getNgayLHD() {
		return ngayLHD;
	}

	/**
	 * @param ngayLHD
	 *            the ngayLHD to set
	 */
	public void setNgayLHD(Date ngayLHD) {
		this.ngayLHD = ngayLHD;
	}

}
