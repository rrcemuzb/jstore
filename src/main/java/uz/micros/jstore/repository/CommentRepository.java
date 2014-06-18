package uz.micros.jstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.micros.jstore.entity.blog.Comment;

@Repository
public interface CommentRepository  extends JpaRepository <Comment,Integer>{

}
