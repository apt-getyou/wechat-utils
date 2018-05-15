package com.banhujiu.utils.wechat.crypto;

/**
 * @author banhujiu
 * @date 2018/5/8 0008 18:41
 */
public enum AESErrorCode {

	OK(0, "encodingAesKey 非法"),
	IllegalAesKey(-41001, "aes 解密失败"),
	IllegalIv(-41002, "解密后得到的buffer非法"),
	IllegalBuffer(-41003, "base64加密失败"),
	DecodeBase64Error(-41004, "base64解密失败"),;

	private int code;
	private String msg;

	AESErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}

