package com.lalya.SpringJobApp.controller;

import com.lalya.SpringJobApp.model.JobPost;
import com.lalya.SpringJobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    JobService jobService;
    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @RequestMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model) {
        List<JobPost> jobPosts = jobService.getAllJobs();
        jobPosts.forEach(System.out::println);
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }
}
