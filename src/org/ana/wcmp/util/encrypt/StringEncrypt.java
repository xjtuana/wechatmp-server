package org.ana.wcmp.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * MD5加密类
 * 
 * @author Godrick
 */
public class StringEncrypt {
	
	private static final char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	private static final String DesKey = "perfect!";
	
	public static final String doEnc(String s, String EncryptedWay) {
		
		try {
            byte[] btInput = s.getBytes();
            // 获得指定算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance(EncryptedWay);
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            
            return toHex(md);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	// 把密文转换成十六进制的字符串形式
	private static String toHex(byte[] b){
		int j = b.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = b[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
	}
	
	private static byte[] decodeHex(String datac) {
		char[] data = datac.toCharArray();
        int len = data.length;
        if ((len & 0x01) != 0) {
            throw new RuntimeException("字符串长度为奇数，不符合解码条件！");
        }
        byte[] out = new byte[len >> 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }
	
	protected static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("字符串中包含非16进制数！");
        }
        return digit;
    }
	
	public static String encStringByDes(String content, String charset){
		try {
			byte[] conbyte = content.getBytes(charset);
			return toHex(desCrypto(conbyte));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String decStringByDes(String encrypted, String charset){
		try {
			byte[] encedbyte = decodeHex(encrypted);
			return new String(decrypt(encedbyte),charset);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static byte[] desCrypto(byte[] datasource) {              
        try{  
        SecureRandom random = new SecureRandom();  
        DESKeySpec desKey = new DESKeySpec(DesKey.getBytes());  
        //创建一个密匙工厂，然后用它把DESKeySpec转换成  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey securekey = keyFactory.generateSecret(desKey);  
        //Cipher对象实际完成加密操作  
        Cipher cipher = Cipher.getInstance("DES");  
        //用密匙初始化Cipher对象  
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);  
        //现在，获取数据并加密  
        //正式执行加密操作  
        return cipher.doFinal(datasource);  
        }catch(Throwable e){  
                e.printStackTrace();  
        }  
        return null;  
	}  
	
	private static byte[] decrypt(byte[] src){  
        try{
			// DES算法要求有一个可信任的随机数源  
	        SecureRandom random = new SecureRandom();  
	        // 创建一个DESKeySpec对象  
	        DESKeySpec desKey = new DESKeySpec(DesKey.getBytes());  
	        // 创建一个密匙工厂  
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
	        // 将DESKeySpec对象转换成SecretKey对象  
	        SecretKey securekey = keyFactory.generateSecret(desKey);  
	        // Cipher对象实际完成解密操作  
	        Cipher cipher = Cipher.getInstance("DES");  
	        // 用密匙初始化Cipher对象  
	        cipher.init(Cipher.DECRYPT_MODE, securekey, random);  
	        // 真正开始解密操作  
	        return cipher.doFinal(src);  
        } catch(Exception e){
        	e.printStackTrace();
        	return null;
        }
	}  
}
