package com.scyb.aisbroadcast.common.util;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class ExeSqlHibernateCallback implements HibernateCallback {
	private String sql;

	public ExeSqlHibernateCallback(String sql) {
		this.sql = sql;
	}

	public Object doInHibernate(Session session) {
		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.executeUpdate();
			return new Boolean(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Boolean(false);
	}
}
