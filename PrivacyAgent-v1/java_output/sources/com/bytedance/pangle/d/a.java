package com.bytedance.pangle.d;

/* loaded from: classes12.dex */
public class a {
    private static java.lang.Class a;
    private static java.lang.Object b;

    /* renamed from: com.bytedance.pangle.d.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;

        public AnonymousClass1(java.lang.Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    java.lang.Object unused = com.bytedance.pangle.d.a.b = com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(com.bytedance.pangle.d.a.a, "currentActivityThread", new java.lang.Object[0]);
                    synchronized (this.a) {
                        this.a.notify();
                    }
                } catch (java.lang.Exception e) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                    synchronized (this.a) {
                        this.a.notify();
                    }
                }
            } catch (java.lang.Throwable th) {
                synchronized (this.a) {
                    this.a.notify();
                    throw th;
                }
            }
        }
    }

    public static final java.lang.Object a() {
        if (b == null) {
            try {
                synchronized (com.bytedance.pangle.d.a.class) {
                    if (b == null) {
                        if (a == null) {
                            a = java.lang.Class.forName("android.app.ActivityThread");
                        }
                        b = com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(a, "currentActivityThread", new java.lang.Object[0]);
                    }
                    if (b == null && android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                        java.lang.Object obj = new java.lang.Object();
                        new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.bytedance.pangle.d.a.AnonymousClass1(obj));
                        if (b == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (java.lang.InterruptedException e) {
                                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Exception e2) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
            }
        }
        return b;
    }
}
