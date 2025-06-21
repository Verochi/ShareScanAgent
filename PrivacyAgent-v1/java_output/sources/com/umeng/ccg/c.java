package com.umeng.ccg;

/* loaded from: classes19.dex */
public class c {
    public static android.os.Handler a = null;
    public static final int b = 101;
    public static final int c = 102;
    public static final int d = 103;
    public static final int e = 104;
    public static final int f = 105;
    public static final int g = 106;
    public static final int h = 107;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 201;
    public static final int m = 202;
    public static final int n = 203;
    public static final int o = 301;
    public static final int p = 302;
    public static final int q = 303;
    public static final int r = 304;

    /* renamed from: s, reason: collision with root package name */
    public static final int f452s = 305;
    private static android.os.HandlerThread t = null;
    private static java.util.HashMap<java.lang.Integer, com.umeng.ccg.c.a> u = null;
    private static final int v = 256;

    /* renamed from: com.umeng.ccg.c$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 256) {
                return;
            }
            com.umeng.ccg.c.b(message);
        }
    }

    public interface a {
        void a(java.lang.Object obj, int i);
    }

    private c() {
    }

    private static synchronized void a() {
        synchronized (com.umeng.ccg.c.class) {
            try {
                if (t == null) {
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread("ccg_dispatch");
                    t = handlerThread;
                    handlerThread.start();
                    if (a == null) {
                        a = new com.umeng.ccg.c.AnonymousClass1(t.getLooper());
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(android.content.Context context, int i2, int i3, com.umeng.ccg.c.a aVar, java.lang.Object obj, long j2) {
        if (context == null || aVar == null) {
            return;
        }
        if (u == null) {
            u = new java.util.HashMap<>();
        }
        java.lang.Integer valueOf = java.lang.Integer.valueOf(i3 / 100);
        if (!u.containsKey(valueOf)) {
            u.put(valueOf, aVar);
        }
        if (t == null || a == null) {
            a();
        }
        try {
            android.os.Handler handler = a;
            if (handler != null) {
                android.os.Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i2;
                obtainMessage.arg1 = i3;
                obtainMessage.obj = obj;
                a.sendMessageDelayed(obtainMessage, j2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, int i2, com.umeng.ccg.c.a aVar, java.lang.Object obj) {
        a(context, 256, i2, aVar, obj, 0L);
    }

    public static void a(android.content.Context context, int i2, com.umeng.ccg.c.a aVar, java.lang.Object obj, long j2) {
        a(context, 256, i2, aVar, obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.os.Message message) {
        int i2 = message.arg1;
        java.lang.Object obj = message.obj;
        java.lang.Integer valueOf = java.lang.Integer.valueOf(i2 / 100);
        java.util.HashMap<java.lang.Integer, com.umeng.ccg.c.a> hashMap = u;
        if (hashMap == null) {
            return;
        }
        com.umeng.ccg.c.a aVar = hashMap.containsKey(valueOf) ? u.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i2);
        }
    }
}
