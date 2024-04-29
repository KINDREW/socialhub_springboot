package com.socialhub.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialhub.entity.Post;
import com.socialhub.entity.Comment;
import com.socialhub.services.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PostMapping("/{postId}/like")
    public void likePost(@PathVariable Long postId, @RequestBody Long userId) {
        postService.likePost(postId, userId);
    }

    @PostMapping("/{postId}/comment")
    public void commentOnPost(@PathVariable Long postId, @RequestBody String commentContent, @RequestParam Long userId) {
        postService.commentOnPost(postId, commentContent, userId);
    }

    @GetMapping("/{postId}/likes")
    public List<Long> getAllLikesForPost(@PathVariable Long postId) {
        return postService.getAllLikesForPost(postId);
    }

    @GetMapping("/{postId}/comments")
    public List<Comment> getAllCommentsForPost(@PathVariable Long postId) {
        return postService.getAllCommentsForPost(postId);
    }
}
