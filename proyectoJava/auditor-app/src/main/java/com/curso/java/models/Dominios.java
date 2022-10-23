package com.curso.java.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Dominios {
    private List<String> domains;
    private List<String> webPages;
    private String country;
    private String stateProvidence;
    private String name;
    private String alphaTwoCode;
}
