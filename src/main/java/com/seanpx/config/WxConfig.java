package com.seanpx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wxpay")
public class WxConfig {

    private String appid;
    private String secret;
    private String merchantid;

    // Getters and setters
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    @Override
    public String toString() {
        return "WxConfig{" +
                "appid='" + appid + '\'' +
                ", secret='" + secret + '\'' +
                ", merchantid='" + merchantid + '\'' +
                '}';
    }
}
