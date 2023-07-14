package com.example.testApp.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.testApp.models.File;
import com.example.testApp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/fileApi/file")
public class FileResource {
    @Autowired
    private FileService fileService;


    @GetMapping("/view/{fileId}")
    public void viewFile(@PathVariable (name="fileId") String fileId, HttpServletResponse response) throws IOException {
        S3Object object =  fileService.getFile(fileId);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }

    @GetMapping("/allFiles")
    public List<File> getAllFiles(){

        return fileService.getAllFiles();
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam(name = "key") String key) throws IOException {
        S3Object object = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\""+key+"\"")
                .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));
    }

    @PostMapping("/upload")
    public File uploadFile(@RequestParam MultipartFile file){
        return fileService.uploadFile(file);
    }

    @DeleteMapping
    public void deleteFile(@RequestParam(name = "key") String key){
        fileService.deleteFile(key);
    }

}
