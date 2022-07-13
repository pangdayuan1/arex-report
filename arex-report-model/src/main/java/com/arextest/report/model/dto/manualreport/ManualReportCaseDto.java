package com.arextest.report.model.dto.manualreport;

import com.arextest.report.model.api.contracts.common.LogEntity;
import com.arextest.report.model.dao.mongodb.entity.AuthDao;
import com.arextest.report.model.dao.mongodb.entity.BodyDao;
import com.arextest.report.model.dao.mongodb.entity.KeyValuePairDao;
import lombok.Data;

import java.util.List;

@Data
public class ManualReportCaseDto {
    private String id;
    private String preRequestScript;
    private String testScript;
    private BodyDao body;
    private List<KeyValuePairDao> headers;
    private List<KeyValuePairDao> params;
    private AuthDao auth;

    private String planItemId;
    private String caseName;
    private String baseMsg;
    private String testMsg;
    private List<LogEntity> logs;
    private Integer diffResultCode;
}
