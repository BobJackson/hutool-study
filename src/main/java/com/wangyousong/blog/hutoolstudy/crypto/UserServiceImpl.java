package com.wangyousong.blog.hutoolstudy.crypto;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Value("${iam.encrypt.key}")
    private String encryptKey;


    public void createUser() {
        String phone = "13600000000";
        AES aes = getAes();
        String encryptedPhone = aes.encryptHex(phone);
        System.out.println("encryptedPhone:" + encryptedPhone);
    }

    private AES getAes() {
        byte[] key = encryptKey.getBytes();
        return SecureUtil.aes(key);
    }

    public void sendSms(String encryptedPhone) {
        AES aes = getAes();
        String decryptedPhone = aes.decryptStr(encryptedPhone);
        System.out.println("decryptedPhone:" + decryptedPhone);
    }

}
