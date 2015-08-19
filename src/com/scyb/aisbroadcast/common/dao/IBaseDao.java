package com.scyb.aisbroadcast.common.dao;

import java.util.List;

/**
 * ��������ݿ⽻���Ľӿ�
 * 
 * @author dell
 * 
 */
public interface IBaseDao {
	/**
	 * ����һ������(�޸Ļ�����)
	 * 
	 * @param obj
	 * @return
	 */
	public Object save(Object obj);

	/**
	 * ����һ�����϶���(�޸Ļ�����)
	 * 
	 * @param list
	 * @return
	 */
	public List saveList(List list);

	/**
	 * ɾ�����
	 * 
	 * @param obj
	 */
	public void del(Object obj);

	/**
	 * ����һ�����϶���
	 * 
	 * @param list
	 */
	public void delList(List list);

	/**
	 * �������
	 * 
	 * @param cla
	 * @param guid
	 * @return
	 */
	public Object getObjectById(Class cla, String guid);

	/**
	 * ͨ��HQL����ȡLISTԪ��
	 * 
	 * @param hql
	 * @return
	 */
	public List queryList(String hql);

	/**
	 * ͨ���ѯhql����ȡ��¼��
	 * 
	 * @param hql
	 * @return
	 */
	public long getTotalCount(String hql);

	/**
	 * ͨ���ѯhql���
	 * 
	 * @param hql
	 *            ��ѯhql
	 * @param firstResult
	 *            ��ʼ�����
	 * @param maxResult
	 *            ҳ��¼��
	 * @return
	 */
	public List queryByPage(String hql, int firstResult, int maxResult);

	/**
	 * 
	 * @param hql
	 * @return
	 */
	public boolean exeHql(String hql);

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public boolean exeSql(String sql);
}
