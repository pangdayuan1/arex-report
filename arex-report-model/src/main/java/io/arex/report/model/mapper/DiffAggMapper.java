package io.arex.report.model.mapper;

import io.arex.report.model.dao.mongodb.ReportDiffAggStatisticCollection;
import io.arex.report.model.dao.mongodb.entity.SceneDetail;
import io.arex.report.model.dto.DiffAggDto;
import io.arex.report.model.dto.SceneDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.Map;


@Mapper
public interface DiffAggMapper {
    DiffAggMapper INSTANCE = Mappers.getMapper(DiffAggMapper.class);

    ReportDiffAggStatisticCollection daoFromDto(DiffAggDto dto);

    DiffAggDto dtoFromDao(ReportDiffAggStatisticCollection dao);

    default Map<String, Map<String, SceneDetail>> map1(Map<String, Map<String, SceneDetailDto>> dto) {
        if (dto == null) {
            return null;
        }
        Map<String, Map<String, SceneDetail>> result = new HashMap<>();
        dto.forEach((key, value) -> {
            if (value != null) {
                Map<String, SceneDetail> s = new HashMap<>();
                value.forEach((k, v) -> {
                    SceneDetail sd = SceneDetailMapper.INSTANCE.daoFromDto(v);
                    s.put(k, sd);
                });
                result.put(key, s);
            }
        });
        return result;
    }

    default Map<String, Map<String, SceneDetailDto>> map(Map<String, Map<String, SceneDetail>> dao) {
        if (dao == null) {
            return null;
        }
        Map<String, Map<String, SceneDetailDto>> result = new HashMap<>();
        dao.forEach((key, value) -> {
            if (value != null) {
                Map<String, SceneDetailDto> s = new HashMap<>();
                value.forEach((k, v) -> {
                    SceneDetailDto sd = SceneDetailMapper.INSTANCE.dtoFromDao(v);
                    s.put(k, sd);
                });
                result.put(key, s);
            }
        });
        return result;
    }
}
