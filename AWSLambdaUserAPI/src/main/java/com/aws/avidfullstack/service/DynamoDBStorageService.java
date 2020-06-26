package com.aws.avidfullstack.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.aws.avidfullstack.model.UserRequest;

import java.util.HashMap;
import java.util.Map;

public class DynamoDBStorageService {

    private static final AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();

    public static void saveUser(UserRequest userRequest) {
        Map<String, AttributeValue> item = newItem(userRequest);
        PutItemRequest putItemRequest = new PutItemRequest("user", item);
        PutItemResult putItemResult = dynamoDBClient.putItem(putItemRequest);
    }

    private static Map<String, AttributeValue> newItem(UserRequest userRequest) {
        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        item.put("mailid", new AttributeValue(userRequest.getMailId()));
        item.put("name", new AttributeValue(userRequest.getName()));
        item.put("mobilenumber", new AttributeValue(userRequest.getMobileNumber()));
        return item;
    }

}

