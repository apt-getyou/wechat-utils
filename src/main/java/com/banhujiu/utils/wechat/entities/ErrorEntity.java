package com.banhujiu.utils.wechat.entities;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 18:01
 */
public class ErrorEntity {
	private String errcode;
	private String errmsg;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ErrorEntity{");
		sb.append("errcode='").append(errcode).append('\'');
		sb.append(", errmsg='").append(errmsg).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public boolean isEmpty() {
		if (errcode == null || errcode.equals("")) {
			return true;
		}
		return false;
	}
}
