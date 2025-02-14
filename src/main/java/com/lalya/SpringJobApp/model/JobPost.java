package com.lalya.SpringJobApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postDesc;
    private int reqExperience;
    private String postProfile;
    private List<String> postTechStack;

    @Override
    public String toString() {
        return "JobPost{" +
                "postId=" + postId +
                ", postDesc='" + postDesc + '\'' +
                ", reqExperience=" + reqExperience +
                ", postProfile='" + postProfile + '\'' +
                ", postTechStack=" + postTechStack +
                '}';
    }

    public JobPost() {
    }

    public JobPost(int postId, String postDesc, int reqExperience, String postProfile, List<String> postTechStack) {
        this.postId = postId;
        this.postDesc = postDesc;
        this.reqExperience = reqExperience;
        this.postProfile = postProfile;
        this.postTechStack = postTechStack;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public int getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(int reqExperience) {
        this.reqExperience = reqExperience;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }
}
