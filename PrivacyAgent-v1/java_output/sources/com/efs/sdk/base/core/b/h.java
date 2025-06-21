package com.efs.sdk.base.core.b;

/* loaded from: classes22.dex */
public final class h {
    static java.nio.channels.FileLock b;
    volatile int a;

    /* renamed from: com.efs.sdk.base.core.b.h$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.nio.channels.FileLock lock;
            try {
                java.io.File a = com.efs.sdk.base.core.util.a.a(this.a);
                if (!a.exists()) {
                    a.mkdirs();
                }
                java.io.File file = new java.io.File(a.getPath() + java.io.File.separator + "sendlock");
                if (!file.exists()) {
                    file.createNewFile();
                }
                do {
                    lock = new java.io.FileOutputStream(file).getChannel().lock();
                    com.efs.sdk.base.core.b.h.b = lock;
                } while (!lock.isValid());
                com.efs.sdk.base.core.util.Log.w("efs.send_log", "tryFileLock sendlock sucess! processname: " + com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName());
                com.efs.sdk.base.core.b.h.this.a = 2;
            } catch (java.lang.Exception e) {
                com.efs.sdk.base.core.util.Log.w("efs.send_log", "tryFileLock fail! " + e.getMessage());
                com.efs.sdk.base.core.b.h.this.a = 0;
            }
        }
    }

    public static class a {
        private static final com.efs.sdk.base.core.b.h a = new com.efs.sdk.base.core.b.h((byte) 0);
    }

    private h() {
        this.a = 0;
        a(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    public /* synthetic */ h(byte b2) {
        this();
    }

    private synchronized void a(android.content.Context context) {
        com.efs.sdk.base.core.util.Log.w("efs.send_log", "tryFileLock start! ");
        this.a = 1;
        new java.lang.Thread(new com.efs.sdk.base.core.b.h.AnonymousClass1(context)).start();
    }

    public final boolean a() {
        if (this.a == 2) {
            return true;
        }
        if (this.a != 0) {
            return false;
        }
        a(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext);
        return false;
    }
}
