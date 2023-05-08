package com.project.teletubbies.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class TbController {
    @GetMapping("/hello")
    public List<String> Hello(){
        return Arrays.asList("서버 포트는 8080", "리액트 포트는 3001");
    }

    @RequestMapping(value = "/{ApiCode}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object APIHandler(
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse,
            @RequestBody Object param,
            @PathVariable String ApiCode
    ) throws Exception {
//        RequestInfo requestInfo = ExtractUtil.extractHeader(servletRequest, servletResponse);
        String result = "";
        long startTime = System.currentTimeMillis();
//
//        KlagoLog.logStart(requestInfo, "logStart ApiCode :: " + ApiCode);
//
//        RequestModel requestModel = new RequestModel();
//        requestModel.setData(param);
//        requestModel.setSessionInfo(sessionManager.getSessionInfo(requestInfo.getAuthToken()));
//
//        sessionManager.setGroupSeqAndDBSchema(requestModel, servletRequest, requestInfo);
//        GsmUtil.logLimitLetter(requestModel, 1000, requestInfo);
//
//        Object result = service.action(requestInfo, requestModel, ApiCode);

        try {
            String resultStr = String.valueOf(result);
            log.info(resultStr + " ::: " + startTime + "logEnd ApiCode :: " + ApiCode);
        } catch (Exception ex) { ex.printStackTrace(); }
        log.info(startTime + "logEnd ApiCode :: " + ApiCode);

        return result;
    }
}

