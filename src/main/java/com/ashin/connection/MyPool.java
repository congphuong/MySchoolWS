package com.ashin.connection;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.GenericObjectPoolFactory;

/**
 * Created by congphuong on 6/23/17.
 */
public class MyPool {
    public static ObjectPool pool = initMySqlConnectionPool();
    public static ObjectPool initMySqlConnectionPool() {
        PoolableObjectFactory mySqlPoolableObjectFactory = new ConnectionPool("localhost",
                3306, "myschool1", "root", "");
        GenericObjectPool.Config config = new GenericObjectPool.Config();
        config.maxActive = 10;
        config.testOnBorrow = true;
        config.testWhileIdle = true;
        config.timeBetweenEvictionRunsMillis = 10000;
        config.minEvictableIdleTimeMillis = 60000;

        GenericObjectPoolFactory genericObjectPoolFactory = new GenericObjectPoolFactory(mySqlPoolableObjectFactory, config);
        ObjectPool pool = genericObjectPoolFactory.createPool();
        return pool;
    }
    public static ObjectPool getInstance() {
        if(pool==null){
            pool = initMySqlConnectionPool();
        }
        return pool;
    }
}
