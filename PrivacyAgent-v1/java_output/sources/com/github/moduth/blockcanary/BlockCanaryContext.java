package com.github.moduth.blockcanary;

/* loaded from: classes22.dex */
public class BlockCanaryContext {
    public static android.content.Context a;
    public static com.github.moduth.blockcanary.BlockCanaryContext b;

    public static void a(android.content.Context context, com.github.moduth.blockcanary.BlockCanaryContext blockCanaryContext) {
        a = context;
        b = blockCanaryContext;
    }

    public static com.github.moduth.blockcanary.BlockCanaryContext get() {
        com.github.moduth.blockcanary.BlockCanaryContext blockCanaryContext = b;
        if (blockCanaryContext != null) {
            return blockCanaryContext;
        }
        throw new java.lang.RuntimeException("BlockCanaryContext not init");
    }

    public java.util.List<java.lang.String> concernPackages() {
        return null;
    }

    public boolean deleteFilesInWhiteList() {
        return false;
    }

    public boolean displayNotification() {
        return false;
    }

    public boolean filterNonConcernStack() {
        return false;
    }

    public void onBlock(android.content.Context context, com.github.moduth.blockcanary.internal.BlockInfo blockInfo) {
    }

    public int provideBlockThreshold() {
        return 1000;
    }

    public android.content.Context provideContext() {
        return a;
    }

    public int provideDumpInterval() {
        return provideBlockThreshold();
    }

    public int provideMonitorDuration() {
        return 99999;
    }

    public java.lang.String provideNetworkType() {
        return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public java.lang.String providePath() {
        return "/blockcanary/";
    }

    public java.lang.String provideQualifier() {
        return "Unspecified";
    }

    public java.lang.String provideUid() {
        return "0";
    }

    public java.util.List<java.lang.String> provideWhiteList() {
        return null;
    }

    public boolean stopWhenDebugging() {
        return true;
    }

    public void upload(java.io.File file) {
        throw new java.lang.UnsupportedOperationException();
    }

    public boolean zip(java.io.File[] fileArr, java.io.File file) {
        return false;
    }
}
