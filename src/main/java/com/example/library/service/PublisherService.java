package com.example.library.service;

import com.example.library.dto.publisher.request.CreatePublisherRequest;
import com.example.library.dto.publisher.response.CreatedPublisherResponse;
import com.example.library.entity.Publisher;
import com.example.library.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public CreatedPublisherResponse add(CreatePublisherRequest request){

        Publisher publisher = new Publisher();
        publisher.setPublisherName(request.getPublisherName());
        publisher.setPublisherLogoUrl(request.getPublisherLogoUrl());

        publisherRepository.save(publisher);

        return new CreatedPublisherResponse(
                publisher.getId(),
                publisher.getPublisherName(),
                publisher.getPublisherLogoUrl()
        );
    }
}
