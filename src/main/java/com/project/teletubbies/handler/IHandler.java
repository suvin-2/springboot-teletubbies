package com.project.teletubbies.handler;

import com.project.teletubbies.model.RequestModel;

import java.util.Locale;


/**
 * 핸들러 객체의 인터페이스입니다.
 *
 * @author douzone
 *
 */
public interface IHandler {

	/**
	 * 서비스명을 반환하는 메소드입니다.
	 * @return
	 */
	public String getAPICode();
	/**
	 * 실제 비즈니스 로직을 구현하는 메소드입니다.
//	 * @param requestInfo
	 * @param requestModel
	 * @return
	 */
	public Object handle(RequestModel requestModel, String ApiCode, Locale locale) throws Exception;
	/**
	 * 다국어 처리용 메소드입니다.
	 */
	public String getMessage(String code, Locale locale) ;
	/**
	 * 다국어 처리용 메소드입니다.
	 */
	public String getMessage(String code, Object[] args, Locale locale) ;
}
