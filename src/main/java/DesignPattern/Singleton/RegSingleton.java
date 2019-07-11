package DesignPattern.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegSingleton {
    private final static Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);
    //静态块，在类被加载时自动执行
    static{
        RegSingleton rs=new RegSingleton();
        singletonObjects.put(rs.getClass().getName(), rs);
    }
    private RegSingleton(){}
    public static RegSingleton getInstance(String name){
        if(name==null){
            name= "RegSingleton";
        }
        if(singletonObjects.get(name)==null){
            try{
                singletonObjects.put(name,Class.forName(name).newInstance());
            }catch(Exception ex){ex.printStackTrace();}
        }
        return (RegSingleton)singletonObjects.get(name);
    }
}
