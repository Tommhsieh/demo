package com.example.demo.servcie.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmRes;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmDao atmDao;

	@Override
	public AtmRes addInfo(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		if (atmDao.existsById(account)) {
			return new AtmRes(null, RtnCode.ACCOUNT_EXISTED);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd)));
		// 不回傳password
		res.setPassword("");
		return new AtmRes(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmRes updatePwd(String account, String oldPwd, String newPwd) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account); //檢查ID是否存在於DB
		Atm res = op.get();
		if (op.isEmpty()) {
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(!encoder.matches(oldPwd, res.getPassword())) {
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setPassword(encoder.encode(newPwd));
		atmDao.save(res);
		res.setPassword("");
		return new AtmRes(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmRes getBalanceByAccount(String account, String password) {
		if (!StringUtils.hasText(account)) {
			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		Atm res = op.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(password, res.getPassword())) {
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setPassword("");
		return new AtmRes(res, RtnCode.SUCCESSFUL);

	}

	@Override
	public AtmRes despoite(String account, String password, int amount) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(password) || amount <= 0) {
			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account); //檢查ID是否存在於DB
		Atm res = op.get();
		if (op.isEmpty()) {
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(!encoder.matches(password, res.getPassword())) {
			return new AtmRes(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setBalance(res.getBalance() + amount);
		atmDao.save(res);
		return new AtmRes(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmRes withdraw(String account, String password, int amount) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(password) || amount <= -1) {
			return new AtmRes(null, RtnCode.PARAM_ERROR);
		}		
		return null;
	}

}
