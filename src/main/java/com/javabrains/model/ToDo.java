package com.javabrains.model;

import lombok.Data;

@Data
public class ToDo {

	private String task;
	private String completeItBy;
	private boolean idDone;

}
