package com.banhujiu.utils.wechat.contracts;

import java.util.List;

/**
 * @author banhujiu
 * @date 2017/12/16 0016 16:40
 */
public interface AccessTokenInterface {
	List<String> getToken();

	AccessTokenInterface refresh();
}
