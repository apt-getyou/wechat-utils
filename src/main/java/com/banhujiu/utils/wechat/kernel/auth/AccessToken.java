package com.banhujiu.utils.wechat.kernel.auth;

import java.util.List;

import com.banhujiu.utils.wechat.config.WechatConfig;
import com.banhujiu.utils.wechat.contracts.AccessTokenInterface;
import com.banhujiu.utils.wechat.kernel.AbstractAccessToken;

/**
 * @author banhujiu
 * @date 2017/12/16 0016 16:51
 */
public class AccessToken extends AbstractAccessToken {
	private String baseUrl = "https://api.weixin.qq.com/cgi-bin/token";

	public AccessToken(WechatConfig wechatConfig) {
		super(wechatConfig);
	}

	public List<String> getToken() {
		return null;
	}

	public AccessTokenInterface refresh() {
		return null;
	}
}
