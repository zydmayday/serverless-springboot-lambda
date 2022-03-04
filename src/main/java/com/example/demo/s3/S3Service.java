package com.example.demo.s3;

import org.springframework.beans.factory.annotation.Autowired;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.nio.file.Path;

public class S3Service {

    @Autowired
    private S3Client s3Client;

    public PutObjectResponse upload(String bucket, String key, Path path) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                                                            .bucket(bucket)
                                                            .key(key).build();
        return s3Client.putObject(putObjectRequest, RequestBody.fromFile(path));
    }
}
