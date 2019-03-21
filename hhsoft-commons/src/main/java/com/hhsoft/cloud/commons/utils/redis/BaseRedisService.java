package com.hhsoft.cloud.commons.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BaseRedisService
 * @Description redis服务封装类
 * @Author Jason Biao
 * @Date 2018\11\30 0030 15:42
 * @Version 1.0
 **/
@Component
public class BaseRedisService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 插入数据到redis
	 * 
	 * @param key
	 * @param data
	 */
	public void setString(String key, String data) {
		set(key, data, null);
	}

	public void setString(String key, String data, Long timeout) {
		set(key, data, timeout);
	}

	public void set(String key, Object data, Long timeout) {
		if (data != null) {
			if (data instanceof String) {
				String setData = (String) data;
				stringRedisTemplate.opsForValue().set(key, setData);
			}
			// 设置有效期
			if (timeout != null) {
				stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
			}
		}
	}

	/**
	 * 根据key获取redis数据库的value值
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 根据hashkey获取redis数据库的value值
	 * 
	 * @param key
	 * @return
	 */
	public Set<Object> getHashAll(String key) {
		return stringRedisTemplate.opsForHash().keys(key);
	}

	/**
	 * 通过key 获取所有的field +value
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> hgetall(final String key) {
		return (Map<String, String>) stringRedisTemplate.execute(new RedisCallback() {

			public Map<String, String> doInRedis(RedisConnection connection) throws DataAccessException {
				Map<byte[], byte[]> values = connection.hGetAll(key.getBytes());
				if (CollectionUtils.isEmpty(values)) {
					return new HashMap<String, String>();
				} else {
					// 将Map<byte[],byte[]>转换为Map<String,String>
					Map<String, String> allValueMap = new HashMap<String, String>(values.size());
					Iterator itor = values.keySet().iterator();
					while (itor.hasNext()) {
						byte[] mapKey = (byte[]) itor.next();
						allValueMap.put(new String(mapKey), new String(values.get(mapKey)));
					}
					return allValueMap;
				}
			}
		});
	}

	/**
	 * 根据key删除redis数据库的value值
	 * 
	 * @param key
	 */
	public void delete(String key) {
		stringRedisTemplate.delete(key);
	}

}
