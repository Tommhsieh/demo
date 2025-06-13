package com.example.demo.service.ifs;

import com.example.demo.entity.Atm;
import com.example.demo.vo.AtmRes;


public interface AtmService {
	
	public AtmRes addInfo(String account, String pwd);
	
	public AtmRes getBalanceByAccount(String account, String password);
	
	public AtmRes updatePwd(String account, String oldPwd, String newPwd);

	public AtmRes despoite(String account, String password, int amount);
	
	public AtmRes withdraw(String account, String password, int amount);
	
}
