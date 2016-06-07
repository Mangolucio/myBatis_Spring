package com.lucio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucio.mapper.AccountMapper;
import com.lucio.model.Account;


@Service
public class AccountDao  {
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Transactional
	public void insertUser(Account account) 
	{
		accountMapper.insertUser(account);
	}

	public Account getUserByUsername(String username) 
	{
		return accountMapper.getUserByUsername(username);
	}
	
	@Transactional
	public void updateByUserName(Account account) 
	{
		accountMapper.updateByUserName(account);
	}
	
	@Transactional
	public void deleteByUserName(Account account) 
	{
		accountMapper.deleteByUserName(account);
	}
	
	public void test(String something){
		System.err.println("AccountDao: "+something);
	}
}
