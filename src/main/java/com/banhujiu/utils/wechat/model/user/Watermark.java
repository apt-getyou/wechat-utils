package com.banhujiu.utils.wechat.model.user;

/**
 * @author banhujiu
 * @date 2018/5/8 0008 19:29
 */
public class Watermark {
	private Long timestamp;
	private String appid;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
}
