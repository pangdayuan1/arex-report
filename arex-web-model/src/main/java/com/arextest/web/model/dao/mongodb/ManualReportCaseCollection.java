package com.arextest.web.model.dao.mongodb;

import com.arextest.web.model.dao.mongodb.entity.AuthDao;
import com.arextest.web.model.dao.mongodb.entity.BodyDao;
import com.arextest.web.model.dao.mongodb.entity.KeyValuePairDao;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "ManualReportCase")
public class ManualReportCaseCollection extends ModelBase {
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
    private String logs;
    private Integer diffResultCode;
}
