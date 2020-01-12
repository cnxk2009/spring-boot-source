package com.springboot.compent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * 演示后置处理Bean
 * 在Bean对象在实例化和依赖注入完毕后，在显示调用初始化方法的前后添加我们自己的逻辑。
 * 注意是Bean实例化完毕后及依赖注入完成后触发的
 * @Author cnxk
 * @Date 2020/1/11
 * @Version V1.0.0
 **/
@Component
public class T8RedisBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof RedisTemplate){
            RedisTemplate redisTemplate = (RedisTemplate)bean;
            redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
            return redisTemplate;
        }

        return bean;
    }

}