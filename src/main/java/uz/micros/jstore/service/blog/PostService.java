package uz.micros.jstore.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.blog.Blog;
import uz.micros.jstore.entity.blog.Comment;
import uz.micros.jstore.entity.blog.Post;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private BlogService blogService;

    public Post get(int id) {

        Blog blog = blogService.getBlog();

        for(Post post : blog.getPosts()){
            if(post.getId() == id){

                Comment comment = new Comment();
                comment.setDate(new Date());
                comment.setAuthor("Davron");
                comment.setText("Urtoqlar! Let`s work!!!");

                List<Comment> list = new ArrayList<Comment>();
                list.add(comment);
                list.add(comment);
                list.add(comment);
                list.add(comment);

                post.setComments(new HashSet<>(list));

                return post;
            }
        }

        return null;
    }
}
