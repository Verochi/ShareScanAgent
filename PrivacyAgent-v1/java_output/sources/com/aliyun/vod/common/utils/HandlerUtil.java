package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class HandlerUtil {

    /* renamed from: com.aliyun.vod.common.utils.HandlerUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.os.Looper val$looper;

        public AnonymousClass1(android.os.Looper looper) {
            this.val$looper = looper;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$looper.quit();
        }
    }

    public static void quitSafely(android.os.Handler handler) {
        quitSafely18(handler.getLooper());
    }

    public static void quitSafely(android.os.HandlerThread handlerThread) {
        quitSafely18(handlerThread);
    }

    @android.annotation.TargetApi(18)
    private static void quitSafely18(android.os.HandlerThread handlerThread) {
        handlerThread.quitSafely();
    }

    @android.annotation.TargetApi(18)
    private static void quitSafely18(android.os.Looper looper) {
        looper.quitSafely();
    }
}
