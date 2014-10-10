package org.ana.wcmp.database.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Blob;

public class BlobProcessor {
	
	private Blob unhandled_blob;
	
	public BlobProcessor(){
		
	}
	
	public BlobProcessor(Blob unhandled_blob){
		this.unhandled_blob = unhandled_blob;
	}
	
	/** ת��blob����String
	 * @author лĽ��  2014-08-01
	 * @param Blob b - ��Ҫ�����blob����
	 * */
	public String blobToStr(String charset){
		if (this.unhandled_blob == null) return null;

		String thischarset = charset != null ? charset : "utf-8";
		StringBuffer bloboutput = new StringBuffer("");
		try {
			String temp;
			BufferedReader inb = new BufferedReader(new InputStreamReader(this.unhandled_blob.getBinaryStream(),thischarset));
			while ((temp=inb.readLine()) != null){
				bloboutput.append(temp);
			}
			inb.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return bloboutput.toString();
	}
	
	public String blobToStr(){
		if (this.unhandled_blob == null) return null;

		StringBuffer bloboutput = new StringBuffer("");
		try {
			String temp;
			BufferedReader inb = new BufferedReader(new InputStreamReader(this.unhandled_blob.getBinaryStream(),"utf-8"));
			while ((temp=inb.readLine()) != null){
				bloboutput.append(temp);
			}
			inb.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return bloboutput.toString();
	}

	public Blob getUnhandled_blob() {
		return unhandled_blob;
	}

	public void setUnhandled_blob(Blob unhandled_blob) {
		this.unhandled_blob = unhandled_blob;
	}
}
