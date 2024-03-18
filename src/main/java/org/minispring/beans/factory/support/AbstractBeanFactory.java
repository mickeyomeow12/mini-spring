package org.minispring.beans.factory.support;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.BeanFactory;
import org.minispring.beans.factory.config.BeanDefinition;

/**
 * @author derekyi
 * @date 2020/11/22
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

	@Override
	public Object getBean(String name) throws BeansException {
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}

		BeanDefinition beanDefinition = getBeanDefinition(name);
		return createBean(name, beanDefinition);
	}

	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
