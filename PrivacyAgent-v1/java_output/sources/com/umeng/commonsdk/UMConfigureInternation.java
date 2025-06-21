package com.umeng.commonsdk;

/* loaded from: classes19.dex */
public class UMConfigureInternation {
    private static boolean isInternal;

    /* renamed from: com.umeng.commonsdk.UMConfigureInternation$1, reason: invalid class name */
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
                if (android.text.TextUtils.isEmpty(currentProcessName) || android.text.TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName) || !com.umeng.commonsdk.framework.UMEnvelopeBuild.isReadyBuild(this.a, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                    return;
                }
                android.content.Context context = this.a;
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, 32777, com.umeng.commonsdk.internal.b.a(context).a(), null, 5000L);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void doSelfCheck(android.content.Context context) {
        try {
            java.lang.String currentProcessName = com.umeng.commonsdk.framework.UMFrUtils.getCurrentProcessName(context);
            java.lang.String packageName = context.getPackageName();
            if (android.text.TextUtils.isEmpty(currentProcessName) || android.text.TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                return;
            }
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.C, com.umeng.commonsdk.internal.b.a(context).a(), null);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static synchronized void sendInternal(android.content.Context context) {
        synchronized (com.umeng.commonsdk.UMConfigureInternation.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new java.lang.Thread(new com.umeng.commonsdk.UMConfigureInternation.AnonymousClass1(context)).start();
                        isInternal = true;
                    }
                } finally {
                }
            }
        }
    }
}
