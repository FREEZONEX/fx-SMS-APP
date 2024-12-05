package org.niiish32x.fxsmsapp.localMessage.repo.impl;

import org.niiish32x.fxsmsapp.localMessage.domain.entity.LocalMessageEO;
import org.niiish32x.fxsmsapp.localMessage.domain.repo.LocalMessageRepo;
import org.niiish32x.fxsmsapp.localMessage.persistence.LocalMessageDO;
import org.niiish32x.fxsmsapp.localMessage.persistence.converter.LocalMessageConverter;
import org.niiish32x.fxsmsapp.localMessage.persistence.dao.LocalMessageDAO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LocalMessageRepoImpl
 *
 * @author shenghao ni
 * @date 2024.12.05 14:10
 */

@Repository
public class LocalMessageRepoImpl implements LocalMessageRepo {

    LocalMessageConverter converter = LocalMessageConverter.INSTANCE;
    @Resource
    LocalMessageDAO localMessageDAO;


    @Override
    public List<LocalMessageEO> query() {
        List<LocalMessageDO> list = localMessageDAO.list();
        return list.stream().map(converter::toEO).collect(Collectors.toList());
    }
}
