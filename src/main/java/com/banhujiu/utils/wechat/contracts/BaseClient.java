package com.banhujiu.utils.wechat.contracts;

/**
 * @author banhujiu
 * @date 2017/12/16 0016 18:49
 */
public interface BaseClient {
	String getBaseUrl();

	AccessTokenInterface getAccessToken();
}
