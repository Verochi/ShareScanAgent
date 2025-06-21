package com.aliyun.svideosdk.preview.camera;

/* loaded from: classes12.dex */
public class c {
    public static com.aliyun.svideosdk.preview.camera.f a(android.content.Context context, com.aliyun.svideosdk.a.e.a aVar, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter, com.aliyun.svideosdk.preview.utils.CameraVersion.Version version) {
        return version.equals(com.aliyun.svideosdk.preview.utils.CameraVersion.Version.CAMERA2) ? new com.aliyun.svideosdk.preview.camera.b(context, aVar, alivcRecorderReporter) : new com.aliyun.svideosdk.preview.camera.a(aVar, alivcRecorderReporter);
    }
}
