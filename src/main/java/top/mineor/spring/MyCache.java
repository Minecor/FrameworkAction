package top.mineor.spring;

/**
 * Created by mineor on 2016/12/27.
 */

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import top.mineor.spring.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyCache implements Cache {
    private String name;
    private Map<String,Account> store = new HashMap<String,Account>();;

    public MyCache() {
    }

    public MyCache(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNativeCache() {
        return store;
    }

    public ValueWrapper get(Object key) {
        ValueWrapper result = null;
        Account thevalue = store.get(key);
        if(thevalue!=null) {
            thevalue.setPassword("from mycache:"+name);
            result = new SimpleValueWrapper(thevalue);
        }
        return result;
    }

    public void put(Object key, Object value) {
        Account thevalue = (Account)value;
        store.put((String)key, thevalue);
    }

    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    public void evict(Object key) {
    }

    public Map<String, Account> getStore() {
        return store;
    }

    public void setStore(Map<String, Account> store) {
        this.store = store;
    }

    public void clear() {
    }
}