package com.springboot.config;

import com.springboot.compent.MyBeanPostProcessor;
import com.springboot.compent.T8Compent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * 演示后置处理Bean
 * @Author cnxk
 * @Date 2020/1/11
 * @Version V1.0.0
 **/
@Configuration
public class T8Config {

    /*@Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }*/

    @Bean(initMethod = "init")
    public T8Compent t8Compent() {
        return new T8Compent();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }


}
