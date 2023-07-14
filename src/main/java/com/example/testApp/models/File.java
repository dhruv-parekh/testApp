package com.example.testApp.models;

import org.springframework.data.annotation.Id;

public class File {

    @Id
    String fileId;
    String fileName;
    String path;

    String owner;

    public File(String fileName, String path, String owner) {
        this.fileName = fileName;
        this.path = path;
        this.owner = owner;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
