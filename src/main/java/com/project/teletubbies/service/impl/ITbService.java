package com.project.teletubbies.service.impl;

import com.project.teletubbies.model.RequestModel;

/**
 * 서비스 인터페이스입니다.
 * 
 * @author douzone
 *
 */
public interface ITbService {

	public Object action(RequestModel requestModel, String ApiCode);

}
