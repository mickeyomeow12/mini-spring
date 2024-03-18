package org.minispring.beans.factory.support;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 Bean工厂的具体实现，用于存储和管理Bean定义（BeanDefinition）以及创建Bean实例
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
//Bean定义的注册
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}
//获取Bean定义
	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		//根据Bean名称从beanDefinitionMap中获取对应的BeanDefinition
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null) {
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}

		return beanDefinition;
	}
}
