package com.banhujiu.utils.wechat;

import java.io.IOException;

import org.junit.Test;

import com.banhujiu.utils.http.HttpFactory;
import com.banhujiu.utils.http.contracts.HttpRequestAble;
import com.banhujiu.utils.wechat.entities.ErrorEntity;
import com.google.gson.Gson;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 17:24
 */
public class AccessTokenTest {
	@Test
	public void getAccessTokenTest() throws IOException {
		Gson gson = new Gson();
		HttpRequestAble httpRequestAble = HttpFactory.getHttpRequest("GET");
		httpRequestAble.setUrl("https://api.weixin.qq.com/cgi-bin/token")
				.addParam("grant_type", "client_credential")
				.addParam("appid", "12")
				.addParam("secret", "sdf")
				.send();
		String result = httpRequestAble.toString();
		System.out.println(result);
		ErrorEntity errorEntity = gson.fromJson(result, ErrorEntity.class);
		System.out.println(errorEntity);
	}
}
