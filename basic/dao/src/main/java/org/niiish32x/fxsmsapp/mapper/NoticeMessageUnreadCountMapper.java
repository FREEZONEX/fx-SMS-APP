package org.niiish32x.fxsmsapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * NoticeMessageUnreadCountMapper
 *
 * @author shenghao ni
 * @date 2024.12.04 14:37
 */
@Mapper
@Repository("smsNoticeMessageUnreadCountMapper")
@Deprecated
public interface NoticeMessageUnreadCountMapper extends BaseMapper<NoticeMessageUnreadCountMapper> {
    @Update("update notice_message_unread_count " +
            "set unread_count = unread_count + 1 ,modify_time = #{updateTime} " +
            "where staff_code = #{staffCode} " +
            "and notice_protocol_id = #{noticeProtocolId} " +
            "and topic_id = #{topicId}")

    Integer increase(@Param("staffCode") String staffCode,
                     @Param("noticeProtocolId") Long noticeProtocolId,
                     @Param("topicId") Long topicId,
                     @Param("updateTime") Date updateTime);
}
