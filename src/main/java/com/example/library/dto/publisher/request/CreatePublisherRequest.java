package com.example.library.dto.publisher.request;

public class CreatePublisherRequest {

    private String publisherName;
    private String publisherLogoUrl;

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherLogoUrl() {
        return publisherLogoUrl;
    }

    public void setPublisherLogoUrl(String publisherLogoUrl) {
        this.publisherLogoUrl = publisherLogoUrl;
    }
}
