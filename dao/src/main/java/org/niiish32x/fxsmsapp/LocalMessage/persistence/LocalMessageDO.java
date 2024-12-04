package org.niiish32x.fxsmsapp.LocalMessage.persistence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
     * 自增主键，对应表中的id字段
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 消息内容字段，对应表中的message_content字段，设置了非空约束，使用@TableField注解指定
     */
    @TableField("message_content")
    private String messageContent;

    /**
     * 状态字段，对应表中的status字段，设置了非空约束且有默认值，使用@TableField注解指定
     */
    @TableField("status")
    private String status;

    /**
     * 创建时间字段，对应表中的created_at字段，有默认值，使用@TableField注解指定
     */
    @TableField("created_at")
    private Date createdAt;

    /**
     * 更新时间字段，对应表中的updated_at字段，有默认值且会在更新时自动更新，使用@TableField注解指定
     */
    @TableField("updated_at")
    private Date updatedAt;
}