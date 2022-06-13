package com.yuansong.dailyHelper.service.secret;

import com.yuansong.dailyHelper.global.DHConstant;

public interface ISecretService {

    /**
     * 加密文本
     * @param plainText 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception 加密异常
     */
    String encrypt(String plainText, String key) throws Exception;

    default String encrypt(String plainText) throws Exception {
        return encrypt(plainText, DHConstant.SECRET_KEY);
    }

    /**
     * 解密文本
     * @param cipherText 密文
     * @param key 密钥
     * @return 明文
     * @throws Exception 解密异常
     */
    String decrypt(String cipherText, String key) throws Exception;

    default String decrypt(String cipherText) throws Exception {
        return decrypt(cipherText, DHConstant.SECRET_KEY);
    }

}
