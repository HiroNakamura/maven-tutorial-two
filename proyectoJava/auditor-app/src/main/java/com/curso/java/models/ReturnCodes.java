package com.curso.java.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReturnCodes {
    private String returnCode;
	private String name;
	private String status;
}
