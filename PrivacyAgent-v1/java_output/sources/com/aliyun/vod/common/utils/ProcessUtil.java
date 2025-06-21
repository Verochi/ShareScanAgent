package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class ProcessUtil {
    public static final boolean isMainThread() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }
}
