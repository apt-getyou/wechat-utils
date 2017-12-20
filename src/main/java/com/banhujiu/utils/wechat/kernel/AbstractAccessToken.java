package com.banhujiu.utils.wechat.kernel;

import com.banhujiu.utils.wechat.config.WechatConfig;
import com.banhujiu.utils.wechat.contracts.AccessTokenInterface;

/**
 * @author banhujiu
 * @date 2017/12/16 0016 16:52
 */
public abstract class AbstractAccessToken implements AccessTokenInterface {
	private WechatConfig wechatConfig;
	private int safeSeconds = 500;
	private String tokenKey = "access_token";
	private String cachePrefix = "access_token.";
	private String requestMethod = "GET";

	public AbstractAccessToken(WechatConfig wechatConfig) {
		this.wechatConfig = wechatConfig;
	}

	public WechatConfig getWechatConfig() {
		return wechatConfig;
	}

	protected String getTokenKey() {
		return tokenKey;
	}

	protected String getCachePrefix() {
		return cachePrefix;
	}

	protected String getRequestMethod() {
		return requestMethod;
	}
}
