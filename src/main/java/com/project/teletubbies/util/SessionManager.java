package com.project.teletubbies.util;

//import com.amaranth10.backendcommon.util.model.SessionInfo;
import org.springframework.stereotype.Component;

/**
 * 세션관련 매니저 입니다. SessionInfo 객체를 사용합니다.
 * 
 * @author
 *
 */
@Component
public class SessionManager {

	/*@Autowired
	RedisManager redisManager;*/

	/**
	 * default constructor
	 */
	public SessionManager() {
	}

	/**
	 * 인증된 사용자의 정보를 Redis에서 반환한다.
	 * 
	 * @param token_key
	 * @return SessionInfo
	 * @throws Exception
	 */
	/*public SessionInfo getSessionInfo(String token_key) throws Exception {
		return RedisManager.getJedisInfoClient().getAuthUserInfo(token_key);
	}*/
	
	/**
	 * 테스트용 사용자 세션 설정 메소드
	 * @param token
	 * @param sessionInfo
	 * @return
	 * @throws Exception 
	 */
//	public Map<String, Object> setSessionInfo(String token, SessionInfo sessionInfo) throws Exception {
//		return RedisManager.getJedisInfoClient().setSessionInfo(token, sessionInfo);
//	}
}
