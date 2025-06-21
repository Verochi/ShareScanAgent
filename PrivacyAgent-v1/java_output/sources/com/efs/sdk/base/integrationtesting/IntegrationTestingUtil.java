package com.efs.sdk.base.integrationtesting;

/* loaded from: classes22.dex */
public class IntegrationTestingUtil {
    private static boolean sIsInPeriod;

    public static boolean isIntegrationTestingInPeriod() {
        return sIsInPeriod;
    }

    public static void setIntegrationTestingInPeriod(boolean z) {
        sIsInPeriod = z;
    }
}
