package org.niiish32x.fxsmsapp.openapi.vo;

import lombok.Data;

import java.util.List;

/**
 * ProtocolConfigVO
 *
 * @author shenghao ni
 * @date 2024.12.04 15:26
 */
@Data
public class ProtocolConfigVO {


    private String protocol;

    private String name;

    private String i18nModule;

    private String i18nKey;

    private String appName;

    private String venderName;

    private String serviceName;

    private String sendUrl;

    private String configUrl;

    private String systemConfigAppCode;

    private String systemConfigCode;

    private String doc;

    private String defaultTemplateCode;

    private List<ProtocolTemplateVO> templates;
}
