package com.xjwww.www.myjar.sqlites;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;





import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.xjwww.www.myjar.config.Config;
import com.xjwww.www.myjar.config.Mlog;
import com.xjwww.www.myjar.volley.RequestModel.ApiMaprecordModel;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
	//private  String TABLE_NAME = ;

	private Map<String, Dao> daos = new HashMap<String, Dao>();

	private DatabaseHelper()
	{
		super(Config.context, "xjwww.db", null, 1);
	}

	/**
	 * 第一次创建数据库对象的时候执行该语句
	 */
	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource)
	{
        Mlog.e("数据库onCreate");
        try {

            TableUtils.createTableIfNotExists(connectionSource,ApiMaprecordModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



	/**
     * 升级数据库的时候操作
     */
	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion)
	{

        Mlog.e("数据库onUpgrade");

        onCreate(database, connectionSource);

    }

	private static DatabaseHelper instance;

	/**
	 * 单例获取该Helper
	 *
	 * @return
	 */
	public static synchronized DatabaseHelper getHelper()
	{
		if (instance == null)
		{
			synchronized (DatabaseHelper.class)
			{
				if (instance == null)
					instance = new DatabaseHelper();
			}
		}

		return instance;
	}

	@Override
	public synchronized Dao getDao(Class clazz) throws SQLException
	{
		Dao dao = null;
		String className = clazz.getSimpleName();

		if (daos.containsKey(className))
		{
			dao = daos.get(className);
		}
		if (dao == null)
		{
			dao = super.getDao(clazz);
			daos.put(className, dao);
		}
		return dao;
	}

	/**
	 * 释放资源
	 */
	@Override
	public void close()
	{
		super.close();

		for (String key : daos.keySet())
		{
			Dao dao = daos.get(key);
			dao = null;
		}
	}
}
