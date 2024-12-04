package org.niiish32x.fxsmsapp.LocalMessage.persistence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * LocalMessageDO
 *
 * 本地消息表DO
 *
 * @author shenghao ni
 * @date 2024.12.04 15:58
 */

@TableName("local_message")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LocalMessageDO {
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String messageContent;

    private String status;

    Date created_at;

    Date updated_at;
}
