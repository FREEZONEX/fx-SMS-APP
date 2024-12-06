package org.niiish32x.fxsmsapp.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * BaseResponse
 *
 * @author shenghao ni
 * @date 2024.12.06 10:45
 */
public class BaseResponse {
    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("status_message")
    private String statusMessage;

    public BaseResponse(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
