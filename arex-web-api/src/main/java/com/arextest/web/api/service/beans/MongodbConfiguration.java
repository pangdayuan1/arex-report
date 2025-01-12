package com.arextest.web.api.service.beans;

import com.arextest.web.model.dao.mongodb.AppCollection;
import com.arextest.web.model.dao.mongodb.RecordServiceConfigCollection;
import com.arextest.web.model.dao.mongodb.ReplayScheduleConfigCollection;
import com.arextest.web.model.dao.mongodb.ServiceOperationCollection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;


@Slf4j
@Configuration
public class MongodbConfiguration {

    @Value("${arex.report.mongo.uri}")
    private String mongoUrl;

    private static final String APP_ID = "appId";
    private static final String SERVICE_ID = "serviceId";
    private static final String OPERATION_NAME = "operationName";

    public MongoDatabaseFactory mongoDbFactory() {
        try {
            return new SimpleMongoClientDatabaseFactory(mongoUrl);
        } catch (Exception e) {
            LOGGER.error("cannot connect mongodb", e);
        }
        return null;
    }

    @Bean
    @ConditionalOnMissingBean
    public MongoTemplate mongoTemplate() {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(this.mongoDbFactory());
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate template = new MongoTemplate(this.mongoDbFactory(), converter);
        initIndicesAfterStartup(template);
        return template;
    }

    public void initIndicesAfterStartup(MongoTemplate mongoTemplate) {
        mongoTemplate.indexOps(AppCollection.class).ensureIndex(new Index().on(APP_ID, Sort.Direction.ASC).unique());
        mongoTemplate.indexOps(RecordServiceConfigCollection.class)
                .ensureIndex(new Index().on(APP_ID, Sort.Direction.ASC).unique());
        mongoTemplate.indexOps(ReplayScheduleConfigCollection.class)
                .ensureIndex(new Index().on(APP_ID, Sort.Direction.ASC).unique());
        mongoTemplate.indexOps(ServiceOperationCollection.class)
                .ensureIndex(new Index().on(APP_ID, Sort.Direction.ASC)
                        .on(SERVICE_ID, Sort.Direction.ASC)
                        .on(OPERATION_NAME, Sort.Direction.ASC)
                        .unique());
    }
}
