package com.paudyal.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	
	public void addAccount() {
		System.out.println(getClass() + ": Doing my db work: Adding a membership ");
	}
}
