package org.niiish32x.fxsmsapp.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * NoticeProtocol
 * 协议表
 * @author shenghao ni
 * @date 2024.12.04 14:25
 */
@Data
@Accessors(chain = true)
public class NoticeProtocol extends BaseEntity  {

    /**
     * 协议ID
     */
    private Long id;

    /**
     * 协议类型
     */
    private String protocol;

    /**
     * 协议展示名
     */
    private String name;

    /**
     * appName
     */
    private String appName;

    /**
     * venderName
     */
    private String venderName;

    /**
     * app访问地址
     */
    private String serviceName;

    /**
     * 消息协议发送地址
     */
    private String sendUrl;

    /**
     * 消息协议配置地址
     */
    private String configUrl;

    /**
     * 系统配置唯一标示：systemConfigAppCode + systemConfigCode
     */
    private String systemConfigAppCode;

    /**
     * 系统配置唯一标示：systemConfigAppCode + systemConfigCode
     */
    private String systemConfigCode;

    /**
     * 默认基础模板code
     */
    private String defaultTemplateCode;

    /**
     * 消息内容支持格式, 0 纯文本、1 富文本
     */
    private Integer contentType;

    /**
     * 消息协议说明文档
     */
    private String doc;

    /**
     * 国际化模块名
     */
    private String i18nModule;

    /**
     * 国际化key
     */
    private String i18nKey;

    /**
     * 是否为系统协议
     */
    private Integer system;


    public static String getIdFieldName() {
        return "id";
    }

    public static String getProtocolFieldName() {
        return "protocol";
    }

    public static String getNameFieldName() {
        return "name";
    }

    public static String getAppNameFieldName() {
        return "app_name";
    }

    public static String getVenderNameFieldName() {
        return "vender_name";
    }

    public static String getSendUrlFieldName() {
        return "send_url";
    }

    public static String getConfigUrlFieldName() {
        return "config_url";
    }

    public static String getDefaultTemplateCodeFieldName() {
        return "default_template_code";
    }

    public static String getContentTypeFieldName() {
        return "content_type";
    }

    public static String getDocFieldName() {
        return "doc";
    }

    public static String getSystemFieldName() {
        return "system";
    }

}
