package com.bytedance.sdk.openadsdk.api;

/* loaded from: classes22.dex */
public interface TTILog {
    void d(java.lang.String str, java.lang.String str2);

    void e(java.lang.String str, java.lang.String str2);

    void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void e(java.lang.String str, java.lang.Throwable th);

    void flush();

    void forceLogSharding();

    void i(java.lang.String str, java.lang.String str2);

    void v(java.lang.String str, java.lang.String str2);

    void w(java.lang.String str, java.lang.String str2);

    void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void w(java.lang.String str, java.lang.Throwable th);
}
