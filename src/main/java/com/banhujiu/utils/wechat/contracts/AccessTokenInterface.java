package com.banhujiu.utils.wechat.contracts;

/**
 * @author banhujiu
 * @date 2017/12/16 0016 16:40
 */
public interface AccessTokenInterface {
	String getToken();

	AccessTokenInterface refresh();
}
