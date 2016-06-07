package com.lucio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lucio.dao.AccountDao;
import com.lucio.model.Account;

@Controller
@RequestMapping("/account")
public class AccountController {

	/**
	 * 
	 * @MethodName: add
	 * @Description: 初始化页面请求
	 * @param request
	 * @param response
	 * @throws
	 */
	
	@Autowired
	private AccountDao accountDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@RequestMapping("/addinit")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) {
		
		/*String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.err.println(basePath);*/
		
		return new ModelAndView("/add.jsp");
	}

	/**
	 * 
	 * @MethodName: create
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/addSubmit")
	public ModelAndView create(@ModelAttribute("account")Account account,HttpServletRequest request,
			HttpServletResponse response)
	{
		//AccountDao dao = (AccountDao)ApplicationContextFactory.getInstance().getBean("accountDao");
		accountDao.insertUser(account);
		return new ModelAndView("/success.jsp");
		
	}

	
	@RequestMapping("/query")
	public ModelAndView query(HttpServletRequest request,
			HttpServletResponse response)
	{
		return new ModelAndView("/query.jsp");
	}
	

	@RequestMapping("/showDetail")
	public ModelAndView showDetail(String username,HttpServletRequest request,
			HttpServletResponse response)
	{
		System.out.println("username:"+username);
		Account account = accountDao.getUserByUsername(username);
		return new ModelAndView("/detail.jsp","account", account);
	}

	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute("account")Account account,HttpServletRequest request,
			HttpServletResponse response)
	{
		accountDao.updateByUserName(account);
		
		account = accountDao.getUserByUsername(account.getUsername());
		return new ModelAndView("/detail.jsp","account", account);
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@ModelAttribute("account")Account account,HttpServletRequest request,
			HttpServletResponse response)
	{
		accountDao.deleteByUserName(account);
		
		account = accountDao.getUserByUsername(account.getUsername());
		
		return new ModelAndView("/detail.jsp","account", account);
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		e.printStackTrace();
		request.setAttribute("exception", e);
		return "/error.jsp";
	}
}
