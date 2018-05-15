package com.banhujiu.utils.wechat.crypto;

import java.util.Base64;

/**
 * @author banhujiu
 * @date 2018/5/8 0008 18:35
 */
public class AESUtils {
	/**
	 * 校验数据真实性，并获取解密后的明文
	 *
	 * @param encryptedData 加密的数据
	 * @param iv            初始向量
	 * @param sessionKey    用户在小程序登录后获取的会话密钥
	 *
	 * @return 解密后的原文
	 */
	public static String decryptData(String encryptedData, String iv, String sessionKey) {
		if (sessionKey == null || sessionKey.length() != 24) {
			throw new RuntimeException(AESErrorCode.IllegalAesKey.getMsg());
		}
		if (iv == null || iv.length() != 24) {
			throw new RuntimeException(AESErrorCode.IllegalIv.getMsg());
		}
		final Base64.Decoder decoder = Base64.getDecoder();
		AES aes = new AES();
		String result;
		try {
			byte[] decrypt = aes.decrypt(decoder.decode(encryptedData), decoder.decode(sessionKey), decoder.decode(iv));
			result = new String(decrypt, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(AESErrorCode.IllegalAesKey.getMsg());
		}
		return result;
	}
}
