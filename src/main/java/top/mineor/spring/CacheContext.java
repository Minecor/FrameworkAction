package top.mineor.spring;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by mineor on 2016/12/27.
 */
@Repository
public class CacheContext<T> {
    private Map<String, T> cache = Maps.newConcurrentMap();

    public T get(String key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    public void evictCache(String key) {
        if (cache.containsKey(key))
            cache.remove(key);
    }

    public void evictCache() {
        cache.clear();
    }
}
