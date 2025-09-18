package com.example.library.controller;

import com.example.library.dto.publisher.request.CreatePublisherRequest;
import com.example.library.dto.publisher.response.CreatedPublisherResponse;
import com.example.library.service.PublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping()
    public CreatedPublisherResponse add(@RequestBody CreatePublisherRequest request){
        return publisherService.add(request);
    }

}
