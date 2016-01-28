package com.xjwww.www.myjar.sqlites;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

public class BaseDao<T> implements IBaseDao<T>{
	public Dao<T, Integer> baseDao;
	public Class<T> classz;
 	@SuppressWarnings("unchecked")
	public BaseDao()
	{
 	      Type type = getClass().getGenericSuperclass();
 		  Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
 		  this.classz = (Class<T>) trueType;
		try {
			baseDao = DatabaseHelper.getHelper().getDao(classz);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public List<T> GetList(String key, String value) {
		// TODO 自动生成的方法存根
		try {
			return baseDao.queryBuilder().where().eq(key, value).query();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}


    public List<T> GetList(String key1, String value1,String key2,int value2) {
        // TODO 自动生成的方法存根
        try {
            return baseDao.queryBuilder().where().eq(key1, value1).and().eq(key2,value2).query();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public T GetModel(String Key, String value) {
		// TODO 自动生成的方法存根
		try {
			return baseDao.queryBuilder().where().eq(Key, value).queryForFirst();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> GetAll() {
		// TODO 自动生成的方法存根
		try {
		  return baseDao.queryForAll();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void Delete(String key, String value) {
		// TODO 自动生成的方法存根
        try {
        	DeleteBuilder<T, Integer> deleteBuilder = baseDao.deleteBuilder();
			deleteBuilder.where().eq(key, value);
			deleteBuilder.delete();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	@Override
	public void Delete() {
		// TODO 自动生成的方法存根
		try {
			baseDao.deleteBuilder().delete();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public int Update(T t) {
		// TODO 自动生成的方法存根
		try {
			return baseDao.update(t);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return -1;
	}

	@Override
	public void Add(T t) {
		// TODO 自动生成的方法存根
		try {
			baseDao.create(t);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}


