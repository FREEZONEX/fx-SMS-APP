package org.niiish32x.fxsmsapp;

/**
 * Constants
 * 枚举常量
 * @author shenghao ni
 * @date 2024.12.04 11:32
 */
public class Constants {
    public final static String HTTP_HEADER_AUTHORIZATION = "Authorization";

    public final static String VENDOR_NAME = "supos";
    public final static String APP_NAME = "短信";
    public final static String APP_SHOW_NAME = "twilio";

    public static final String URL_GET_SYS_CONFIG = "/open-api/systemconfig/v1/config/catalog/%s/" + VENDOR_NAME+APP_SHOW_NAME;
    public static final String URL_POST_SYS_CONFIG = "/open-api/systemconfig/v1/config/catalog";

}
