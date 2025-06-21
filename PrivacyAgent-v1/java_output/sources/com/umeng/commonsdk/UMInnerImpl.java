package com.umeng.commonsdk;

/* loaded from: classes19.dex */
public class UMInnerImpl {
    public static final /* synthetic */ int a = 0;
    private static boolean isInternal;

    /* renamed from: com.umeng.commonsdk.UMInnerImpl$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.String currentProcessName = com.umeng.commonsdk.framework.UMFrUtils.getCurrentProcessName(this.a);
                java.lang.String packageName = this.a.getPackageName();
                if (!android.text.TextUtils.isEmpty(currentProcessName) && !android.text.TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                    try {
                        com.umeng.commonsdk.internal.d.b(this.a);
                    } catch (java.lang.Throwable th) {
                        com.umeng.commonsdk.statistics.common.ULog.e(com.umeng.commonsdk.framework.UMModuleRegister.INNER, "e is " + th);
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.a, th2);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.UMInnerImpl$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.String currentProcessName = com.umeng.commonsdk.framework.UMFrUtils.getCurrentProcessName(this.a);
                java.lang.String packageName = this.a.getPackageName();
                if (android.text.TextUtils.isEmpty(currentProcessName) || android.text.TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                    return;
                }
                try {
                    if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && !com.umeng.commonsdk.internal.utils.c.a(this.a).a()) {
                        com.umeng.commonsdk.internal.utils.c.a(this.a).b();
                    }
                } catch (java.lang.Throwable th) {
                    com.umeng.commonsdk.statistics.common.ULog.e(com.umeng.commonsdk.framework.UMModuleRegister.INNER, "e is " + th);
                }
                try {
                    com.umeng.commonsdk.internal.utils.k.b(this.a);
                } catch (java.lang.Throwable th2) {
                    com.umeng.commonsdk.statistics.common.ULog.e(com.umeng.commonsdk.framework.UMModuleRegister.INNER, "e is " + th2);
                }
            } catch (java.lang.Throwable th3) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.a, th3);
            }
        }
    }

    public static synchronized void initAndSendInternal(android.content.Context context) {
        synchronized (com.umeng.commonsdk.UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new java.lang.Thread(new com.umeng.commonsdk.UMInnerImpl.AnonymousClass2(context)).start();
                        isInternal = true;
                        sendInternal(context);
                    }
                } finally {
                }
            }
        }
    }

    private static synchronized void sendInternal(android.content.Context context) {
        synchronized (com.umeng.commonsdk.UMInnerImpl.class) {
            if (context != null) {
                try {
                    new java.lang.Thread(new com.umeng.commonsdk.UMInnerImpl.AnonymousClass1(context)).start();
                    isInternal = true;
                } finally {
                }
            }
        }
    }
}
