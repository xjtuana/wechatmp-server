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
				System.err.println("不能读取属性文件！请确保"+filepath+"存在！");
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

