package com.project.teletubbies.util;

import com.project.teletubbies.model.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageManager {

	@Autowired
	MessageSource messageSource;
	
	/**
	 * 다국어 처리용 메소드입니다.
	 */
	public String getMessage(String code, Locale locale) {
		return messageSource.getMessage(code, null, locale);
	}
	
	public String getMessage(String code, String defaultStr) {
		
		return getMessage(code, Locale.KOREA, defaultStr); 
	}
	
	public String getMessage(String code, String defaultStr, String langCode) {
		
		Locale locale = Locale.KOREA;
		if(langCode != null) {
			switch (langCode) {
			case "kr":
				locale = Locale.KOREA;
				break;
			case "en":
				locale = Locale.US;
				break;
			case "jp":
				locale = Locale.JAPAN;
				break;
			case "cn":
				locale = Locale.CHINA;
				break;
			default:
				locale = Locale.KOREA;
				break;
			}
		}		
		
		return getMessage(code, locale, defaultStr); 
	}		
	
	public String getMessage(String code, Locale locale, String defaultStr) {
		
		String resultStr = (defaultStr) != null ? defaultStr : "";
		
		try {
			resultStr = messageSource.getMessage(code, null, locale);
		} catch (Exception e) {
			
		}
		
		return resultStr; 
	}
	
	/**
	 * 다국어 처리용 메소드입니다.
	 */
	public String getMessage(String code, Object[] args, Locale locale) {
		return messageSource.getMessage(code, args, null, locale);
	}
	
	/**
	 * 다국어를 처리하기 위하여 사용자의 landCode에 따른 locale을 구하는 메소드입니다.
	 * @param sessionInfo
	 * @return
	 */
	public static Locale checkLocale(SessionInfo sessionInfo) {
		Locale locale = Locale.KOREA;

		// 나중에 다국어 작업 시 getTbUserInfo getLangCode 추가
		/*if(sessionInfo != null) {
			switch (sessionInfo.getTbUserInfo().getLangCode()) {
			case "kr":
				locale = Locale.KOREA;
				break;
			case "en":
				locale = Locale.US;
				break;
			case "jp":
				locale = Locale.JAPAN;
				break;
			case "cn":
				locale = Locale.CHINA;
				break;
			default:
				locale = Locale.KOREA;
				break;
			}
		}*/

		return locale;
	}
}
