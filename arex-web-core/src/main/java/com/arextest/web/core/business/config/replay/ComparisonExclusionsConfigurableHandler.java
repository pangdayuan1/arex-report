package com.arextest.web.core.business.config.replay;

import com.arextest.web.core.repository.ConfigRepositoryProvider;
import com.arextest.web.model.contract.contracts.config.replay.ComparisonExclusionsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rchen9 on 2022/9/16.
 */
@Component
public class ComparisonExclusionsConfigurableHandler extends AbstractComparisonConfigurableHandler<ComparisonExclusionsConfiguration> {
    protected ComparisonExclusionsConfigurableHandler(@Autowired
            ConfigRepositoryProvider<ComparisonExclusionsConfiguration> repositoryProvider) {
        super(repositoryProvider);
    }
}
