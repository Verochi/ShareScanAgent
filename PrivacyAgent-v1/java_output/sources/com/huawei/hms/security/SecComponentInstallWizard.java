package com.huawei.hms.security;

/* loaded from: classes22.dex */
public class SecComponentInstallWizard {
    public static final java.lang.String PROVIDER_NAME = "HmsCore_OpenSSL";

    public interface SecComponentInstallWizardListener {
        void onFailed(int i, android.content.Intent intent);

        void onSuccess();
    }

    public static void install(android.content.Context context) throws com.huawei.hms.api.HuaweiServicesNotAvailableException, com.huawei.hms.api.HuaweiServicesRepairableException {
    }
}
