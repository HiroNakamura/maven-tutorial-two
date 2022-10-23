package com.curso.java.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VerifyData {
    private String name;
	private String status;
	private String timestamp; 
}
