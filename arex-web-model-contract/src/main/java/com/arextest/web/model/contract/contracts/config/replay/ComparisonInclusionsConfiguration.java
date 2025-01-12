package com.arextest.web.model.contract.contracts.config.replay;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ComparisonInclusionsConfiguration extends AbstractComparisonDetailsConfiguration {
    List<String> inclusions;
}