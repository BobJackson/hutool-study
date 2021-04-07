package com.wangyousong.blog.hutoolstudy.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import org.junit.jupiter.api.Test;

public class SecureUtilTest {

    @Test
    void aes() {
        String content = "Bob";

        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
//        FileUtil.writeBytes(key,new File("1.txt"));

        //将秘钥转为Base64
        //String keyRandomEncode = Base64.encode(keyRandom);
        String keyRandomEncode = Base64.encode(key);
        System.out.println(keyRandomEncode);

//        key = "EC/Z+S7c3EFJa2dtvLyekg==";





        //将Base64编码的秘钥的格式进行解码转换
        byte[] keyByte = Base64.decode(key);


        System.out.println("key = " + new String(key));


        //构建
        AES aes = SecureUtil.aes(key);

        //加密为16进制表示
        String encryptHex = aes.encryptHex(content);

        String encryptDataEncode = Base64.encode(encryptHex);
        System.out.println(encryptDataEncode);

        System.out.println("encryptHex = " + encryptHex);


        //解密为原字符串
        String decryptStr = aes.decryptStr(encryptHex);
        System.out.println("decryptStr = " + decryptStr);
    }

    @Test
    void demo() {
        String content = "17602196213";
        content = "1187688895@qq.com";
        content = "wys2317@hotmail.com";
        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println("key = " + new String(key));

        //构建
        AES aes = SecureUtil.aes(key);
        //加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println("encryptHex = " + encryptHex);

        //解密为原字符串
        String decryptStr = aes.decryptStr(encryptHex);
        System.out.println("decryptStr = " + decryptStr);
    }


    public String encryptAES(String data, String key)  {
        //生成一个随机秘钥
        //byte[] kkkkRandom = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        //将秘钥转为Base64
        //key = Base64.encode(kkkkRandom);
        //key = "7Df05RgSzVm8/wWzUeTDaA==";

        //将Base64编码的秘钥的格式进行解码转换
        byte[] keyByte = Base64.decode(key);
        //加密
        AES aes = SecureUtil.aes(keyByte);        //构建
        byte[] encryptData = aes.encrypt(data);    //加密
        //加密后的数据转为Base64
        return Base64.encode(encryptData);
    }


    public String decryptAES(String data, String key)  {
        //key = "7Df05RgSzVm8/wWzUeTDaA==";
        //将Base64编码加密数据和秘钥的格式进行解码转换
        byte[] dataByte = Base64.decode(data);
        byte[] keyByte = Base64.decode(key);
        //解密
        AES aes = SecureUtil.aes(keyByte);        //构建
        byte[] decrypt = aes.decrypt(dataByte);    //加密
        return new String (decrypt);            //转换为字符串返回
    }
}
