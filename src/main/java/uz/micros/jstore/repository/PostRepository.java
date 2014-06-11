package uz.micros.jstore.repository;


import org.springframework.stereotype.Repository;
import uz.micros.jstore.entity.blog.Post;
import uz.micros.jstore.util.DbManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {
    private class PostMapper extends Mapper <Post>{};

    public void addPost(Post post) {

    }

    public Post getPost(int id) {
        return null;
    }

    public void savePost(Post post) {

    }

    public void deletePost(int id) {

    }

    public List<Post> getPosts() {
        List<Post> res = new ArrayList<>();

        List<Map<String, Object>> list = DbManager.runQuery("select * from posts");
        for(Map<String,Object> item: list){

            /*Post p = new Post();
            p.setId((Integer)item.get("id"));
            p.setDate((Date)item.get("date"));
            p.setSubject((String)item.get("subject"));
            p.setText((String)item.get("text"));*/

            Post p =new PostMapper().map(item);


            res.add(p);
        }

        return res;
    }
}
