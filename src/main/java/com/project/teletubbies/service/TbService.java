package com.project.teletubbies.service;

import com.project.teletubbies.dao.TbUserInfo;
import com.project.teletubbies.handler.HandlerManager;
import com.project.teletubbies.handler.IHandler;
import com.project.teletubbies.mapper.CommonMapper;
import com.project.teletubbies.mapper.TbMapper;
import com.project.teletubbies.model.APIResult;
import com.project.teletubbies.model.RequestModel;
import com.project.teletubbies.model.SessionInfo;
import com.project.teletubbies.service.impl.ITbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j  // 로그 찍기
public class TbService implements ITbService {
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    private final TbMapper tbMapper;

    @Autowired
    HandlerManager handlerManager;

    @Autowired
    CommonMapper commonMapper;

    public Object action(RequestModel requestModel, String ApiCode) {
        //사용자 언어 코드를 따라 다국어 정의
        //Locale locale = MessageManager.checkLocale(requestModel.getSessionInfo());    // jake.

        //jake start  -->
        Locale locale = null;
        locale = Locale.KOREAN;
        // <--

        log.info("TbService start ");

        IHandler handler = null;
        //결과값 객체 선언
        APIResult result = new APIResult();
        try{
            //요청 URL의 서비스 명에 맞는 핸들러를 가져옵니다.
            handler = handlerManager.get(ApiCode);
            log.info("TbService ApiCode : " + ApiCode);
            log.info("TbService handler : " + handler);

        }catch(Exception e) {
            // 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
            log.info("개발자 입력 정보" + e.getMessage());
        }

        if(handler == null) {
            result.setResultCode(500);
            // 결과 메시지를 정의합니다.
            result.setResultMsg(ApiCode);
            // 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
            log.error("TbService handler is Null");
            log.info("TbService handler is Null");
            return result;
        }else {
            try {
                // 시작날짜, 종료날짜 정수 체크
                //checkTypeDate(requestInfo, requestModel);

                //결과 코드 설정
                result.setResultCode(0);
                //결과 메시지 설정
                result.setResultMsg("");
                //결과값 설정
                result.setResultData(handler.handle(requestModel, ApiCode, locale));

            }catch(Exception e) {

                //결과 코드 설정
                result.setResultCode(1500);
                //다국어 처리를 사용하여 결과 메시지 정의
                //result.setResultMsg(ApiCode+" "+messageManager.getMessage("21000", locale) + e.toString());
                result.setResultMsg(ApiCode+" "+e.toString());
                // 로직중 에러 로그 처리를 위하여 에러 로그 함수를 사용합니다.
                log.error("TbService 1500 e error !!!!");

                e.printStackTrace();

            }

        }

        return result;
    }

}
