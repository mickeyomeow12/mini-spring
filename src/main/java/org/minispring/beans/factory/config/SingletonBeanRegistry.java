package org.minispring.beans.factory.config;

/**
 * 单例注册表
 *
 * @author derekyi
 * @date 2020/11/22
 */
public interface SingletonBeanRegistry {

	Object getSingleton(String beanName);
}
