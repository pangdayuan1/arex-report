package io.arex.report.web.api.service.controller;

import io.arex.common.model.response.Response;
import io.arex.common.model.response.ResponseCode;
import io.arex.common.utils.ResponseUtils;
import io.arex.report.core.business.configservice.ConfigService;
import io.arex.report.model.api.contracts.configservice.PushConfigTemplateRequestType;
import io.arex.report.model.api.contracts.configservice.PushConfigTemplateResponseType;
import io.arex.report.model.api.contracts.configservice.QueryConfigTemplateRequestType;
import io.arex.report.model.api.contracts.configservice.QueryConfigTemplateResponseType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@Controller
@RequestMapping("/api/config/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConfigController {

    @Resource
    private ConfigService configService;

    @PostMapping("/queryConfigTemplate")
    @ResponseBody
    public Response queryConfigTemplate(@RequestBody QueryConfigTemplateRequestType request) {
        if (StringUtils.isEmpty(request.getAppId())) {
            return ResponseUtils.errorResponse("appId is empty", ResponseCode.REQUESTED_PARAMETER_INVALID);
        }
        QueryConfigTemplateResponseType response = configService.queryConfigTemplate(request);
        return ResponseUtils.successResponse(response);
    }

    @PostMapping("/pushConfigTemplate")
    @ResponseBody
    public Response pushConfigTemplate(@RequestBody PushConfigTemplateRequestType request) {
        if (StringUtils.isEmpty(request.getAppId())) {
            return ResponseUtils.errorResponse("appId is empty", ResponseCode.REQUESTED_PARAMETER_INVALID);
        }
        PushConfigTemplateResponseType response = configService.pushConfigTemplate(request);
        return ResponseUtils.successResponse(response);
    }


}
