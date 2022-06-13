package com.yuansong.dailyHelper.service.secret.impl;

import com.github.deansquirrel.tools.secret.SimpleOne;
import com.yuansong.dailyHelper.service.secret.ISecretService;
import org.springframework.stereotype.Service;

@Service
public class SecretServiceImpl implements ISecretService {
    @Override
    public String encrypt(String plainText, String key) throws Exception {
        return SimpleOne.EncryptToBase64Format(plainText, key);
    }

    @Override
    public String decrypt(String cipherText, String key) throws Exception {
        return SimpleOne.DecryptFromBase64Format(cipherText, key);
    }
}
