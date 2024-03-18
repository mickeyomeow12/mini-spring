package org.minispring.beans.factory.support;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.BeanDefinition;

/**
 提供了自动装配（autowire）
 使Spring能够自动地实例化Bean并管理其生命周期。
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
//创建Bean实例
	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
		return doCreateBean(beanName, beanDefinition);
	}
//Bean实例化
	protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
		//根据BeanDefinition获取Bean的类类型
		Class beanClass = beanDefinition.getBeanClass();
		Object bean = null;
		try {
			//使用newInstance方法创建Bean的实例
			bean = beanClass.newInstance();
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}
//添加到单例注册表
		addSingleton(beanName, bean);
		return bean;
	}
}
