package com.lucio.staticProxy;

public class TestCount {
	    public static void main(String[] args) {  
	        CountImpl countImpl = new CountImpl();  
	        CountProxy countProxy = new CountProxy(countImpl); 
	        
	        countProxy.updateCount();
	        
	        System.out.println("---------------");
	        countProxy.queryCount();  
	  
	    }  
}
