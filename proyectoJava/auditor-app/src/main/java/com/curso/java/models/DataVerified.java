package com.curso.java.models;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DataVerified {
	private ReturnCodes returnCodes;
	private VerifyData verifyData;
	private List<Objeto> lists;
}
