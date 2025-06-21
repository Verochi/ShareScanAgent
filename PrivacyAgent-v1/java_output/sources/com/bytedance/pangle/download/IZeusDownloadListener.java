package com.bytedance.pangle.download;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public interface IZeusDownloadListener {
    void onFailed(java.lang.Throwable th, int i, java.lang.String str);

    void onProgress(long j, long j2);

    void onStart();

    void onSuccess(java.lang.String str, java.lang.String str2, long j);
}
