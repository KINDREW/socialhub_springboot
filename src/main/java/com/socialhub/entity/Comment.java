package com.socialhub.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false)
    private String content;

    @Column(name = "user_id")
    private Long userId;

    public Comment() {
        // Default constructor
    }

    public Comment(String content, Long userId) {
        this.content = content;
        this.userId = userId;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getPostId() {
		return postId;
	}


	public void setPostId(Long postId) {
		this.postId = postId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

   
}
