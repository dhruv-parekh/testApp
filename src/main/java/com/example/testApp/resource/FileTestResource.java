package com.example.testApp.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.testApp.service.FileTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/fileTestApi/files")
public class FileTestResource {
    @Autowired
    private FileTestService fileTestService;

    @PostMapping
    public boolean uploadTestFile(@RequestParam(name = "file")MultipartFile file){
        return fileTestService.uploadTestFile(file);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam(name = "key") String key) throws IOException {
        S3Object object = fileTestService.getTestFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\""+key+"\"")
                .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));
    }

    @GetMapping("/view")
    public void viewFile(@RequestParam(name = "key") String key, HttpServletResponse response) throws IOException {
        S3Object object = fileTestService.getTestFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());

    }

    @DeleteMapping
    public void deleteTestFile(@RequestParam(name = "key") String key){
        fileTestService.deleteTestFile(key);
    }



}
