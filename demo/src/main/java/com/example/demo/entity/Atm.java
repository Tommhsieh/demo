package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "atm")
public class Atm {
	
	@Id
	@Column(name = "account")
	private String account;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "balance")
	private int balance;
	
	public Atm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Atm(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public Atm(String account, String password, int balance) {
		super();
		this.account = account;
		this.password = password;
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
