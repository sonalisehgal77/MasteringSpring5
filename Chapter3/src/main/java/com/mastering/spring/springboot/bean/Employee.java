package com.mastering.spring.springboot.bean;

import java.util.Date;

public class Employee {
	private int id;
	private String user;
	private String desc;
	private Date targetDate;
	private boolean isDone;

	public Employee() {
	}

	public Employee(int id, String user, String desc, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getDesc() {
		return desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

}