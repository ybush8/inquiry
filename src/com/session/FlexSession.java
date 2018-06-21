package com.session;
import flex.messaging.FlexContext;

public class FlexSession {
    /** 
     * ����Session 
     * @param name 
     * @param value 
     */  
    public void setSession(String name,String value){  
        FlexContext.getFlexSession().setAttribute(name,value);  
    }  
     
    /** 
     * ��ȡ Session 
     */  
    public String getSession(String name){  
        String value=(String) FlexContext.getFlexSession().getAttribute(name);  
        return value;  
    }  
    /** 
     * ���Session 
     * @param name 
     */  
    public void removeSession(String name){  
        FlexContext.getFlexSession().removeAttribute(name);  
    }  
}
