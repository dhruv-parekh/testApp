package com.example.testApp.models;

import com.example.testApp.Validation.ValidCreatedBy;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;

public class Album {

    private int albumId;

    @Length(max = 10)
    private String name;
    private String description;
    private String coverPicUrl;

    @ValidCreatedBy
    private String createdBy;

    private String dateCreated;


    public Album(String name, String description, String coverPicUrl, String createdBy, String dateCreated) {
        this.name = name;
        this.description = description;
        this.coverPicUrl = coverPicUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}