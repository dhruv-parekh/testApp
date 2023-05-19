package com.example.testApp.service;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.*;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    public boolean uploadFile(MultipartFile file) {
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
            return true;
        } catch (AmazonServiceException | IOException e) {
            System.err.println(e);
            System.exit(1);
            return false;
        }
    }

    public S3Object getFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP","9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
        return s3.getObject("dps3-bucket",key);
    }

    public void deleteFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP","9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
        s3.deleteObject("dps3-bucket",key);
    }
}
