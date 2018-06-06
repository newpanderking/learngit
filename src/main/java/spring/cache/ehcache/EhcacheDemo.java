/**
 * newpanderking 
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.cache.ehcache.practice2.EhCacheService;

/**
 *
 * @author newpanderking
 * @version EhcacheDemo.java, 2018年06月04日 下午5:22 
 */
public class EhcacheDemo {

    /**
     * logger
     */
    Logger logger = LoggerFactory.getLogger(EhcacheDemo.class);

    @Test
    public void xmlConfiguration() {

        // Create a cache manager
        final CacheManager cacheManager = new CacheManager();

        // create the cache called "helloworld"
        final Cache cache = cacheManager.getCache("helloworld");

        // create a key to map the data to
        final String key = "greeting";

        // Create a data element
        final Element putGreeting = new Element(key, "Hello, World!");

        // Put the element into the data store
        cache.put(putGreeting);

        // Retrieve the data element
        final Element getGreeting = cache.get(key);

        logger.info(getGreeting.toString());
    }

    @Test
    public void practice2Test() throws Exception{

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.ehcache.xml");
        EhCacheService ehCacheService = (EhCacheService) ctx.getBean("ehcacheService");

        System.out.println("第一次调用：" + ehCacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheService.getTimestamp("param"));
    }

}