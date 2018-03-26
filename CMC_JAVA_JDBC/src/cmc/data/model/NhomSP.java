/**
 * 
 */
package cmc.data.model;

/**
 * @description:
 * @author: Admin
 * @time: 9:00:06 PM
 * @date: Mar 26, 2018
 */
public class NhomSP {
	private int maNSP;
	private String tenNSP;

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 26, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 26, 2018
	 * @exception:
	 * @param maNSP
	 * @param tenNSP
	 */
	public NhomSP(int maNSP, String tenNSP) {
		super();
		this.maNSP = maNSP;
		this.tenNSP = tenNSP;
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
	 * @return the tenNSP
	 */
	public String getTenNSP() {
		return tenNSP;
	}

	/**
	 * @param tenNSP
	 *            the tenNSP to set
	 */
	public void setTenNSP(String tenNSP) {
		this.tenNSP = tenNSP;
	}

}
