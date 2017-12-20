package com.banhujiu.utils.wechat.kernel.auth;

import java.io.IOException;
import java.util.Map;

import com.banhujiu.utils.http.HttpFactory;
import com.banhujiu.utils.http.contracts.HttpRequestAble;
import com.banhujiu.utils.wechat.config.WechatConfig;
import com.banhujiu.utils.wechat.contracts.AccessTokenInterface;
import com.banhujiu.utils.wechat.entities.ErrorEntity;
import com.banhujiu.utils.wechat.exception.AccessTokenErrorException;
import com.banhujiu.utils.wechat.kernel.AbstractAccessToken;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author banhujiu
 * @date 2017/12/16 0016 16:51
 */
public class AccessToken extends AbstractAccessToken {
	private String baseUrl = "https://api.weixin.qq.com/cgi-bin/token";

	public AccessToken(WechatConfig wechatConfig) {
		super(wechatConfig);
	}

	public String getToken() {
		return getTokenByRequest();
	}

	private String getTokenByRequest() {
		Gson gson = new Gson();
		HttpRequestAble request = HttpFactory.getHttpRequest(getRequestMethod())
				.setUrl(baseUrl)
				.addParam("grant_type", "client_credential")
				.addParam("appid", getWechatConfig().getAppid())
				.addParam("secret", getWechatConfig().getSecret());
		try {
			request.send();
		} catch (IOException e) {
			throw new AccessTokenErrorException();
		}
		String result = request.toString();
		ErrorEntity errorEntity = gson.fromJson(result, ErrorEntity.class);
		if (!errorEntity.isEmpty()) {
			throw new AccessTokenErrorException(errorEntity.toString());
		}
		Map<String, String> map = gson.fromJson(result, new TypeToken<Map<String, String>>() {
		}.getType());
		return map.get(getTokenKey());
	}

	public AccessTokenInterface refresh() {
		String token = getTokenByRequest();
		return this;
	}
}
