package com.arextest.web.model.dao.mongodb;

import com.arextest.web.model.dao.mongodb.entity.ReportAppConfigSummery;
import lombok.Data;

import java.util.List;


@Data
public class ReportAppConfigStatisticCollection {
    private String userName;
    private ReportAppConfigSummery totalSummary;
    private List<ReportAppConfigSummery> groupSummery;
    private List<Integer> appIdList;

}
