package com.lucio.dynamicProxy;

public class BookFacadeImpl implements BookFacade {

	@Override  
    public void addBook(String name) {  
        System.out.println("增加图书。。。" + name);  
    }  
}
