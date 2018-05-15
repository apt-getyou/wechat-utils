package com.banhujiu.utils.wechat.crypto;

/**
 * @author banhujiu
 * @date 2018/5/8 0008 19:13
 */

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AES {
	public static boolean initialized = false;

	/**
	 * AES解密
	 *
	 * @param content 密文
	 */
	public byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) throws NoSuchPaddingException, NoSuchAlgorithmException,
			BadPaddingException, IllegalBlockSizeException, InvalidParameterSpecException, InvalidAlgorithmParameterException, InvalidKeyException {
		initialize();
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
		Key sKeySpec = new SecretKeySpec(keyByte, "AES");

		cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
		return cipher.doFinal(content);
	}

	public static void initialize() {
		if (initialized) return;
		Security.addProvider(new BouncyCastleProvider());
		initialized = true;
	}

	//生成iv
	public static AlgorithmParameters generateIV(byte[] iv) throws NoSuchAlgorithmException, InvalidParameterSpecException {
		AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
		params.init(new IvParameterSpec(iv));
		return params;
	}
}
