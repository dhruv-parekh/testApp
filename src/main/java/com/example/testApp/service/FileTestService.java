package com.example.testApp.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileTestService {
    public boolean uploadTestFile(MultipartFile file) {

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP", "9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            s3.putObject("dps3-bucket", file.getOriginalFilename(), file.getInputStream(), metadata);
            return true;

        } catch (AmazonServiceException | IOException e) {
            System.err.println(e);
            return false;
        }
    }

    public S3Object getTestFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP", "9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
        return s3.getObject("dps3-bucket",key);
    }

    public void deleteTestFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIA6KUNXMVTCGQOT2BP", "9NSS88F9b2sT3/Mg6CRq/xKW4pdLtJmP91jaGxhJ");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2).build();
         s3.deleteObject("dps3-bucket",key);
    }
}
