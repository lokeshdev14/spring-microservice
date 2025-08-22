package com.lokesh.exchange.configuration;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;

import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class ExchangeConfiguration {
@Bean
 public CacheManager cacheManager(RedisConnectionFactory connectionFactory)
 {
	RedisCacheConfiguration configuration=RedisCacheConfiguration.defaultCacheConfig()
			                                                     .entryTtl(Duration.ofMinutes(1))
			                                                     .disableCachingNullValues();
	
	return RedisCacheManager.builder(connectionFactory)
			                .cacheDefaults(configuration)
			                .build();
 }
	
}
