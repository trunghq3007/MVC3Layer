/**
 * 
 */
package cmc.data.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Admin
 * @time: 9:15:15 PM
 * @date: Mar 26, 2018
 */
public class BaseDao<T> {

	List<T> listObj;

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 26, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 26, 2018
	 * @exception:
	 * @param listObj
	 */
	public BaseDao(List<T> listObj) {
		super();
		listObj = new ArrayList<T>();
		this.listObj = listObj;
	}

	/*private List<T> getList(String sql) {
	}*/

}
