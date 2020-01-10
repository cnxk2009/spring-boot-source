package com.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  <p>
 *  测试类入口
 *  </p>
 * @version v1.0.0
 * @date 2019年10月22日 下午5:39:48
 */
@RestController
@SpringBootApplication
public class RedisApplication extends SpringBootServletInitializer {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/redis")
    public String testRedis(){
        redisTemplate.opsForValue().set("cnxk","123");
        return "success";
    }

    //如果此处没有配置的话就使用RedisAutoConfiguration的redisTemplate bean  通过@ConditionalOnMissingBean注解实现
    @Bean
    public RedisTemplate<Object,Object>redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }


    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(RedisApplication.class);
    }
    
}