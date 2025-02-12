package com.lalya.SpringJobApp.service;

import com.lalya.SpringJobApp.model.JobPost;
import com.lalya.SpringJobApp.repos.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;
    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public JobPost getJob(int jobId) {
        return jobRepo.getJob(jobId);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.updateJob(jobPost);
    }

    public void deleteJob(int jobId) {
        jobRepo.deleteJob(jobId);
    }
}
