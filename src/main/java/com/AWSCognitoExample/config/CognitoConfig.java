package com.AWSCognitoExample.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.CreateUserPoolRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.services.cognitoidentity.CognitoIdentityClient;

@Configuration
public class CognitoConfig {
    @Value(value = "${aws.access-key}")
    private String accessKey;
    @Value(value = "${aws.access-secret}")
    private String secretKey;

    @Bean
    public AWSCognitoIdentityProvider /*CognitoIdentityClient*/ cognitoClient() {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        //AwsCredentialsProvider awsCreds = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));


        return AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion("us-east-1")
                .build();
    }
}