package com.nuhani.backendassessments.Service;

import com.nuhani.backendassessments.Configuration.RateLimitProperties;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimiterService {

    private final Bucket bucket;

    @Autowired
    public RateLimiterService(RateLimitProperties rateLimitProperties) {
        Bandwidth limit = Bandwidth.classic(
                rateLimitProperties.getRequestsPerSecond(),
                Refill.intervally(rateLimitProperties.getRequestsPerSecond(), Duration.ofSeconds(1))
        );
        this.bucket = Bucket4j.builder().addLimit(limit).build();
    }

    public boolean tryConsume() {
        return bucket.tryConsume(1);
    }
}

