package com.arextest.report.model.api.contracts.config.yamlTemplate.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by rchen9 on 2022/9/27.
 */
@Data
public class ListSortTemplateConfig {
    private String listPath;
    private List<String> keys;
}