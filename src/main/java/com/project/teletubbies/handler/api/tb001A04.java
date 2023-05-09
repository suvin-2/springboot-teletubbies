package com.project.teletubbies.handler.api;

import com.project.teletubbies.handler.AbstractHandler;
import com.project.teletubbies.handler.IHandler;
import com.project.teletubbies.mapper.TbMapper;
import com.project.teletubbies.model.APIResult;
import com.project.teletubbies.model.RequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component("tb001A04")
@Slf4j            // 로그 찍기
public class tb001A04 extends AbstractHandler {
    @Autowired
    TbMapper tbMapper;

    @Override
    public String getAPICode() {return "tb001A04";}

    @Override
    public Object handle(RequestModel requestModel, String ApiCode, Locale locale) throws Exception {
        // 사용자 목록 조회 API
        Map<String, Object> resultMap = (Map<String, Object>) new HashMap();
        String resultStatus = "fail";

        Map<String, Object> params = (Map<String, Object>) new HashMap();
        params = (Map<String, Object>) requestModel.getData();

//        APIResult result = new APIResult();

        // 로그인 사용자 정보 가져올 경우 후에 위에 주석 풀기
        /*String clientIp = requestModel.getSessionInfo().getTbUserInfo().getClientIp();
        P00_KissCommonMethod.setInitData(clientIp, params, requestModel, redisManager);*/

        List<Map<String, Object>> userList = tbMapper.getUserList(params);
        for (Map<String, Object> userInfo : userList) {
            // 추후 검색 조건 추가 시에 돌리기
        }

        resultMap.put("userList", userList);

        return userList;
    }

}
