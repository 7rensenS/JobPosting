package com.example.jobposting.service;

import com.example.jobposting.model.JobPosting;
import com.example.jobposting.repository.JobPostingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JobPostingServiceTests {

    @Autowired
    private JobPostingService jobPostingService;

    @MockBean
    private JobPostingRepository jobPostingRepository;

    @Test
    public void testCreateJobPosting() {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setTitle("Software Engineer");

        Mockito.when(jobPostingRepository.save(jobPosting)).thenReturn(jobPosting);

        assertEquals(jobPosting, jobPostingService.createJobPosting(jobPosting));
    }

    @Test
    public void testGetJobPostingById() {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setId(1L);

        Mockito.when(jobPostingRepository.findById(1L)).thenReturn(Optional.of(jobPosting));

        assertTrue(jobPostingService.getJobPostingById(1L).isPresent());
    }
}
