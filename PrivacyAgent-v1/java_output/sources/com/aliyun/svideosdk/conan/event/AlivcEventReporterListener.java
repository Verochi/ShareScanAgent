package com.aliyun.svideosdk.conan.event;

@com.aliyun.svideosdk.conan.DoNotProguard
/* loaded from: classes12.dex */
public abstract class AlivcEventReporterListener {
    @com.aliyun.svideosdk.conan.DoNotProguard
    public abstract void OnStsExpired(com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter);

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void onEventReport(com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter, java.util.Map<java.lang.String, java.lang.String> map) {
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public abstract void onEventReportErrorOccur(com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter, int i);

    @com.aliyun.svideosdk.conan.DoNotProguard
    public abstract void onStsWillExpireSoon(com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter, long j);
}
