package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class ConditionTest {
	
	@Test
	public void  ifTest(){
		int a = 5;
		if(a < 7) {
			System.out.println("=====");
		}
	}
	
	
}
