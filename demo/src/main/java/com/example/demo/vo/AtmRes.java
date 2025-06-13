package com.example.demo.vo;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

public class AtmRes {

	private Atm atm;

	private RtnCode rtnCode;

	public AtmRes() {
		super();
	}

	public AtmRes(Atm atm, RtnCode rtnCode) {
		super();
		this.atm = atm;
		this.rtnCode = rtnCode;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}

}
