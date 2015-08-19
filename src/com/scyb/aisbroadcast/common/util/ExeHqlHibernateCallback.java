package com.scyb.aisbroadcast.common.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class ExeHqlHibernateCallback implements HibernateCallback {
	private String hql;

	public ExeHqlHibernateCallback(String hql) {
		this.hql = hql;
	}

	public Object doInHibernate(Session session) {
		try {
			Query query = session.createQuery(hql);
			query.executeUpdate();
			return new Boolean(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Boolean(false);
	}
}
