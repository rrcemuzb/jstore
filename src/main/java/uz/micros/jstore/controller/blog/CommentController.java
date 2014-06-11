package uz.micros.jstore.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("blog/comments")
public class CommentController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(){

        return new ModelAndView("redirect:/blog/posts/100");
    }
}
