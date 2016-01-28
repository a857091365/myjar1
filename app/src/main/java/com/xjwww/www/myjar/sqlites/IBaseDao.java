package com.xjwww.www.myjar.sqlites;

import java.util.List;

public interface IBaseDao<T> {
	/**
	 * 根据条件返回所有的接口
	 * @param key
	 * @param value
	 * @return
	 */
	List<T> GetList(String key, String value);

	/**
	 * 根据条件返回单个的数据
	 * @param Key
	 * @param value
	 * @return
	 */
	T GetModel(String Key, String value);

	/**
	 * 查询所有数据
	 * @return
	 */
	List<T> GetAll();

	/**
	 * 根据条件删除数据
	 * @param key
	 * @param value
	 */
	void Delete(String key, String value);

	/**
	 * 删除所有数据
	 */
	void Delete();
	/**
	 * 修改
	 * @param t
	 */
	int Update(T t);
	/**
	 * 新增
	 * @param t
	 */
	void Add(T t);

}
