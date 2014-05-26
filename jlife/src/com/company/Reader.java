package com.company;

import org.springframework.stereotype.Component;

@Component
public class Reader {


    public String Read(String viewName) {
        return "<h2>$[x]</h2>";
    }
}
