/**
 * 
 */
package cmc.data.model;

/**
 * @description:
 * @author: Admin
 * @time: 8:57:53 PM
 * @date: Mar 26, 2018
 */
public class KhachHang {
	private int maKH;
	private String tenKH;
	private String userName;
	private String password;
	private String tenCongTy;
	private String diaChi;
	private String thanhPho;

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 26, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 26, 2018
	 * @exception:
	 * @param maKH
	 * @param tenKH
	 * @param userName
	 * @param password
	 * @param tenCongTy
	 * @param diaChi
	 * @param thanhPho
	 */
	public KhachHang(int maKH, String tenKH, String userName, String password, String tenCongTy, String diaChi,
			String thanhPho) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.userName = userName;
		this.password = password;
		this.tenCongTy = tenCongTy;
		this.diaChi = diaChi;
		this.thanhPho = thanhPho;
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
	 * @return the tenKH
	 */
	public String getTenKH() {
		return tenKH;
	}

	/**
	 * @param tenKH
	 *            the tenKH to set
	 */
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the tenCongTy
	 */
	public String getTenCongTy() {
		return tenCongTy;
	}

	/**
	 * @param tenCongTy
	 *            the tenCongTy to set
	 */
	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
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
	 * @return the thanhPho
	 */
	public String getThanhPho() {
		return thanhPho;
	}

	/**
	 * @param thanhPho
	 *            the thanhPho to set
	 */
	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

}
