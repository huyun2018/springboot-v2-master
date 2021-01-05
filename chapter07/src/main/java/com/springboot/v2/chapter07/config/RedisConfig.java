package com.springboot.v2.chapter07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**** imports ****/
//@Configuration
public class RedisConfig {

	private RedisConnectionFactory connectionFactory = null;

	@Bean(name = "redisConnectionFactory")
	public RedisConnectionFactory initConnectionFactory() {
		if (this.connectionFactory != null) {
			return this.connectionFactory;
		}
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// 最大空闲数
		poolConfig.setMaxIdle(50);
		// 最大连接数
		poolConfig.setMaxTotal(100);
		// 最大等待毫秒数
		poolConfig.setMaxWaitMillis(2000);
		// 创建Jedis连接工厂
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
		// 配置Redis连接服务器
		RedisStandaloneConfiguration rsc = connectionFactory.getStandaloneConfiguration();
		rsc.setHostName("127.0.0.1");
		rsc.setPort(6379);
//		rsc.setPassword(RedisPassword.of("123456"));
		this.connectionFactory = connectionFactory;
		return connectionFactory;
	}
	
	@Bean(name="redisTemplate")
	public RedisTemplate<Object, Object> initRedisTemplate() {
	    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
	    redisTemplate.setConnectionFactory(initConnectionFactory());
	    //RedisTemplate会自动初始化StringRedisSerializer，所以这里直接获取
	    RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();
	    //设置字符串序列化器，这样Spring就会把Redis的key字符串处理了
	    redisTemplate.setKeySerializer(stringRedisSerializer);
	    redisTemplate.setHashKeySerializer(stringRedisSerializer);
	    redisTemplate.setHashValueSerializer(stringRedisSerializer);
	  return redisTemplate;
	}
}