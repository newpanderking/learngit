package groovy.practice1;

import groovy.lang.GroovyObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;

/**
 *
 * @version $Id: GroovyDemoOne.java, v 0.1 2018年06月01日 下午4:39 jason.wzr Exp $
 */

public class GroovyDemoOne {

    Logger logger = LoggerFactory.getLogger(GroovyShell.class);

    @Test
    public void GroovyTestOne() {
        Binding binding = new Binding();
        binding.setVariable("name", "jason");
        binding.setVariable("address", "杭州西湖留下");

        GroovyShell groovyShell = new GroovyShell(binding);
        Object result = groovyShell
            .evaluate("println\"My name is $name, my home is at $address \"; return 33+22 ");

        logger.info(result.toString());

    }

    // target/classes/groovy/VeryEasyDemo.groovy
    @Test
    public void groovyTestTwo() throws Exception {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String groovyPath = ResourceUtils.CLASSPATH_URL_PREFIX + "groovy/";
        Resource[] resources = resolver.getResources(groovyPath + "*.groovy");
        if (resources == null || resources.length == 0){
            logger.info("未找到groovy文件！");
            return;
        }
        Resource resource = resources[0];
        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine("",this.getClass().getClassLoader());

        Class clazz = groovyScriptEngine.loadScriptByName(((FileSystemResource)resource).getPath());
        GroovyObject groovyObject = (GroovyObject)clazz.newInstance();
        Object result = groovyObject.invokeMethod("logInvoke",new Object[]{"jason"});


        logger.info(result.toString());

    }

}