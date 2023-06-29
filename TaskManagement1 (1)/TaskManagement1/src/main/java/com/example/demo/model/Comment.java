package com.example.demo.model;

public class Comment {
	
	private long commentId;
    private String description;
    private long taskId;
    
    public long getCommentId() {
        return commentId;
    }

    public String getDescription() {
        return description;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

}
