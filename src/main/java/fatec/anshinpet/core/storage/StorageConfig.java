package fatec.anshinpet.core.storage;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${r2.credentials.access-key}")
    private String accessKey;

    @Value("${r2.credentials.secret-key}")
    private String secretKey;

    @Value("${r2.endpoint}")
    private String endpoint;

    @Value("${r2.region}")
    private String region;

    @Bean
    public AmazonS3 amazonS3() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AwsClientBuilder.EndpointConfiguration endpointConfiguration =
                new AwsClientBuilder.EndpointConfiguration(endpoint, region);

        return AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfiguration)
                .withPathStyleAccessEnabled(true)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
