package com.banhujiu.utils.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.banhujiu.utils.wechat.config.WechatConfig;
import com.banhujiu.utils.wechat.kernel.auth.AccessToken;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 17:24
 */
public class AccessTokenTest {
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Test
	public void getAccessTokenTest() {
		Properties prop = getProperties("WeChat.properties");
		WechatConfig config = new WechatConfig();
		config.setAppid(prop.getProperty("appid"));
		config.setSecret(prop.getProperty("secret"));
		AccessToken accessToken = new AccessToken(config);
		System.out.println(accessToken.getToken());
	}

	private Properties getProperties(String fileName) {
		Properties prop = new Properties();
		InputStream in = null;
		try {
			//读取属性文件a.properties
			in = AccessTokenTest.class.getClassLoader().getResourceAsStream(fileName);
			prop.load(in);///加载属性列表
		} catch (Exception e) {
			e.printStackTrace();
			return prop;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
