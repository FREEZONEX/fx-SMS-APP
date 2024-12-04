package org.niiish32x.fxsmsapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.niiish32x.fxsmsapp.entity.NoticeProtocol;
import org.springframework.stereotype.Repository;

/**
 * NoticeProtocolMapper
 *
 * @author shenghao ni
 * @date 2024.12.04 14:41
 */
@Mapper
@Repository("smsNoticeProtocolMapper")
public interface NoticeProtocolMapper extends BaseMapper<NoticeProtocol> {
}
