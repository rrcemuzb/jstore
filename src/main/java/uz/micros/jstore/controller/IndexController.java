package uz.micros.jstore.controller;


import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.jstore.enity.Author;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "<h2>Hello World from Spring  !!! </h2>" +
                "" +
                "<a href=\"home\">HOME</a>";
    }

    ;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {


        Author a = new Author();
        a.setName("Hamza");

        List<Author> list;

        if (session.getAttribute("authors") == null) {
            list = new ArrayList<Author>();
            list.add(a);
            list.add(a);
            list.add(a);
            session.setAttribute("authors", list);
        } else {
            list = (List<Author>) session.getAttribute("authors");
        }

        return new ModelAndView("home")
                .addObject("name", "UZB")
                .addObject("author", a)
                .addObject("authors", list)
                .addObject("newauthor",new Author());
    }

    ;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam String title,HttpSession session) {
        List<Author> list = (List<Author>) session.getAttribute("authors");

        Author a = new Author();
        a.setName(title);

        list.add(a);
        return "redirect:/home";
    }

    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public String save2(@ModelAttribute Author newauthor,HttpSession session) {
    List<Author> list = (List<Author>) session.getAttribute("authors");

        list.add(newauthor);
        return "redirect:/home";
    }

}
