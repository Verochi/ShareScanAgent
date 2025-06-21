package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class AssetsUtil {
    private static final int GET_SP_TIMEOUT = 5;
    private static final java.lang.String TAG = "AssetsUtil";
    private static final java.lang.String THREAD_NAME = "AssetsUtil_Operate";
    private static final java.util.concurrent.ExecutorService EXECUTOR_SERVICE = com.huawei.hms.framework.common.ExecutorsUtils.newSingleThreadExecutor(THREAD_NAME);

    /* renamed from: com.huawei.hms.framework.common.AssetsUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.Callable<java.lang.String[]> {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String val$path;

        public AnonymousClass1(android.content.Context context, java.lang.String str) {
            this.val$context = context;
            this.val$path = str;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.String[] call() throws java.lang.Exception {
            return this.val$context.getAssets().list(this.val$path);
        }
    }

    public static java.lang.String[] list(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return new java.lang.String[0];
        }
        java.util.concurrent.FutureTask futureTask = new java.util.concurrent.FutureTask(new com.huawei.hms.framework.common.AssetsUtil.AnonymousClass1(context, str));
        EXECUTOR_SERVICE.execute(futureTask);
        try {
            return (java.lang.String[]) futureTask.get(5L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.util.concurrent.TimeoutException unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, "get local config files from sp task timed out");
            return new java.lang.String[0];
        } catch (java.lang.Exception unused2) {
            com.huawei.hms.framework.common.Logger.w(TAG, "get local config files from sp task occur unknown Exception");
            return new java.lang.String[0];
        } catch (java.lang.InterruptedException e) {
            com.huawei.hms.framework.common.Logger.w(TAG, "get local config files from sp task interrupted", e);
            return new java.lang.String[0];
        } catch (java.util.concurrent.ExecutionException e2) {
            com.huawei.hms.framework.common.Logger.w(TAG, "get local config files from sp task failed", e2);
            return new java.lang.String[0];
        } finally {
            futureTask.cancel(true);
        }
    }

    public static java.io.InputStream open(android.content.Context context, java.lang.String str) throws java.io.IOException {
        if (context == null) {
            com.huawei.hms.framework.common.Logger.w(TAG, com.anythink.expressad.foundation.g.b.b.a);
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "AssetManager has been destroyed", e);
            return null;
        }
    }
}
