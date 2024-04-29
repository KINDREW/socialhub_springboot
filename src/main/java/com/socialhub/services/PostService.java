package com.socialhub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialhub.entity.Post;
import com.socialhub.entity.Comment;
import com.socialhub.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void likePost(Long postId, Long userId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.getLikedBy().add(userId);
            postRepository.save(post);
        }
    }

    public void commentOnPost(Long postId, String comment, Long userId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.getComments().add(new Comment(comment, userId));
            postRepository.save(post);
        }
    }

    public List<Long> getAllLikesForPost(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            return optionalPost.get().getLikedBy();
        }
        return null; // Or throw an exception if post not found
    }

    public List<Comment> getAllCommentsForPost(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            return optionalPost.get().getComments();
        }
        throw new IllegalArgumentException("Post not found"); 
    }
}
