package org.minispring.beans.factory.support;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.BeanFactory;
import org.minispring.beans.factory.config.BeanDefinition;

/**
 用于提供获取Bean的功能
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
//获取Bean：getBean(String name)方法是Bean获取的入口点。它首先尝试从单例注册表中获取Bean，如果能够获取到，则直接返回该单例对象。
	@Override
	public Object getBean(String name) throws BeansException {
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}
//获取Bean的定义信息
		BeanDefinition beanDefinition = getBeanDefinition(name);
		//创建Bean实例
		return createBean(name, beanDefinition);
	}

	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
