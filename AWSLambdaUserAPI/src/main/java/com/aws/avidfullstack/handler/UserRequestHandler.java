package com.aws.avidfullstack.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.avidfullstack.service.DynamoDBStorageService;
import com.aws.avidfullstack.service.S3StorageService;
import com.aws.avidfullstack.model.UserRequest;
import com.aws.avidfullstack.model.UserResponse;

public class UserRequestHandler implements RequestHandler<UserRequest, UserResponse> {

    @Override
    public UserResponse handleRequest(UserRequest userRequest, Context context) {

        String responseMessage = "";

        try {
            DynamoDBStorageService.saveUser(userRequest);
            S3StorageService.createUserFile(userRequest);
            responseMessage="Success";
        } catch (Exception exception) {
            responseMessage = "Fail: "+exception.getMessage();
            exception.getStackTrace();
        }

        UserResponse response = new UserResponse(responseMessage);

        return response;
    }
}
