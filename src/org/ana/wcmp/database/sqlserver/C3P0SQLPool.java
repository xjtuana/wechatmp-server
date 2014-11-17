package org.ana.wcmp.database.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.ana.wcmp.context.ServerContext;
import org.ana.wcmp.util.loader.PropertiesLoader;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class C3P0SQLPool {
	
	private static ComboPooledDataSource cpds = null; 
    
    private static C3P0SQLPool instance = null;
    
    protected C3P0SQLPool() {
    }
    
    static  
    {  
        try  
        {  
            Properties dbProperties = new PropertiesLoader().getProperties(ServerContext.SERVERBASE_PATH+"/org/ana/wcmp/database/sqlserver/SQLServerConf.properties");  
              
            cpds = new ComboPooledDataSource();  
            cpds.setDriverClass(dbProperties.getProperty("DriverName"));  
            cpds.setJdbcUrl(dbProperties.getProperty("DatabaseURL"));  
            cpds.setUser(dbProperties.getProperty("UserName"));  
            cpds.setPassword(dbProperties.getProperty("UserPassword"));  
              
            cpds.setInitialPoolSize(Integer.parseInt(dbProperties.getProperty("PoolInitSize")));  
            cpds.setMinPoolSize(Integer.parseInt(dbProperties.getProperty("PoolMinSize")));  
            cpds.setAcquireIncrement(Integer.parseInt(dbProperties.getProperty("PoolAcquireIncrement")));  
            cpds.setMaxPoolSize(Integer.parseInt(dbProperties.getProperty("PoolMaxSize")));  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            System.err.println("SQL Server配置文件错误！请确认。");
        }  
    }
    
    public static synchronized C3P0SQLPool getInstance()  
    {  
        if(instance == null)  
        {  
            instance = new C3P0SQLPool();  
        }  
        return instance;  
    }  
      
    public synchronized void close()  
    {  
        try  
        {  
            DataSources.destroy(cpds);  
        }  
        catch (SQLException e)  
        {  
            e.printStackTrace();  
        }  
    }
    
	public synchronized ResultSet executeQuery(String sql, HashMap<String,Object> params)  
    {  
        Connection conn = null;  
        PreparedStatement st = null;  
        ResultSet rs = null; 
        try  
        {  
            HashMap<Integer,Object> orderedparams = new HashMap<Integer,Object>();
            int counter = 0;
            for (int i = 0; i < sql.length() - 1; i++) {
                if (sql.substring(i, i + 2).equalsIgnoreCase(":V")) {
                    counter++;
                }
            }
            if (counter != params.size()){
            	return null;
            }
            Set<String> keyset = params.keySet();
            for (Iterator<String> i = keyset.iterator(); i.hasNext();){
            	String tempVal = i.next();
            	if (!sql.contains(":V"+tempVal.toUpperCase())){
            		return null;
            	}
            	String before = sql.split(":V"+tempVal)[0];
            	if (before.contains(":V"+tempVal.toUpperCase())) return null;
            	int subcounter = 1;
                for (int ii = 0; ii < before.length() - 1; ii++) {
                    if (before.substring(ii, ii + 2).equalsIgnoreCase(":V")) {
                        subcounter++;
                    }
                }
                orderedparams.put(subcounter, params.get(tempVal));
                sql = sql.replace(":V"+tempVal.toUpperCase(), "?");
            }
            System.out.println(sql);
            conn = cpds.getConnection();  
            st = conn.prepareStatement(sql,  
                    ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_READ_ONLY); 
            Set<Integer> orderedkey = orderedparams.keySet();
            for (Iterator<Integer> i = orderedkey.iterator(); i.hasNext();){
            	int temporder = i.next();
            	st.setObject(temporder, orderedparams.get(temporder));
            }
            rs = st.executeQuery(); 
        }  
        catch (SQLException e)  
        {  
            e.printStackTrace();  
        }  
        return rs;  
    } 
}
