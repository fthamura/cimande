package org.blueoxygen.cimande.gx.droplistname.action;

import java.sql.SQLException;

import org.blueoxygen.cimande.persistence.hibernate.HibernateSessionFactory;
import org.blueoxygen.cimande.persistence.hibernate.HibernateSessionFactoryAware;
import org.blueoxygen.cimande.gx.entity.DroplistName;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

/**
 * @author anja
 *
 */
public class SearchDroplistName extends DroplistNameForm implements HibernateSessionFactoryAware {
	private HibernateSessionFactory hsf;
	private Session sess;
	
	private int maxPage, currPage, nextPage, prevPage = 0, page = 0;
	private int maxRowPerPage = 10;
	private String orderBy = "logInformation.createDate";
	private int resultRows;
	
	public String execute() {
		sess = hsf.createSession();
		Criteria crit = sess.createCriteria(DroplistName.class);
		if(droplistname.getName() != null && !"".equalsIgnoreCase(droplistname.getName())) {
			crit.add(Expression.like("name","%"+droplistname.getName()+"%"));
		}
		if(droplistname.getDescription() != null && !"".equalsIgnoreCase(droplistname.getDescription())) {
			crit.add(Expression.like("description","%"+droplistname.getDescription()+"%"));	
		}
		if(getParentId() != null && !"".equalsIgnoreCase(getParentId())){
			crit.add(Expression.like("parent.id", "%"+getParentId()+"%"));
		}			
		resultRows = crit.list().size();
		maxPage = resultRows / maxRowPerPage;
		prevPage = currPage - 1;
		nextPage = currPage + 1;
		if(resultRows % maxRowPerPage == 0) maxPage = maxPage - 1;
		droplistnames = crit.addOrder(Order.asc(orderBy))
				.setFirstResult(currPage*maxRowPerPage)
				.setMaxResults(maxRowPerPage)
				.list();
		try {
			hsf.endSession(sess);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public void setHibernateSessionFactory(HibernateSessionFactory hsf) {
		this.hsf = hsf;
	}
	/**
	 * @return Returns the currPage.
	 */
	public int getCurrPage() {
		return currPage;
	}
	/**
	 * @param currPage The currPage to set.
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	/**
	 * @return Returns the maxPage.
	 */
	public int getMaxPage() {
		return maxPage;
	}
	/**
	 * @param maxPage The maxPage to set.
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	/**
	 * @return Returns the maxRowPerPage.
	 */
	public int getMaxRowPerPage() {
		return maxRowPerPage;
	}
	/**
	 * @param maxRowPerPage The maxRowPerPage to set.
	 */
	public void setMaxRowPerPage(int maxRowPerPage) {
		this.maxRowPerPage = maxRowPerPage;
	}
	/**
	 * @return Returns the nextPage.
	 */
	public int getNextPage() {
		return nextPage;
	}
	/**
	 * @param nextPage The nextPage to set.
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	/**
	 * @return Returns the orderBy.
	 */
	public String getOrderBy() {
		return orderBy;
	}
	/**
	 * @param orderBy The orderBy to set.
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * @return Returns the page.
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page The page to set.
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * @return Returns the prevPage.
	 */
	public int getPrevPage() {
		return prevPage;
	}
	/**
	 * @param prevPage The prevPage to set.
	 */
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	/**
	 * @return Returns the resultRows.
	 */
	public int getResultRows() {
		return resultRows;
	}
	/**
	 * @param resultRows The resultRows to set.
	 */
	public void setResultRows(int resultRows) {
		this.resultRows = resultRows;
	}
	
	
}