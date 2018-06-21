package com.session;
import flex.messaging.FlexContext;

public class FlexSession {
    /** 
     * 保存Session 
     * @param name 
     * @param value 
     */  
    public void setSession(String name,String value){  
        FlexContext.getFlexSession().setAttribute(name,value);  
    }  
     
    /** 
     * 获取 Session 
     */  
    public String getSession(String name){  
        String value=(String) FlexContext.getFlexSession().getAttribute(name);  
        return value;  
    }  
    /** 
     * 清除Session 
     * @param name 
     */  
    public void removeSession(String name){  
        FlexContext.getFlexSession().removeAttribute(name);  
    }  
}
