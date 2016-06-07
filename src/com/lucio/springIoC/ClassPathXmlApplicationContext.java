package com.lucio.springIoC;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.context.ApplicationContext;

import com.lucio.controller.AccountController;

public class ClassPathXmlApplicationContext implements BeanFactory{

	private Map<String, Object> beans = new HashMap<String, Object>();
	
	public static void main (String[] args) throws Exception{
		new ClassPathXmlApplicationContext();
	}
	
	public ClassPathXmlApplicationContext() throws Exception {
		
		/*<bean id = "accountController" calss = "com.lucio.controller.AccountController">
			<property name = "accountDao" bean = "ad"/>
		</bean>
	
		<bean id = "ad" class = "com.lucio.dao.AccountDao"/>*/
	
		SAXBuilder sb = new SAXBuilder();
		
		/*
		 *  create and configure beans
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});
		 *  retrieve configured instance
		PetStoreService service = context.getBean("petStore", PetStoreService.class);
		 *  use configured instance
		List<String> userList = service.getUsernameList();
		*/
		
		Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		Element root = doc.getRootElement();
		List list = root.getChildren("bean");
		
		for(int i = 0; i < list.size(); i++){
			Element element = (Element) list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id + ":" + clazz);
			
			Object o;
			
			if(clazz.indexOf("AccountController") > -1){
				o = (AccountController) Class.forName(clazz).newInstance();
			}else{
				o = Class.forName(clazz).newInstance();
			}
			
			beans.put(id, o);
			
			for(Element propertyElement : (List<Element>)element.getChildren("property")){
				String name = propertyElement.getAttributeValue("name");
				String bean = propertyElement.getAttributeValue("bean");
				Object beanObject = beans.get(bean);
				
				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				System.out.println("method name = :" + methodName);
				
				Method m = o.getClass().getMethod(methodName, beanObject.getClass());
				m.invoke(o, beanObject);
			}
			
			if(o instanceof AccountController){
				((AccountController) o).getAccountDao().test("Come on!");
			}
			
		}
		
		
	}
	
	
	
	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}

}
