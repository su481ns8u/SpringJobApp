package com.lalya.SpringJobApp.service;

import com.lalya.SpringJobApp.model.JobPost;
import com.lalya.SpringJobApp.repos.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    private List<JobPost> jobsList = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Full Stack Java", 3, "Java Dev", Arrays.asList("Java", "Spring")),
            new JobPost(2, "Full Stack Web", 5, "React Dev", Arrays.asList("JS", "React")),
            new JobPost(3, "Full Stack iOS", 6, "Swift Dev", Arrays.asList("Swift"))
    ));
    @Autowired
    JobRepo jobRepo;
    public void addJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    public JobPost getJob(int jobId) {
        return jobRepo.findById(jobId).orElse(new JobPost(0, "No job", 0, "na", new ArrayList<>()));
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public void deleteJob(int jobId) {
        jobRepo.deleteById(jobId);
    }

    public void load() {
        jobRepo.saveAll(jobsList);
    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
