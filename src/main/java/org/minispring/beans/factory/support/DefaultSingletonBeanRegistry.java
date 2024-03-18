package org.minispring.beans.factory.support;

import org.minispring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 管理单例对象的注册和获取
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
//存储单例对象：通过private Map<String, Object> singletonObjects成员变量来存储单例对象
// 其中键是Bean的名称，值是Bean对象本身。
	private Map<String, Object> singletonObjects = new HashMap<>();
//获取单例对象：getSingleton(String beanName)方法用于根据Bean的名称获取对应的单例对象。如果存在该名称的单例对象，则返回它；否则返回null。
	@Override
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}
//注册单例对象：addSingleton(String beanName, Object singletonObject)方法允许将指定名称的单例对象注册到注册表中。如果该名称的单例对象已存在，则会被新对象替换。
	protected void addSingleton(String beanName, Object singletonObject) {
		singletonObjects.put(beanName, singletonObject);
	}
}
