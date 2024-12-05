package org.niiish32x.fxsmsapp.localMessage.persistence.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.niiish32x.fxsmsapp.localMessage.persistence.LocalMessageDO;
import org.niiish32x.fxsmsapp.localMessage.persistence.dao.LocalMessageDAO;
import org.niiish32x.fxsmsapp.localMessage.persistence.mapper.LocalMessageMapper;
import org.springframework.stereotype.Component;

/**
 * LocalMessageDAOImpl
 *
 * @author shenghao ni
 * @date 2024.12.04 16:07
 */

@Component
public class LocalMessageDAOImpl extends ServiceImpl<LocalMessageMapper, LocalMessageDO> implements LocalMessageDAO {
}
