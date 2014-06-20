package uz.micros.jstore.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.jstore.entity.blog.Comment;
import uz.micros.jstore.entity.blog.Post;
import uz.micros.jstore.service.blog.CommentService;
import uz.micros.jstore.service.blog.PostService;

@Controller
@RequestMapping("blog/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(Comment comment) {

        if (comment.getText() != null && comment.getText().length() > 0){

            commentService.save(comment);}
        return new ModelAndView("redirect:/blog/posts/" + comment.getPost().getId());


    }
}
