package uz.micros.jstore.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.micros.jstore.entity.blog.Blog;
import uz.micros.jstore.entity.blog.Post;

@Service
public class PostService {

    @Autowired
    private BlogService blogSrv;


    public Post get(int id) {

        Blog blog = blogSrv.getBlog();

        for(Post post: blog.getPosts()){
            if(post.getId()==id){
                return post;
            }
        }

        return null;
    }
}
