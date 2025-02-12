package com.lalya.SpringJobApp.repos;

import com.lalya.SpringJobApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class JobRepo {
    private List<JobPost> jobsList = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Full Stack Java", 3, "Java Dev", Arrays.asList("Java", "Spring")),
            new JobPost(2, "Full Stack Web", 5, "React Dev", Arrays.asList("JS", "React")),
            new JobPost(3, "Full Stack iOS", 6, "Swift Dev", Arrays.asList("Swift"))
    ));

    public void addJob(JobPost jobPost) {
        this.jobsList.add(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobsList;
    }

    public JobPost getJob(int jobId) {
        return getJobById(jobId);
    }

    public void updateJob(JobPost updateJobPost) {
        JobPost updatedJobPost = getJobById(updateJobPost.getPostId());
        updatedJobPost.setPostDesc(updateJobPost.getPostDesc());
        updatedJobPost.setPostProfile(updateJobPost.getPostProfile());
        updatedJobPost.setPostTechStack(updateJobPost.getPostTechStack());
        updatedJobPost.setReqExperience(updateJobPost.getReqExperience());
    }

    public void deleteJob(int jobId) {
        jobsList.remove(getJobById(jobId));
    }

    public JobPost getJobById(int jobId) {
        return jobsList.stream()
                .filter(jobPost -> jobPost.getPostId() == jobId)
                .findFirst()
                .orElse(new JobPost(0, "No job", 0, "na", new ArrayList<>()));
    }
}
