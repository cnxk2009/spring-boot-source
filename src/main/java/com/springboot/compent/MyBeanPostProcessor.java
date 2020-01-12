package com.springboot.compent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 演示后置处理Bean
 * @Author cnxk
 * @Date 2020/1/11
 * @Version V1.0.0
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof T8Compent) {
            System.out.println("====我是T8Compent的后置处理方法调用==postProcessBeforeInitialization====");
        }
        return bean;
    }
}
