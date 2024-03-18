package org.minispring.test.ioc;

import org.junit.Test;
import org.minispring.beans.factory.config.BeanDefinition;
import org.minispring.beans.factory.support.DefaultListableBeanFactory;

/**

 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

	@Test
	public void testBeanFactory() throws Exception {
		//创建工厂实例
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//创建bean实例
		BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
		//通过这个名称获取对应的Bean实例
		beanFactory.registerBeanDefinition("helloService", beanDefinition);

		//通过beanFactory的getBean方法获取名称为helloService的Bean实例。
		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		helloService.sayHello();
	}
}
