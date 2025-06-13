package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmRes;

@SpringBootTest
public class AtmServiceTest {

	@Autowired
	private AtmService atmService;
	
	@Test
	public void addInfoTest() {
		AtmRes res = atmService.addInfo("A01", "AA123");
		System.out.println(res.getRtnCode().getCode());
		System.out.println(res.getRtnCode().getMessage());
		System.out.println(res.getAtm().getAccount());
		System.out.println(res.getAtm().getPassword());
		
	}
	
	@Test
	public void getBalanceByAccountTest() {
		atmService.getBalanceByAccount("A01", "AA123");
	}
}
