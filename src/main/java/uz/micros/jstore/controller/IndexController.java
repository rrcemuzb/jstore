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
      return "<h2>Hello World from Spring  !!! </h2>";
    };
    @ResponseBody
    @RequestMapping(value = "/qwerty",method = RequestMethod.GET)

    public String showIndex1(Local local){
        return "<h2>Hello World from Spring111  !!!  </h2>"+local.getType();
    };

}
