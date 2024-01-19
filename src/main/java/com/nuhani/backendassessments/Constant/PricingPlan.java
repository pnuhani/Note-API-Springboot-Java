package com.nuhani.backendassessments.Constant;

import com.nuhani.backendassessments.Configuration.PricingPlanProperties;
import com.nuhani.backendassessments.Model.PlanProperties;

public enum PricingPlan {
    FREE,
    BASIC,
    PREMIUM;

    private static PricingPlanProperties pricingPlanProperties;

    public static void setPricingPlanProperties(PricingPlanProperties properties) {
        pricingPlanProperties = properties;
    }

    public int getMaxRequestsPerMonth() {
        PlanProperties planProperties = getPlanProperties(this);
        return planProperties.getRequestsPerMonth();
    }

    private PlanProperties getPlanProperties(PricingPlan plan) {
        switch (plan) {
            case FREE:
                return pricingPlanProperties.getFree();
            case BASIC:
                return pricingPlanProperties.getBasic();
            case PREMIUM:
                return pricingPlanProperties.getPremium();
            default:
                throw new IllegalArgumentException("Unsupported plan: " + plan);
        }
    }
}
