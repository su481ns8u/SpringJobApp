package com.lalya.SpringJobApp.repos;

import com.lalya.SpringJobApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {
    private List<JobPost> jobsList = new ArrayList<>();

    public void addJob(JobPost jobPost) {
        this.jobsList.add(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobsList;
    }
}
