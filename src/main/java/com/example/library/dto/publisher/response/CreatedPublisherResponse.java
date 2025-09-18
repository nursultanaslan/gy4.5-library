package com.example.library.dto.publisher.response;

public class CreatedPublisherResponse {
    private Integer id;
    private String publisherName;
    private String publisherLogoUrl;

    public CreatedPublisherResponse() {
    }

    public CreatedPublisherResponse(Integer id, String publisherName, String publisherLogoUrl) {
        this.id = id;
        this.publisherName = publisherName;
        this.publisherLogoUrl = publisherLogoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
