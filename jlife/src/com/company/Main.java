package com.company;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

       // Renderer renderer = new Renderer(new Reader(), new Parser());

        Renderer renderer = (Renderer)ctx.getBean("thymeleaf");

        //Renderer renderer = ctx.getBean(Renderer.class);

        String html = renderer.Render("home");
        System.out.println(html);

    }
}
