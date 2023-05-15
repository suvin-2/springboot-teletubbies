package com.project.teletubbies.controller;


import com.project.teletubbies.dao.TbUserInfo;
import com.project.teletubbies.model.SessionInfo;
import com.project.teletubbies.model.RequestModel;
import com.project.teletubbies.service.TbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
//@RestController
@Slf4j
public class TbController {

//    TbService tbService;
    private final TbService tbService;

    public TbController(TbService tbService) {
        this.tbService = tbService;
    }

    @GetMapping("/hello")
    public List<String> Hello(){
        return Arrays.asList("서버 포트는 8004", "리액트 포트는 3001");
    }

    @RequestMapping(value = "/{ApiCode}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object APIHandler(
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse,
            @RequestBody Object param,
            @PathVariable String ApiCode ) throws Exception
    {

        log.info("TbController start");
        long startTime = System.currentTimeMillis();

        // 해당 API요청에서 사용될 사용자 정보와 요청 파라미터를 담을 모델을 생성합니다.
        RequestModel requestModel = new RequestModel();


        String ip = servletRequest.getHeader("X-Forwarded-For");
        if (ip == null) {
            ip = servletRequest.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = servletRequest.getHeader("WL-Proxy-Client-IP"); // 웹로직
        }
        if (ip == null) {
            ip = servletRequest.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = servletRequest.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = servletRequest.getRemoteAddr();
        }
        StringBuffer requestURL = servletRequest.getRequestURL();


        //////////////////////////////////////////////////////////////////////////////////////////
        // 내 PC 로컬 테스트인 경우
        if(requestURL.indexOf("localhost") > -1) {

            // 사용자 정보 임시 하드코딩
            // 세션 연동 시 주석 해제
            SessionInfo sessionInfo = new SessionInfo();
            TbUserInfo tbUserInfo = new TbUserInfo();

            // userSeq : 1
            /*tbUserInfo.setUserId("admin");
            tbUserInfo.setUserPw("1234567");
            tbUserInfo.setUserName("관리자");
            tbUserInfo.setNickName("텔레토비");
            tbUserInfo.setPhone("010-1234-5678");
            tbUserInfo.setEmail("tele@tobi.com");
            tbUserInfo.setUserAuth("A");*/

            tbUserInfo.setUserId("admin");
            tbUserInfo.setUserPw("1234567");
            tbUserInfo.setUserName("관리자");
            tbUserInfo.setNickName("텔레토비");
            tbUserInfo.setPhone("010-1234-5678");
            tbUserInfo.setEmail("tele@tobi.com");
            tbUserInfo.setUserAuth("A");
            log.info("TbController tbUserInfo : " + tbUserInfo.getUserId());
            log.info("TbController tbUserInfo : " + tbUserInfo.getUserPw());
            log.info("TbController tbUserInfo : " + tbUserInfo.getUserName() +"\n");
            log.info("TbController tbUserInfo : " + tbUserInfo);

            sessionInfo.setTbUserInfo(tbUserInfo);
            requestModel.setSessionInfo(sessionInfo);

            log.info("TbController sessionInfo : " + sessionInfo.getTbUserInfo());
            log.info("TbController requestModel : " + requestModel.getSessionInfo());

        }
        // 실서버 또는 데모서버인 경우
        // 세션 사용 시 주석 해제
        else {
//            SessionInfo sessionInfo = sessionManager.getSessionInfo( requestInfo.getAuthToken() );
//            requestModel.setSessionInfo(sessionInfo);
        }
        //////////////////////////////////////////////////////////////////////////////////////////


        log.info("TbController param : " + param);
        // 요청 객체에 요청 파라미터를 저장합니다.
        requestModel.setData(param);

        Object result = null;
        log.info("TbController ApiCode : " + ApiCode);
        result = tbService.action(requestModel, ApiCode);
        log.info("TbController result : " + result);

        System.out.println("소요시간 : " + startTime);

        // 결과값을 반환합니다.
        return result;

    }
}