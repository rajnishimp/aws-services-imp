package com.aws.avidfullstack.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.aws.avidfullstack.model.UserRequest;

public class S3StorageService {

  private final static AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();

    public static void createUserFile(UserRequest userRequest) {

        String BucketName = "userrawdataintake";
        String UserFileName = "user.txt";

        try {
            // can use logger api
            System.out.println("save the user object into bucket");

            if (s3client.doesBucketExistV2(BucketName)) {
                System.out.println("bucket exist");
                if (s3client.doesObjectExist(BucketName, UserFileName)) {
                    System.out.println("file object exist");
                    String userFileContent = s3client.getObjectAsString(BucketName, UserFileName);
                    s3client.putObject(BucketName, UserFileName, userFileContent + userRequest.toLine());

                } else {
                    System.out.println("file object not exist");
                    s3client.putObject(BucketName, UserFileName, userRequest.toLine());
                    System.out.println("file object created");

                }
            } else {
                System.out.println("bucket not exist");
                Bucket bucket = s3client.createBucket(BucketName);
                s3client.putObject(BucketName, UserFileName, userRequest.toLine());
                System.out.println("bucket and file object created");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
