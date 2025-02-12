package com.lalya.SpringJobApp.controller;

import com.lalya.SpringJobApp.model.JobPost;
import com.lalya.SpringJobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return jobService.getJob(postId);
    }

    @PostMapping("jobPost")
    public String addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return "added job: " + jobPost.getPostId();
    }

    @PutMapping("jobPost")
    public String updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return "updated job: " + jobPost.getPostId();
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int jobId) {
        jobService.deleteJob(jobId);
        return "Deleted job: " + jobId;
    }
}
