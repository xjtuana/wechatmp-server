package org.ana.wcmp.util.string;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {
	
	public static String fullToHalf(String raw){
		
		StringBuffer outStrBuf = new StringBuffer("");
		String ctemp = "";
		byte[] b = null;
		
		for (int i = 0; i < raw.length(); i++) {
			 
			ctemp = raw.substring(i,i+1);
			if (ctemp.equals("¡¡")) {
				outStrBuf.append(" ");
				continue;
			}
			
			try {
				b = ctemp.getBytes("unicode");
				if (b[2] == -1) {
					b[3] = (byte) (b[3]+32);
					b[2] = 0;
					outStrBuf.append(new String(b, "unicode"));
				} else {
					outStrBuf.append(ctemp);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		
		return outStrBuf.toString();
	}
	
	public static List<String> tokenizedStringToList(String s, String token){
		if(s==null) return null;
		
		List<String> backList = new ArrayList<String>();
		
		StringTokenizer st = new StringTokenizer(s,token);
		while(st.hasMoreTokens()){
			backList.add(st.nextToken());
		}
		
		return backList;
	}
	
	public static String tokenInitializer(String s,String token){
		if (s==null) return null;
		if(!s.endsWith(token)) s += token;
		s = s.replaceAll("["+token+"]+", token);
		if(s.startsWith(token)) s = s.substring(1);
		return s;
	}
	
}
