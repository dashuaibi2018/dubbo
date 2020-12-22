package com.mashibing.springboot.service;

import com.github.pagehelper.PageInfo;
import com.mashibing.springboot.entity.Account;
import com.mashibing.springboot.entity.RespStat;

import java.util.List;

public interface IAccountService {

	Account findByLoginNameAndPassword(String loginName, String password);

	List<Account> findAll();

	PageInfo<Account> findByPage(int pageNum, int pageSize);

	RespStat deleteById(int id);

	void update(Account account);

}