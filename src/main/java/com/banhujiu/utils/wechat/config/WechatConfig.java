package com.banhujiu.utils.wechat.config;

/**
 * @author banhujiu
 * @date 2017/12/16 0016 16:32
 */
public class WechatConfig {
	private String appid;
	private String secret;
	private String token;

	private String prefix = "wechat";

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
