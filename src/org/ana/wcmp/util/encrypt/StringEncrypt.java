package org.ana.wcmp.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * MD5������
 * 
 * @author Godrick
 */
public class StringEncrypt {
	
	private static final char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	private static final String DesKey = "perfect!";
	
	public static final String doEnc(String s, String EncryptedWay) {
		
		try {
            byte[] btInput = s.getBytes();
            // ���ָ���㷨�� MessageDigest ����
            MessageDigest mdInst = MessageDigest.getInstance(EncryptedWay);
            // ʹ��ָ�����ֽڸ���ժҪ
            mdInst.update(btInput);
            // �������
            byte[] md = mdInst.digest();
            
            return toHex(md);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	// ������ת����ʮ�����Ƶ��ַ�����ʽ
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
            throw new RuntimeException("�ַ�������Ϊ�����������Ͻ���������");
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
            throw new RuntimeException("�ַ����а�����16��������");
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
        //����һ���ܳ׹�����Ȼ��������DESKeySpecת����  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey securekey = keyFactory.generateSecret(desKey);  
        //Cipher����ʵ����ɼ��ܲ���  
        Cipher cipher = Cipher.getInstance("DES");  
        //���ܳ׳�ʼ��Cipher����  
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);  
        //���ڣ���ȡ���ݲ�����  
        //��ʽִ�м��ܲ���  
        return cipher.doFinal(datasource);  
        }catch(Throwable e){  
                e.printStackTrace();  
        }  
        return null;  
	}  
	
	private static byte[] decrypt(byte[] src){  
        try{
			// DES�㷨Ҫ����һ�������ε������Դ  
	        SecureRandom random = new SecureRandom();  
	        // ����һ��DESKeySpec����  
	        DESKeySpec desKey = new DESKeySpec(DesKey.getBytes());  
	        // ����һ���ܳ׹���  
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
	        // ��DESKeySpec����ת����SecretKey����  
	        SecretKey securekey = keyFactory.generateSecret(desKey);  
	        // Cipher����ʵ����ɽ��ܲ���  
	        Cipher cipher = Cipher.getInstance("DES");  
	        // ���ܳ׳�ʼ��Cipher����  
	        cipher.init(Cipher.DECRYPT_MODE, securekey, random);  
	        // ������ʼ���ܲ���  
	        return cipher.doFinal(src);  
        } catch(Exception e){
        	e.printStackTrace();
        	return null;
        }
	}  
}
