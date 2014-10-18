package org.ana.wcmp.util.loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	public Properties getProperties(String filepath){
			InputStream fileinputstream = null;
			try {
				fileinputstream = new FileInputStream(filepath);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			Properties props = new Properties();
			try {
				props.load(fileinputstream);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("���ܶ�ȡ�����ļ�����ȷ��"+filepath+"���ڣ�");
			} finally {
				if (fileinputstream != null) {
					try {
						fileinputstream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return props;
		}
	
}

