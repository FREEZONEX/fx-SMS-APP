package org.niiish32x.fxsmsapp.localMessage.persistence.converter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.niiish32x.fxsmsapp.localMessage.domain.entity.LocalMessageEO;
import org.niiish32x.fxsmsapp.localMessage.persistence.LocalMessageDO;

import java.util.List;

/**
 * LocalMessageConverter
 *
 * @author shenghao ni
 * @date 2024.12.05 14:15
 */


@Mapper(imports = {JSON.class, TypeReference.class, List.class})
public interface LocalMessageConverter {
    LocalMessageConverter INSTANCE = Mappers.getMapper(LocalMessageConverter.class);

    LocalMessageEO toEO(LocalMessageDO localMessageDO);

    LocalMessageDO toDO(LocalMessageEO localMessageEO);
}
