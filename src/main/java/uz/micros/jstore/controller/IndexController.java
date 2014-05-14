package uz.micros.jstore.controller;


import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showIndex(){
      return "<h2>Hello World from Spring  !!! </h2>"+
              "" +
              "<a href=\"home\">HOME</a>";
    };

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    };

}
