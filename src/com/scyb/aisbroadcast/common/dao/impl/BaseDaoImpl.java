package com.scyb.aisbroadcast.common.dao.impl;

import com.scyb.aisbroadcast.common.dao.IBaseDao;
import com.scyb.aisbroadcast.common.util.ExeHqlHibernateCallback;
import com.scyb.aisbroadcast.common.util.ExeSqlHibernateCallback;
import com.scyb.aisbroadcast.common.util.PageHibernateCallback;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;


public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {

	private Logger log = Logger.getLogger(this.getClass());

	public void del(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}

	public void delList(List list) {
		this.getHibernateTemplate().deleteAll(list);
	}

	public boolean exeHql(String hql) {
		return ((Boolean) this.getHibernateTemplate().execute(
				new ExeHqlHibernateCallback(hql))).booleanValue();
	}

	public boolean exeSql(String sql) {
		return ((Boolean) this.getHibernateTemplate().execute(
				new ExeSqlHibernateCallback(sql))).booleanValue();
	}

	public Object getObjectById(Class cla, String guid) {
		List list = this.getHibernateTemplate().find(
				"from " + cla.getName() + " a where a.guid='" + guid + "'");
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	public Object getObjectByCustomId(Class cla, String customId, String guid) {
		List list = this.getHibernateTemplate().find(
				"from " + cla.getName() + " a where a." + customId + " = '"
						+ guid + "'");
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	public long getTotalCount(String hql) {
		Long amount = new Long(0);
		int sql_from = hql.indexOf("from");
		int sql_orderby = hql.indexOf("order by");
		String countStr = "";
		if (sql_orderby > 0) {
			countStr = "select count(*) "
					+ hql.substring(sql_from, sql_orderby);
		} else {
			countStr = "select count(*) " + hql.substring(sql_from);
		}
		List query = this.getHibernateTemplate().find(countStr);
		if (!query.isEmpty()) {
			amount = (Long) query.get(0);
			return amount.longValue();
		} else {
			return 0;
		}
	}

	public List queryByPage(String hql, int firstResult, int maxResult) {

		List pageList = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback(hql, firstResult, maxResult));

		return pageList;
	}

	public List queryList(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	public Object saveOrUpdate(Object obj) {
		try {
			this.getHibernateTemplate().saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Object save(Object obj) {
		try {
			this.getHibernateTemplate().save(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List saveList(List list) {
		this.getHibernateTemplate().saveOrUpdateAll(list);
		return list;
	}

}
