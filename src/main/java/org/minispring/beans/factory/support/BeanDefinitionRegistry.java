package org.minispring.beans.factory.support;

import org.minispring.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @author derekyi
 * @date 2020/11/22
 */
public interface BeanDefinitionRegistry {

	/**
	 * 向注册表中注BeanDefinition
	 *
	 * @param beanName
	 * @param beanDefinition
	 */
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
