package org.minispring.beans.factory;

import org.minispring.beans.BeansException;

/**
 * bean容器
 *

 */
public interface BeanFactory {

	/**
	 * 获取bean
	 *
	 * @param name
	 * @return
	 * @throws BeansException bean不存在时
	 */
	Object getBean(String name) throws BeansException;
}
