package com.springboot.compent;

import org.springframework.beans.factory.InitializingBean;

/**
 * 演示后置处理Bean
 * @Author cnxk
 * @Date 2020/1/11
 * @Version V1.0.0
 **/
public class T8Compent implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-----T8Compent-------afterPropertiesSet--------");
    }

    public T8Compent(){
        System.out.println("====T8Compent()====");
    }

    public void init(){
        System.out.println("====T8Compent=====init====");
    }
}
