package com.banhujiu.utils.wechat.exception;

/**
 * @author banhujiu
 * @date 2017/12/19 0019 11:29
 */
public class AccessTokenErrorException extends RuntimeException {

	private static final long serialVersionUID = 4840360971827071999L;

	public AccessTokenErrorException() {
		super();
	}

	public AccessTokenErrorException(String message) {
		super(message);
	}
}
