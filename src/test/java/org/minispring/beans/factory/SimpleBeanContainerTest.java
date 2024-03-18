package org.minispring.beans.factory;

import junit.framework.TestCase;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SimpleBeanContainerTest extends TestCase {
    @Test
    public void testGetBean() throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertThat(helloService).isNotNull();
        assertThat(helloService.sayHello()).isEqualTo("hello");
    }

    class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}