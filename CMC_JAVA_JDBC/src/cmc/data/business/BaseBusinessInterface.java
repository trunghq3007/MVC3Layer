/**
 * 
 */
package cmc.data.business;

import java.util.List;

/**
 * @description:
 * @author: Admin
 * @time: 2:49:54 PM
 * @date: Mar 28, 2018
 */
public interface BaseBusinessInterface<T> {

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @param obj
	 * @return
	 */
	public boolean insert(T obj);
	

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @param sql
	 * @return
	 */
	public List<T> getList(String sql);

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @param obj
	 * @return
	 */
	public boolean delete(T obj);

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @param student
	 * @return
	 */
	public boolean update(T obj);

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @param sql
	 * @return
	 */
	public T getFirst();

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @return
	 */
	public T getLast();

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @return
	 */
	public T getCurrent();

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @return
	 */
	public T getNext();

	/**
	 * @description:
	 * @author: Admin CMC Corporation
	 * @create_date: Mar 28, 2018
	 * @modifier: Admin
	 * @modifined_date: Mar 28, 2018
	 * @exception:
	 * @return
	 */
	public T getPrevious();

}
