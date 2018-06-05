/**
 * newpanderking 
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package spring.cache.ehcache.practice1;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author newpanderking
 * @version CachingConfig.java, 2018年06月04日 下午5:43 
 */
@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {

        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(
            ResourceUtils.CLASSPATH_URL_PREFIX + "ehcache.xml"));
        return ehCacheManagerFactoryBean;

    }
}