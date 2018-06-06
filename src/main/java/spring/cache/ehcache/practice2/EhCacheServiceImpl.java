/**
 * newpanderking 
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.cache.ehcache.practice2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author newpanderking
 * @version EhCacheServiceImpl.java, 2018年06月05日 上午11:25 
 */
@Service
public class EhCacheServiceImpl implements EhCacheService {

    @Cacheable(value = "helloworld", key = "#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
}