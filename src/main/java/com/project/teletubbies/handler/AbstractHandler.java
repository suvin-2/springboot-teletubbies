package com.project.teletubbies.handler;

import com.project.teletubbies.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 핸들러 객체의 추상클래스입니다.
 * 
 * @author douzone
 *
 */
@Component
public abstract class AbstractHandler implements IHandler {

	@Autowired
	private MessageManager messageManager;

	/**
	 * 다국어 처리용 메소드입니다.
	 */
	@Override
	public String getMessage(String code, Locale locale) {
		return messageManager.getMessage(code, null, locale);
	}
	/**
	 * 다국어 처리용 메소드입니다.
	 */
	@Override
	public String getMessage(String code, Object[] args, Locale locale) {
		return messageManager.getMessage(code, args, locale);
	}
}
