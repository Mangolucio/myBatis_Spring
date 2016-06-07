package com.lucio.mapper;

import com.lucio.model.Account;

public interface AccountMapper {

	void insertUser(Account account);
	Account getUserByUsername(String username);
	void updateByUserName(Account account);
	void deleteByUserName(Account account);
}
