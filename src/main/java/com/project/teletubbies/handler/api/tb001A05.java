package com.project.teletubbies.handler.api;

import com.project.teletubbies.handler.AbstractHandler;
import com.project.teletubbies.mapper.TbMapper;
import com.project.teletubbies.model.RequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component("tb001A05")
@Slf4j      // 로그 찍기
public class tb001A05 extends AbstractHandler {
    @Autowired
    TbMapper tbMapper;

    @Override
    public String getAPICode() { return "tb001A05"; }

    @Override
    public Object handle(RequestModel requestModel, String ApiCode, Locale locale){
        // 사용자 상세조회 API
        Map<String, Object> resultMap = (Map<String, Object>) new HashMap();
        String resultStatus = "fail";

        Map<String, Object> params = (Map<String, Object>) new HashMap();
        params = (Map<String, Object>) requestModel.getData();

        // 로그인 사용자 정보 가져올 경우 후에 위에 주석 풀기
        /*String clientIp = requestModel.getSessionInfo().getTbUserInfo().getClientIp();
        P00_KissCommonMethod.setInitData(clientIp, params, requestModel, redisManager);*/


        int checkLogin = 0;
        checkLogin = tbMapper.getUserCount(params);

        if(checkLogin == 1){
            // 로그인 사용자 정보가 있을 경우
            log.info("======= tb001A04 로그인 성공 =======");
            resultStatus = "success";
        }

        return resultStatus;
    }
}
