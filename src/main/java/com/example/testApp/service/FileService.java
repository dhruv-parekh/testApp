package com.example.testApp.service;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.*;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.example.testApp.Repository.AlbumRepository;
import com.example.testApp.Repository.FileRepository;
import com.example.testApp.Repository.PhotoRepository;
import com.example.testApp.models.File;
import com.example.testApp.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public File uploadFile(MultipartFile file) {
        String bucket_name = "dps3-bucket";

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP","9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");

        System.out.format("Uploading file to S3 bucket %s...\n", bucket_name);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            s3.putObject(bucket_name, file.getOriginalFilename(),file.getInputStream(),metadata);

            //save into file databse
            File fileInDb = new File(file.getOriginalFilename(),"album/"+file.getOriginalFilename(),"dhruv@gmail.com");
            fileRepository.save(fileInDb);

            //getting file object out of data
            File fileFromDb = fileRepository.findByFileName(fileInDb.getFileName());
            return fileFromDb;

        } catch (AmazonServiceException | IOException e) {
            System.err.println(e);
            System.exit(1);
            return null;
        }
    }

    public S3Object getFile(String fileId){

        File fileFromDb = fileRepository.findById(fileId).get();


        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP","9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
        return s3.getObject("dps3-bucket",fileFromDb.getFileName());
    }

    public void deleteFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP","9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
        s3.deleteObject("dps3-bucket",key);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
