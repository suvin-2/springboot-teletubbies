/*
package com.project.teletubbies.util;

import com.amaranth10.backendcommon.util.redis.JedisInfoClient;
import org.springframework.stereotype.Component;

import java.util.Map;

*/
/**
 * 메모리 DB(redis) 관련 Manager입니다. 공통 JAR파일의 JedisInfoClient를 사용하여 레디스클라이언트를 가져옵니다.
 *
 * @author
 *
 *//*

@Component
public class RedisManager {
	private static JedisInfoClient jedisInfoClient;

	*/
/**
	 * default constructor
	 *//*

	public RedisManager() {
	};

	*/
/**
	 *
	 * @param ip
	 * @param port
	 * @param password
	 * @param sentinalHosts
	 * @param masterName
	 *//*

	public RedisManager(String ip, int port, String password, String sentinalHosts, String masterName) throws Exception {
		jedisInfoClient = JedisInfoClient.getInstance(ip, port, password,sentinalHosts,masterName);
	}

	*/
/**
	 * 레디스 클라이언트 반환
	 *
	 * @return
	 *//*

	public static JedisInfoClient getJedisInfoClient() {
		return jedisInfoClient;
	}

	public static Map<String, String> getCustInfoByGroupSeq(String groupSeq){
		return jedisInfoClient.getCustInfo(groupSeq);
	}


	public RedisManager(String host, String port, String password, String sentinelHosts, String sentinelMasterName) throws Exception {
		int portNum = Integer.parseInt(port);
		jedisInfoClient = JedisInfoClient.getInstance(host, portNum, password, sentinelHosts, sentinelMasterName);
	}

	public void delSessionInfo(String token) throws Exception {
		jedisInfoClient.clearToken(token);
	}

	public boolean healthCheck() {
		return jedisInfoClient.redisHealthCheck();
	}

}
*/
