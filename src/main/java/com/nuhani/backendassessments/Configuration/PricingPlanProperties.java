package com.nuhani.backendassessments.Configuration;

import com.nuhani.backendassessments.Model.PlanProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pricing.plan")
public class PricingPlanProperties {

    private PlanProperties free;
    private PlanProperties basic;
    private PlanProperties premium;

    // getters and setters

    public PlanProperties getFree() {
        return free;
    }

    public void setFree(PlanProperties free) {
        this.free = free;
    }

    public PlanProperties getBasic() {
        return basic;
    }

    public void setBasic(PlanProperties basic) {
        this.basic = basic;
    }

    public PlanProperties getPremium() {
        return premium;
    }

    public void setPremium(PlanProperties premium) {
        this.premium = premium;
    }
}
