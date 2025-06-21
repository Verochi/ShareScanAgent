package com.aliyun.vod.common.logger;

/* loaded from: classes12.dex */
public interface Printer {
    void clear();

    void d(java.lang.String str, java.lang.Object... objArr);

    void e(java.lang.String str, java.lang.Object... objArr);

    void e(java.lang.Throwable th);

    void e(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr);

    com.aliyun.vod.common.logger.Settings getSettings();

    void i(java.lang.String str, java.lang.Object... objArr);

    void json(java.lang.String str);

    com.aliyun.vod.common.logger.Printer t(java.lang.String str, int i);

    void v(java.lang.String str, java.lang.Object... objArr);

    void w(java.lang.String str, java.lang.Object... objArr);

    void wtf(java.lang.String str, java.lang.Object... objArr);

    void xml(java.lang.String str);
}
