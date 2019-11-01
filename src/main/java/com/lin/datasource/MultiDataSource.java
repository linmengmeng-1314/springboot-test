package com.lin.datasource;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.lin.common.baseenum.DataSourceEnum;

public class MultiDataSource extends AbstractRoutingDataSource {

    private final static ThreadLocal<String> DATA_SOURCE_KEY = new ThreadLocal<>(); //保存当前线程的数据源对应的key

    /**
     * 所有数据源的key集合
     */
    private Set<Object> keySet;

    public static void switchSource(DataSourceEnum key) {
        DATA_SOURCE_KEY.set(key.getValue()); 
    }

    public static void clear() {
        DATA_SOURCE_KEY.remove(); 
    }
    
    @Override
    protected Object determineCurrentLookupKey() {
        String key = DATA_SOURCE_KEY.get();
        return key;
    }

    /**
     * 在获取key的集合，目的只是为了添加一些告警日志
     */
    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        try {
            Field sourceMapField = AbstractRoutingDataSource.class.getDeclaredField("resolvedDataSources");
            sourceMapField.setAccessible(true);
            Map<Object, javax.sql.DataSource> sourceMap = (Map<Object, javax.sql.DataSource>) sourceMapField.get(this);
            this.keySet = sourceMap.keySet();
            sourceMapField.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}