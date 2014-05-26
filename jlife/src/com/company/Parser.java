package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parser {


    public String Parse(String tmpl) {
            return tmpl.replace("$[x]","Hello!!!");
    }
}
