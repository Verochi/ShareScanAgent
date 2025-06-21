package com.umeng.commonsdk;

/* loaded from: classes19.dex */
public class UMConfigureImpl {
    private static final int e = 1000;
    private static java.util.concurrent.ScheduledExecutorService f;
    private static android.content.Context g;
    private static java.lang.String a = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.o);
    private static java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> b = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static int c = 0;
    private static boolean d = false;
    private static int h = 0;
    private static java.lang.Runnable i = new com.umeng.commonsdk.UMConfigureImpl.AnonymousClass1();

    /* renamed from: com.umeng.commonsdk.UMConfigureImpl$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.umeng.commonsdk.UMConfigureImpl.c == 0 || com.umeng.commonsdk.UMConfigureImpl.h >= 10) {
                    if (!com.umeng.commonsdk.UMConfigureImpl.d) {
                        boolean unused = com.umeng.commonsdk.UMConfigureImpl.d = true;
                        com.umeng.commonsdk.UMConfigureImpl.b(com.umeng.commonsdk.UMConfigureImpl.g);
                    }
                    if (com.umeng.commonsdk.UMConfigureImpl.f != null) {
                        com.umeng.commonsdk.UMConfigureImpl.f.shutdown();
                        java.util.concurrent.ScheduledExecutorService unused2 = com.umeng.commonsdk.UMConfigureImpl.f = null;
                    }
                }
                com.umeng.commonsdk.UMConfigureImpl.f();
            } catch (java.lang.Exception unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(android.content.Context context) {
        synchronized (com.umeng.commonsdk.UMConfigureImpl.class) {
            try {
                com.umeng.commonsdk.framework.UMEnvelopeBuild.setTransmissionSendFlag(true);
                java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> copyOnWriteArrayList = b;
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    java.util.Iterator<com.umeng.commonsdk.utils.onMessageSendListener> it = b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void c(android.content.Context context) {
        try {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(a, true);
                edit.commit();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean d(android.content.Context context) {
        try {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(a, false);
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ int f() {
        int i2 = h;
        h = i2 + 1;
        return i2;
    }

    public static void init(android.content.Context context) {
        if (context == null) {
            return;
        }
        g = context;
        try {
            if (c < 1) {
                com.umeng.commonsdk.framework.UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else if (d(context)) {
                com.umeng.commonsdk.framework.UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                com.umeng.commonsdk.framework.UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f == null) {
                    java.util.concurrent.ScheduledExecutorService newScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(1);
                    f = newScheduledThreadPool;
                    newScheduledThreadPool.scheduleAtFixedRate(i, 0L, 100L, java.util.concurrent.TimeUnit.MILLISECONDS);
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static synchronized void registerInterruptFlag() {
        synchronized (com.umeng.commonsdk.UMConfigureImpl.class) {
            try {
                c++;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static synchronized void registerMessageSendListener(com.umeng.commonsdk.utils.onMessageSendListener onmessagesendlistener) {
        java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> copyOnWriteArrayList;
        synchronized (com.umeng.commonsdk.UMConfigureImpl.class) {
            try {
                java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> copyOnWriteArrayList2 = b;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.add(onmessagesendlistener);
                }
                if (com.umeng.commonsdk.framework.UMEnvelopeBuild.getTransmissionSendFlag() && (copyOnWriteArrayList = b) != null && copyOnWriteArrayList.size() > 0) {
                    java.util.Iterator<com.umeng.commonsdk.utils.onMessageSendListener> it = b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static synchronized void removeInterruptFlag() {
        synchronized (com.umeng.commonsdk.UMConfigureImpl.class) {
            try {
                c--;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static synchronized void removeMessageSendListener(com.umeng.commonsdk.utils.onMessageSendListener onmessagesendlistener) {
        synchronized (com.umeng.commonsdk.UMConfigureImpl.class) {
            try {
                java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> copyOnWriteArrayList = b;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.remove(onmessagesendlistener);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
