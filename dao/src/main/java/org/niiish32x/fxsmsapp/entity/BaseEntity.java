package org.niiish32x.fxsmsapp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import org.apache.ibatis.type.JdbcType;

/**
 * BaseEntity
 *
 * @author shenghao ni
 * @date 2024.12.04 14:44
 */
public class BaseEntity  {

    private static final long serialVersionUID = -599070085404429053L;

    @TableField(
            value = "creator",
            fill = FieldFill.INSERT
    )
    private String creator;

    @TableField(
            value = "create_time",
            fill = FieldFill.INSERT,
            jdbcType = JdbcType.TIMESTAMP
//            typeHandler = UTCTOStringTypeHandler.class
    )
    private String createTime;

    @TableField(
            value = "modifier",
            fill = FieldFill.INSERT_UPDATE
    )
    private String modifier;

    @TableField(
            value = "modify_time",
            fill = FieldFill.INSERT_UPDATE,
            jdbcType = JdbcType.TIMESTAMP
//            typeHandler = UTCTOStringTypeHandler.class
    )
    private String modifyTime;

    @TableField(
            value = "create_staff_id",
            fill = FieldFill.INSERT,
            jdbcType = JdbcType.BIGINT
    )
    private Long createStaffId;

    @TableField(
            value = "modify_staff_id",
            fill = FieldFill.INSERT_UPDATE,
            jdbcType = JdbcType.BIGINT
    )
    private Long modifyStaffId;
}
