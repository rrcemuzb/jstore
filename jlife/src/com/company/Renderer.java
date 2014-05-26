package com.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Renderer {

    @Autowired
    private  Reader reader         ;
    @Autowired
    private  Parser parser;

   /* @Autowired
    public Renderer(Reader rd, Parser pr) {
        reader = rd;
        parser = pr;
    }*/

    public String Render(String viewName) {


        //Reader reader = new Reader();
        //Parser parser = new Parser();

        String tmpl = reader.Read(viewName);
        String html = parser.Parse(tmpl);

        return html;

    }
}
