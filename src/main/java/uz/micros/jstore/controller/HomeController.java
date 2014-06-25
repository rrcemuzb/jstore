package uz.micros.jstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.jstore.service.store.GenreService;


@Controller
public class HomeController {

    @Autowired
    private GenreService genreService;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home")
                .addObject("genres",genreService.getAll())
             ;
    }
}